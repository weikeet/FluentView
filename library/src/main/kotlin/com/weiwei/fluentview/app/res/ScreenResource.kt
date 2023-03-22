package com.weiwei.fluentview.app.res

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.view.WindowManager
import com.weiwei.fluentview.app.mainContext

/**
 * @author weiwei
 * @date 2023.01.09
 */

val screenWidthPixels: Int by lazy(LazyThreadSafetyMode.NONE) {
  // Resources.getSystem().displayMetrics.widthPixels
  mainContext.resources.displayMetrics.widthPixels
}

// 一般来说是 屏幕真实高度 - 虚拟导航栏/手势导航栏高度, see: https://juejin.cn/post/6908862707374489607
val screenHeightPixels: Int by lazy(LazyThreadSafetyMode.NONE) {
  // Resources.getSystem().displayMetrics.heightPixels
  mainContext.resources.displayMetrics.heightPixels
}

// 屏幕真实宽度
val screenWidth: Int by lazy(LazyThreadSafetyMode.NONE) {
  val wm = mainContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    wm.currentWindowMetrics.bounds.width()
  } else {
    @Suppress("DEPRECATION")
    Point().also { wm.defaultDisplay.getRealSize(it) }.x
  }
}

// 屏幕真实高度
val screenHeight: Int by lazy(LazyThreadSafetyMode.NONE) {
  val wm = mainContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    wm.currentWindowMetrics.bounds.height()
  } else {
    @Suppress("DEPRECATION")
    Point().also { wm.defaultDisplay.getRealSize(it) }.y
  }
}
