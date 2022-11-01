package com.weiwei.fluentlayout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.LayoutInflaterCompat
import com.weiwei.fluentview.view.WindowInsetsEdgeDelegate
import com.weiwei.fluentlayout.performance.AppStartMonitor

class MainActivity : AppCompatActivity() {
  companion object {
    private const val TAG = "TEST_TAG"
  }

  private val ignoreNameList: MutableList<String> = mutableListOf<String>().apply {
    add("LinearLayout")
    add("ViewStub")
    add("FrameLayout")
    add("androidx.appcompat.widget.ActionBarOverlayLayout")
    add("androidx.appcompat.widget.ContentFrameLayout")
    add("androidx.appcompat.widget.ActionBarContainer")
    add("androidx.appcompat.widget.Toolbar")
    add("androidx.appcompat.widget.ActionBarContextView")
  }

  private var inflateTimeUs: Long = 0L

  private fun installFactory2() {
    LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), object : LayoutInflater.Factory2 {
      override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {
        if (ignoreNameList.size > 0 && ignoreNameList.contains(name)) {
          ignoreNameList.remove(name)
          return delegate.createView(parent, name, context, attrs)
        }

        val startNs = System.nanoTime()
        val view = delegate.createView(parent, name, context, attrs)
        val viewName = view?.let { it::class.simpleName }
        val costUs = (System.nanoTime() - startNs) / 1000

        inflateTimeUs += costUs
        Log.d(TAG, "name=$name view=$viewName costUs=$costUs  sumUs=$inflateTimeUs")
        return view
      }

      override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? = null
    })
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    installFactory2()
    super.onCreate(savedInstanceState)

    WindowInsetsEdgeDelegate(this).start()

    AppStartMonitor.recordTime("MainCreate")

    val st = System.currentTimeMillis()
    Log.d(TAG, "MainCreate: st=$st")

    // setContentView(R.layout.activity_traditional_layout)
    // val contentLayout: View = findViewById(R.id.contentLayout)
    // setContentView(R.layout.activity_constraint_layout)
    // val contentLayout: View = findViewById(R.id.contentLayout)
    // setContentView(R.layout.activity_constraint_multi_layout)
    // val contentLayout: View = findViewById(R.id.contentLayout)

    // val contentLayout = MainConstraintLayout(this)
    // setContentView(contentLayout)
    // val contentLayout = MainConstraintLayout2(this)
    // setContentView(contentLayout)
    val contentLayout = MainConstraintMultiLayout2(this)
    setContentView(contentLayout)

    contentLayout.setOnClickListener {
      startActivity(Intent(this, SecondActivity::class.java))
    }

    // val delegate = object : AsyncViewDelegate(this) {
    //   override fun onCreateView(activity: AppCompatActivity): View {
    //     return MainConstraintMultiLayout2(activity)
    //   }
    //
    //   override fun onViewCreated(rootView: View) {
    //     rootView.setBackgroundColor(Color.WHITE)
    //   }
    //
    //   override fun onDestroy() {
    //     // destroy
    //   }
    // }
    // delegate.attach()

    val et = System.currentTimeMillis()
    Log.d(TAG, "MainViewCreated: et=$et, du=${et - st}")

    AppStartMonitor.recordTime("MainCreate", "MainViewCreated")

    // contentLayout.doOnPreDraw {
    //   AppStartMonitor.recordTime("MainCreate", "MainPreDraw")
    // }
  }

  override fun onResume() {
    super.onResume()
    AppStartMonitor.recordTime("MainCreate", "MainResume")
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    AppStartMonitor.recordTime("MainCreate", "MainAttachedToWindow")
  }

  override fun onWindowFocusChanged(hasFocus: Boolean) {
    super.onWindowFocusChanged(hasFocus)
    if (hasFocus) {
      AppStartMonitor.recordTime("MainCreate", "MainWindowFocus")
      AppStartMonitor.recordDuration("MainViewInflateUs", inflateTimeUs)
      AppStartMonitor.end(true)
    }
  }
}
