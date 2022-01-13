package com.weiwei.fluent.widget.extensions

import android.graphics.Color
import android.view.HapticFeedbackConstants
import android.view.View
import android.view.ViewGroup

/**
 * @author weiwei
 * @date 2022.01.13
 */

fun View.transparentBackground() {
  setBackgroundColor(Color.TRANSPARENT)
}

val View.parentView get() = parent as ViewGroup

fun View?.performHapticFeedbackSafely() {
  try {
    this?.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
  } catch (t: Throwable) {
  }
}
