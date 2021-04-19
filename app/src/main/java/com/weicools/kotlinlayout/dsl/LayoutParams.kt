@file:Suppress("FunctionName")

package com.weicools.kotlinlayout.dsl

import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * @author Weicools Create on 2021.03.27
 *
 * desc:
 */

inline fun frameLayoutParams(init: FrameLayout.LayoutParams.() -> Unit) = FrameLayout.LayoutParams(wrapContent, wrapContent).apply(init)
inline fun frameLayoutParams(width: Int, height: Int, init: FrameLayout.LayoutParams.() -> Unit) = FrameLayout.LayoutParams(width, height).apply(init)

inline fun linearLayoutParams(init: LinearLayout.LayoutParams.() -> Unit) = LinearLayout.LayoutParams(wrapContent, wrapContent).apply(init)
inline fun linearLayoutParams(width: Int, height: Int, init: LinearLayout.LayoutParams.() -> Unit) = LinearLayout.LayoutParams(width, height).apply(init)

inline fun relativeLayoutParams(init: RelativeLayout.LayoutParams.() -> Unit) = RelativeLayout.LayoutParams(wrapContent, wrapContent).apply(init)
inline fun relativeLayoutParams(width: Int, height: Int, init: RelativeLayout.LayoutParams.() -> Unit) = RelativeLayout.LayoutParams(width, height).apply(init)

inline fun constraintLayoutParams(init: ConstraintLayout.LayoutParams.() -> Unit) = ConstraintLayout.LayoutParams(wrapContent, wrapContent).apply(init)
inline fun constraintLayoutParams(width: Int, height: Int, init: ConstraintLayout.LayoutParams.() -> Unit) = ConstraintLayout.LayoutParams(width, height).apply(init)

//region RelativeLayout.LayoutParams extend field
inline var RelativeLayout.LayoutParams.above: Int
  get() = 0
  set(value) {
    addRule(RelativeLayout.ABOVE, value)
  }

inline var RelativeLayout.LayoutParams.below: Int
  get() = 0
  set(value) {
    addRule(RelativeLayout.BELOW, value)
  }

inline var RelativeLayout.LayoutParams.align_Baseline: Int
  get() = 0
  set(value) {
    addRule(RelativeLayout.ALIGN_BASELINE, value)
  }

inline var RelativeLayout.LayoutParams.align_Left: Int
  get() = 0
  set(value) {
    addRule(RelativeLayout.ALIGN_LEFT, value)
  }

inline var RelativeLayout.LayoutParams.align_Top: Int
  get() = 0
  set(value) {
    addRule(RelativeLayout.ALIGN_TOP, value)
  }

inline var RelativeLayout.LayoutParams.align_Right: Int
  get() = 0
  set(value) {
    addRule(RelativeLayout.ALIGN_RIGHT, value)
  }

inline var RelativeLayout.LayoutParams.align_Bottom: Int
  get() = 0
  set(value) {
    addRule(RelativeLayout.ALIGN_BOTTOM, value)
  }

inline var RelativeLayout.LayoutParams.align_ParentLeft: Boolean
  get() = false
  set(value) {
    if (value) addRule(RelativeLayout.ALIGN_PARENT_LEFT)
  }

inline var RelativeLayout.LayoutParams.align_ParentTop: Boolean
  get() = false
  set(value) {
    if (value) addRule(RelativeLayout.ALIGN_PARENT_TOP)
  }

inline var RelativeLayout.LayoutParams.align_ParentRight: Boolean
  get() = false
  set(value) {
    if (value) addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
  }

inline var RelativeLayout.LayoutParams.align_ParentBottom: Boolean
  get() = false
  set(value) {
    if (value) addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
  }

inline var RelativeLayout.LayoutParams.center_InParent: Boolean
  get() = false
  set(value) {
    if (value) addRule(RelativeLayout.CENTER_IN_PARENT)
  }

inline var RelativeLayout.LayoutParams.center_Horizontal: Boolean
  get() = false
  set(value) {
    if (value) addRule(RelativeLayout.CENTER_HORIZONTAL)
  }

inline var RelativeLayout.LayoutParams.center_Vertical: Boolean
  get() = false
  set(value) {
    if (value) addRule(RelativeLayout.CENTER_VERTICAL)
  }

inline var RelativeLayout.LayoutParams.to_LeftOf: Int
  get() = 0
  set(value) {
    addRule(RelativeLayout.LEFT_OF, value)
  }

inline var RelativeLayout.LayoutParams.to_RightOf: Int
  get() = 0
  set(value) {
    addRule(RelativeLayout.RIGHT_OF, value)
  }
//endregion

//region ConstraintLayout.LayoutParams extend field
inline var ConstraintLayout.LayoutParams.center_Of: Int
  get() = 0
  set(value) {
    leftToLeft = value
    topToTop = value
    rightToRight = value
    bottomToBottom = value
  }

inline var ConstraintLayout.LayoutParams.center_HorizontalOf: Int
  get() = 0
  set(value) {
    leftToLeft = value
    rightToRight = value
  }

inline var ConstraintLayout.LayoutParams.center_VerticalOf: Int
  get() = 0
  set(value) {
    topToTop = value
    bottomToBottom = value
  }
//endregion
