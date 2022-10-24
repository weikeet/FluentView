package com.weiwei.fluentlayout.async

import android.content.Context
import android.os.Handler
import android.os.HandlerThread
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import java.lang.ref.WeakReference

/**
 * @author weiwei
 * @date 2022.05.30
 */
abstract class AsyncViewThread(
  activity: AppCompatActivity,
  name: String = "AsyncUiThread"
) : HandlerThread(name), LifecycleEventObserver {

  private val activityRef = WeakReference(activity)

  private var rootView: View? = null

  private var wm: WindowManager? = null

  private var uiHandler: Handler? = null

  fun post(block: () -> Unit) {
    uiHandler?.post {
      block()
    }
  }

  fun postDelay(mills: Long, block: () -> Unit) {
    uiHandler?.postDelayed({
      block()
    }, mills)
  }


  abstract fun onCreateView(activity: AppCompatActivity): View

  abstract fun onViewCreated(rootView: View)

  abstract fun onDestroy()

  fun attach() {
    start()
    uiHandler = Handler(looper)
    uiHandler?.post {
      val activity: AppCompatActivity = activityRef.get()
        ?: throw RuntimeException("activityRef get is null")
      val rootView: View = onCreateView(activity)

      // val wm = activity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
      // val param = WindowManager.LayoutParams()
      // param.width = WindowManager.LayoutParams.MATCH_PARENT
      // param.height = WindowManager.LayoutParams.MATCH_PARENT
      // wm.addView(rootView, param)
      //
      // this.rootView = rootView
      // this.wm = wm

      activity.setContentView(rootView)

      // //处理返回键
      // rootView.isFocusable = true
      // rootView.isFocusableInTouchMode = true
      // rootView.requestFocus()
      //
      // rootView.setOnKeyListener { _, keyCode, event ->
      //   if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
      //     onBackClicked()
      //     true
      //   } else {
      //     false
      //   }
      // }

      onViewCreated(rootView)
    }

    activityRef.get()?.lifecycle?.addObserver(this)
  }

  // open fun onBackClicked() {
  //   uiHandler?.let { handler ->
  //     handler.removeCallbacksAndMessages(null)
  //     wm?.removeViewImmediate(rootView)
  //     rootView = null
  //     wm = null
  //   }
  //   uiHandler = null
  //   activityRef.get()?.finish()
  // }

  override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
    if (event == Lifecycle.Event.ON_DESTROY) {
      uiHandler?.let { handler ->
        handler.removeCallbacksAndMessages(null)
        wm?.removeViewImmediate(rootView)
        rootView = null
        wm = null
      }
      uiHandler = null

      quitSafely()
      onDestroy()
    }
  }
}