package com.weicools.kotlinlayout

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.LayoutInflaterCompat
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

class MainActivity : AppCompatActivity() {
  companion object {
    private const val TEST_TAG = "TEST_TAG"
  }

  override fun onWindowFocusChanged(hasFocus: Boolean) {
    super.onWindowFocusChanged(hasFocus)
    if (hasFocus) {
      TimeRecorder.recordStopTime()
    }
  }

  @ExperimentalTime
  override fun onCreate(savedInstanceState: Bundle?) {
    LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), object : LayoutInflater.Factory2 {
      private var sumMs: Double = 0.0
      override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {
        val (view, cost) = measureTimedValue { delegate.createView(parent, name, context, attrs) }
        sumMs += cost.inMilliseconds
        Log.d(TEST_TAG, "view=${view?.let { it::class.simpleName }} cost=${cost}  sumMs=${sumMs}")
        return view
      }

      // private var sumUs: Float = 0f
      // override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {
      //   val startNs = System.nanoTime()
      //   val view = delegate.createView(parent, name, context, attrs)
      //   val costUs = (System.nanoTime() - startNs) / 1000f
      //   sumUs += costUs
      //
      //   Log.d(TEST_TAG, "view=${view?.let { it::class.simpleName }} costUs=${costUs}  sumMs=${sumUs / 1000f}")
      //   return view
      // }

      override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return null
      }
    })
    super.onCreate(savedInstanceState)

    // setContentView(R.layout.activity_traditional_layout)
    // setContentView(R.layout.activity_constraint_layout)
    val v = MainConstraintLayout(this)
    setContentView(v)
  }
}
