package com.weicools.kotlinlayout

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.LayoutInflaterCompat
import androidx.core.view.doOnPreDraw
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
  companion object {
    private const val TAG = "TEST_TAG"
  }

  override fun onWindowFocusChanged(hasFocus: Boolean) {
    super.onWindowFocusChanged(hasFocus)
    if (hasFocus) {
      TimeRecorder.recordStopTime()
    }
  }

  private lateinit var gson: Gson
  private lateinit var preferences: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    installFactory2()
    super.onCreate(savedInstanceState)

    gson = Gson()
    preferences = getSharedPreferences("main_start_time", Context.MODE_PRIVATE)

    val mainInflateTimeList = getTimeList("Main_Inflate_Times")
    val createPreDrawTimeList = getTimeList("Create_PreDraw_Times")

    val createTime = System.currentTimeMillis()

    // setContentView(R.layout.activity_traditional_layout)
    // setContentView(R.layout.activity_constraint_layout)
    // val contentLayout: ViewGroup = findViewById(R.id.contentLayout)

    // val contentLayout = MainConstraintLayout(this)
    val contentLayout = MainConstraintLayout2(this)
    setContentView(contentLayout)

    contentLayout.doOnPreDraw {
      mainInflateTimeList.add(sumUs)
      createPreDrawTimeList.add(System.currentTimeMillis() - createTime)

      val editor = preferences.edit()
      editor.clear()
      editor.putString("Main_Inflate_Times", gson.toJson(mainInflateTimeList))
      editor.putString("Create_PreDraw_Times", gson.toJson(createPreDrawTimeList))
      editor.apply()
    }

    contentLayout.setOnClickListener {
      val inflateTimeList = getTimeList("Main_Inflate_Times")
      inflateTimeList.remove(0)
      var inflateTotalTime = 0L
      for (t in inflateTimeList) {
        inflateTotalTime += t
      }
      val inflateAvgTime = inflateTotalTime / inflateTimeList.size
      Log.d(TAG, "onCreate: inflateAvgTime=$inflateAvgTime inflateTimeList=$inflateTimeList")

      val preDrawTimeList = getTimeList("Create_PreDraw_Times")
      preDrawTimeList.remove(0)
      var preDrawTotalTime = 0L
      for (t in preDrawTimeList) {
        preDrawTotalTime += t
      }
      val preDrawAvgTime = preDrawTotalTime / preDrawTimeList.size
      Log.d(TAG, "onCreate: preDrawAvgTime=$preDrawAvgTime preDrawTimeList=$preDrawTimeList")
    }
  }

  private var sumUs: Long = 0L
  private fun installFactory2() {
    LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), object : LayoutInflater.Factory2 {
      override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {
        val startNs = System.nanoTime()
        val view = delegate.createView(parent, name, context, attrs)
        val costUs = (System.nanoTime() - startNs) / 1000
        sumUs += costUs
        Log.d(TAG, "view=${view?.let { it::class.simpleName }} costUs=$costUs  sumUs=$sumUs")
        return view
      }

      override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? = null
    })
  }

  private fun getTimeList(timeKey: String): ArrayList<Long> {
    val times = preferences.getString(timeKey, "")
    return if (TextUtils.isEmpty(times)) {
      ArrayList()
    } else {
      gson.fromJson(times, object : TypeToken<ArrayList<Long>>() {}.type)
    }
  }
}
