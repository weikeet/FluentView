package com.weikeet.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.core.view.forEach
import androidx.core.view.isGone
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop

/**
 * @author weiwei
 * @date 2021.03.22
 *
 * reference [@drakeet](https://github.com/drakeet) CustomLayout
 */
@Suppress("MemberVisibilityCanBePrivate")
abstract class FluentLayout : ViewGroup {

  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  class LayoutParams(width: Int, height: Int) : MarginLayoutParams(width, height)

  override fun generateDefaultLayoutParams(): LayoutParams {
    return LayoutParams(matchParent, wrapContent)
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    this.onMeasureChildren(widthMeasureSpec, heightMeasureSpec)
  }

  protected abstract fun onMeasureChildren(widthMeasureSpec: Int, heightMeasureSpec: Int)

  protected fun View.autoMeasure() {
    if (isGone) return
    measure(
      this.defaultWidthMeasureSpec(parentView = this@FluentLayout),
      this.defaultHeightMeasureSpec(parentView = this@FluentLayout)
    )
  }

  protected fun View.forEachAutoMeasure() {
    forEach { it.autoMeasure() }
  }

  protected fun View.layout(x: Int, y: Int, fromRight: Boolean = false) {
    if (isGone) return
    if (!fromRight) {
      layout(x, y, x + measuredWidth, y + measuredHeight)
    } else {
      layout(this@FluentLayout.measuredWidth - x - measuredWidth, y)
    }
  }

  protected val View.measuredWidthWithMargins get() = (measuredWidth + marginLeft + marginRight)
  protected val View.measuredHeightWithMargins get() = (measuredHeight + marginTop + marginBottom)

  protected fun View.defaultWidthMeasureSpec(parentView: ViewGroup): Int {
    return when (layoutParams.width) {
      ViewGroup.LayoutParams.MATCH_PARENT -> parentView.measuredWidth.toExactlyMeasureSpec()
      ViewGroup.LayoutParams.WRAP_CONTENT -> Int.MAX_VALUE.toAtMostMeasureSpec()
      0 -> throw IllegalAccessException("Need special treatment for $this")
      else -> layoutParams.width.toExactlyMeasureSpec()
    }
  }

  protected fun View.defaultHeightMeasureSpec(parentView: ViewGroup): Int {
    return when (layoutParams.height) {
      ViewGroup.LayoutParams.MATCH_PARENT -> parentView.measuredHeight.toExactlyMeasureSpec()
      ViewGroup.LayoutParams.WRAP_CONTENT -> Int.MAX_VALUE.toAtMostMeasureSpec()
      0 -> throw IllegalAccessException("Need special treatment for $this")
      else -> layoutParams.height.toExactlyMeasureSpec()
    }
  }

  protected fun Int.toExactlyMeasureSpec(): Int {
    return MeasureSpec.makeMeasureSpec(this, MeasureSpec.EXACTLY)
  }

  protected fun Int.toAtMostMeasureSpec(): Int {
    return MeasureSpec.makeMeasureSpec(this, MeasureSpec.AT_MOST)
  }

  fun addView(child: View, width: Int, height: Int, apply: (LayoutParams.() -> Unit)) {
    val params = generateDefaultLayoutParams()
    params.width = width
    params.height = height
    apply(params)
    super.addView(child, params)
  }

  fun View.overScrollNever() {
    overScrollMode = View.OVER_SCROLL_NEVER
  }

  fun ViewGroup.horizontalCenterX(child: View): Int {
    return (measuredWidth - child.measuredWidth) / 2
  }

  fun ViewGroup.verticalCenterTop(child: View): Int {
    return (measuredHeight - child.measuredHeight) / 2
  }
}
