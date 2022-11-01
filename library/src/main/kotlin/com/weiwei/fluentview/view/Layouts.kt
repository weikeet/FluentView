package com.weiwei.fluentview.view

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.Px
import com.weiwei.fluentview.annotation.NO_GETTER
import com.weiwei.fluentview.annotation.noGetter

//region frameLayout
inline fun ViewGroup.frameLayout(id: Int? = null, style: Int? = null, init: FrameLayout.() -> Unit): FrameLayout {
  val widget = FrameLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.frameLayout(id: Int? = null, style: Int? = null, init: FrameLayout.() -> Unit): FrameLayout {
  val widget = FrameLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region linearLayout
inline fun ViewGroup.linearLayout(id: Int? = null, style: Int? = null, init: LinearLayout.() -> Unit): LinearLayout {
  val widget = LinearLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.linearLayout(id: Int? = null, style: Int? = null, init: LinearLayout.() -> Unit): LinearLayout {
  val widget = LinearLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region relativeLayout
inline fun ViewGroup.relativeLayout(id: Int? = null, style: Int? = null, init: RelativeLayout.() -> Unit): RelativeLayout {
  val widget = RelativeLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.relativeLayout(id: Int? = null, style: Int? = null, init: RelativeLayout.() -> Unit): RelativeLayout {
  val widget = RelativeLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

const val matchParent = ViewGroup.LayoutParams.MATCH_PARENT
const val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT

@Suppress("NOTHING_TO_INLINE")
inline fun defaultParams(width: Int = wrapContent, height: Int = wrapContent) = ViewGroup.LayoutParams(width, height)

inline fun frameParams(width: Int = wrapContent, height: Int = wrapContent, init: FrameLayout.LayoutParams.() -> Unit) =
  FrameLayout.LayoutParams(width, height).apply(init)

inline fun linearParams(width: Int = wrapContent, height: Int = wrapContent, init: LinearLayout.LayoutParams.() -> Unit) =
  LinearLayout.LayoutParams(width, height).apply(init)

inline fun relativeParams(width: Int = wrapContent, height: Int = wrapContent, init: RelativeLayout.LayoutParams.() -> Unit) =
  RelativeLayout.LayoutParams(width, height).apply(init)

inline var ViewGroup.MarginLayoutParams.allMargin: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@Px value) {
    leftMargin = value
    topMargin = value
    rightMargin = value
    bottomMargin = value
  }

inline var ViewGroup.MarginLayoutParams.horizontalMargin: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@Px value) {
    leftMargin = value
    rightMargin = value
  }

inline var ViewGroup.MarginLayoutParams.verticalMargin: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@Px value) {
    topMargin = value
    bottomMargin = value
  }

//region RelativeLayout.LayoutParams extension field
inline var RelativeLayout.LayoutParams.above: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.ABOVE, value)

inline var RelativeLayout.LayoutParams.below: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.BELOW, value)

inline var RelativeLayout.LayoutParams.alignBaseline: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.ALIGN_BASELINE, value)

inline var RelativeLayout.LayoutParams.alignLeft: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.ALIGN_LEFT, value)

inline var RelativeLayout.LayoutParams.alignStart: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.ALIGN_START, value)

inline var RelativeLayout.LayoutParams.alignTop: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.ALIGN_TOP, value)

inline var RelativeLayout.LayoutParams.alignRight: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.ALIGN_RIGHT, value)

inline var RelativeLayout.LayoutParams.alignEnd: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.ALIGN_END, value)

inline var RelativeLayout.LayoutParams.alignBottom: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.ALIGN_BOTTOM, value)

inline var RelativeLayout.LayoutParams.alignParentLeft: Boolean
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    if (value) addRule(RelativeLayout.ALIGN_PARENT_LEFT)
  }

inline var RelativeLayout.LayoutParams.alignParentStart: Boolean
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    if (value) addRule(RelativeLayout.ALIGN_PARENT_START)
  }

inline var RelativeLayout.LayoutParams.alignParentTop: Boolean
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    if (value) addRule(RelativeLayout.ALIGN_PARENT_TOP)
  }

inline var RelativeLayout.LayoutParams.alignParentRight: Boolean
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    if (value) addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
  }

inline var RelativeLayout.LayoutParams.alignParentEnd: Boolean
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    if (value) addRule(RelativeLayout.ALIGN_PARENT_END)
  }

inline var RelativeLayout.LayoutParams.alignParentBottom: Boolean
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    if (value) addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
  }

inline var RelativeLayout.LayoutParams.centerInParent: Boolean
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    if (value) addRule(RelativeLayout.CENTER_IN_PARENT)
  }

inline var RelativeLayout.LayoutParams.centerHorizontal: Boolean
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    if (value) addRule(RelativeLayout.CENTER_HORIZONTAL)
  }

inline var RelativeLayout.LayoutParams.centerVertical: Boolean
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    if (value) addRule(RelativeLayout.CENTER_VERTICAL)
  }

inline var RelativeLayout.LayoutParams.toLeftOf: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.LEFT_OF, value)

inline var RelativeLayout.LayoutParams.toStartOf: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.START_OF, value)

inline var RelativeLayout.LayoutParams.toRightOf: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.RIGHT_OF, value)

inline var RelativeLayout.LayoutParams.toEndOf: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = addRule(RelativeLayout.END_OF, value)
//endregion
