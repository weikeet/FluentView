package com.weiwei.fluentlayout.async

import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * @author weiwei
 * @date 2022.05.30
 */
open class AsyncViewDelegate(activity: AppCompatActivity) {
  val uiThread = object : AsyncViewThread(activity) {
    override fun onCreateView(activity: AppCompatActivity): View {
      return this@AsyncViewDelegate.onCreateView(activity)
    }

    override fun onViewCreated(rootView: View) {
      this@AsyncViewDelegate.onViewCreated(rootView)
    }

    override fun onDestroy() {
      this@AsyncViewDelegate.onDestroy()
    }
  }

  open fun onCreateView(activity: AppCompatActivity): View = View(activity)

  open fun onViewCreated(rootView: View) {}

  open fun onDestroy() {}

  fun attach() = uiThread.attach()

  fun post(block: () -> Unit) = uiThread.post(block)

  fun postDelay(mills: Long, block: () -> Unit) = uiThread.postDelay(mills, block)

}