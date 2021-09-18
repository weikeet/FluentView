package com.weicools.fluentlayout.layout

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop

/**
 * @author weicools
 * @date 2021.03.22
 */
@Suppress("MemberVisibilityCanBePrivate")
abstract class CustomLayout(context: Context) : ViewGroup(context) {
  protected fun View.autoMeasure() {
    measure(
      this.defaultWidthMeasureSpec(this@CustomLayout),
      this.defaultHeightMeasureSpec(this@CustomLayout)
    )
  }

  protected fun View.layout(x: Int, y: Int, fromRight: Boolean = false) {
    if (fromRight) {
      layout(this@CustomLayout.measuredWidth - x - measuredWidth, y)
    } else {
      layout(x, y, x + measuredWidth, y + measuredHeight)
    }
  }

  protected val View.measuredWidthWithMargins get() = (measuredWidth + marginLeft + marginRight)
  protected val View.measuredHeightWithMargins get() = (measuredWidth + marginTop + marginBottom)

  protected fun Int.toExactlyMeasureSpec() = MeasureSpec.makeMeasureSpec(this, MeasureSpec.EXACTLY)
  protected fun Int.toAtMostMeasureSpec() = MeasureSpec.makeMeasureSpec(this, MeasureSpec.AT_MOST)

  protected val Int.dp: Int get() = (this * resources.displayMetrics.density + 0.5f).toInt()

  protected fun View.defaultWidthMeasureSpec(parentView: ViewGroup): Int {
    return when (layoutParams.width) {
      LayoutParams.MATCH_PARENT -> parentView.measuredWidth.toExactlyMeasureSpec()
      LayoutParams.WRAP_CONTENT -> LayoutParams.WRAP_CONTENT.toAtMostMeasureSpec()
      0 -> throw IllegalAccessException("Need special treatment for $this")
      else -> layoutParams.width.toExactlyMeasureSpec()
    }
  }

  protected fun View.defaultHeightMeasureSpec(parentView: ViewGroup): Int {
    return when (layoutParams.height) {
      LayoutParams.MATCH_PARENT -> parentView.measuredHeight.toExactlyMeasureSpec()
      LayoutParams.WRAP_CONTENT -> LayoutParams.WRAP_CONTENT.toAtMostMeasureSpec()
      0 -> throw IllegalAccessException("Need special treatment for $this")
      else -> layoutParams.height.toExactlyMeasureSpec()
    }
  }
}