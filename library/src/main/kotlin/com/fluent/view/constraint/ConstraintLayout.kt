package com.fluent.view.constraint

import android.content.Context
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.fluent.annotation.NO_GETTER
import com.fluent.annotation.noGetter
import com.fluent.view.wrapContent
import com.fluent.view.wrapContextIfNeeded

//region constraintLayout
inline fun ViewGroup.constraintLayout(id: Int? = null, style: Int? = null, init: ConstraintLayout.() -> Unit): ConstraintLayout {
  val widget = ConstraintLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.constraintLayout(id: Int? = null, style: Int? = null, init: ConstraintLayout.() -> Unit): ConstraintLayout {
  val widget = ConstraintLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

inline fun constraintParams(width: Int = wrapContent, height: Int = wrapContent, init: ConstraintLayout.LayoutParams.() -> Unit) =
  ConstraintLayout.LayoutParams(width, height).apply(init)

//region ConstraintLayout.LayoutParams const
const val parentId = ConstraintLayout.LayoutParams.PARENT_ID

const val chainSpread = ConstraintLayout.LayoutParams.CHAIN_SPREAD
const val chainPacked = ConstraintLayout.LayoutParams.CHAIN_PACKED
const val chainSpreadInside = ConstraintLayout.LayoutParams.CHAIN_SPREAD_INSIDE

const val constraintHorizontal = ConstraintLayout.LayoutParams.HORIZONTAL
const val constraintVertical = ConstraintLayout.LayoutParams.VERTICAL
//endregion

//region ConstraintLayout.LayoutParams extension field
inline var ConstraintLayout.LayoutParams.centerOf: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    leftToLeft = value
    topToTop = value
    rightToRight = value
    bottomToBottom = value
  }

inline var ConstraintLayout.LayoutParams.centerHorizontalOf: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    leftToLeft = value
    rightToRight = value
  }

inline var ConstraintLayout.LayoutParams.centerVerticalOf: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    topToTop = value
    bottomToBottom = value
  }
//endregion
