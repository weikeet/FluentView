package com.weicools.kotlinlayout

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.core.os.HandlerCompat

/**
 * @author weicools
 * @date 2021.04.21
 */
object AppGlobal {
  @JvmStatic
  val handler: Handler = Handler(Looper.getMainLooper())

  @JvmStatic
  val asyncHandler: Handler = HandlerCompat.createAsync(Looper.getMainLooper())

  @JvmStatic
  lateinit var appContext: Context
}