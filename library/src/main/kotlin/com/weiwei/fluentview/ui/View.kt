package com.weiwei.fluentview.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.Px
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import com.weiwei.fluentview.annotation.NO_GETTER
import com.weiwei.fluentview.annotation.noGetter

/**
 * @author weiwei
 * @date 2022.01.13
 */

val View.parentView get() = parent as ViewGroup

val View.requireActivity: Activity
  get() = context.let {
    var ctx: Context = it
    if (ctx is Activity) {
      ctx
    } else {
      while (ctx is ContextWrapper) {
        ctx = ctx.baseContext
      }
      if (ctx is Activity) {
        ctx
      } else {
        throw UnsupportedOperationException("View#getContext don't get Activity, $ctx")
      }
    }
  }

//region View extension field: Background
inline var View.backgroundResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@DrawableRes value) = setBackgroundResource(value)

/**
 * Set only property that takes a color int.
 *
 * This is an alias to [View.setBackgroundColor].
 */
inline var View.backgroundColor: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorInt colorInt) = setBackgroundColor(colorInt)

/**
 * Set only property that takes a color resource.
 */
inline var View.backgroundColorResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) = setBackgroundColor(ContextCompat.getColor(context, colorId))

/**
 * Set only property that takes a color String.
 */
inline var View.backgroundColorString: String
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(colorValue) = setBackgroundColor(Color.parseColor(colorValue))

inline var View.backgroundTintColorResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) {
    if (Build.VERSION.SDK_INT >= 22) {
      backgroundTintList = ResourcesCompat.getColorStateList(context.resources, colorId, context.theme)
    } else {
      ViewCompat.setBackgroundTintList(this, ResourcesCompat.getColorStateList(context.resources, colorId, context.theme))
    }
  }

inline var View.backgroundTintListCompat: ColorStateList?
  get() = backgroundTintList
  set(colorList) {
    if (Build.VERSION.SDK_INT >= 22) {
      backgroundTintList = colorList
    } else {
      ViewCompat.setBackgroundTintList(this, colorList)
    }
  }

inline var View.backgroundTintModeCompat: PorterDuff.Mode?
  get() = backgroundTintMode
  set(mode) {
    if (Build.VERSION.SDK_INT >= 22) {
      backgroundTintMode = mode
    } else {
      ViewCompat.setBackgroundTintMode(this, mode)
    }
  }
//endregion


//region View extension field: Click
/**
 * Registers the [block] lambda as [View.OnClickListener] to this View.
 *
 * If this View is not clickable, it becomes clickable.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun View.onClick(block: View.OnClickListener) = setOnClickListener(block)

/**
 * Register the [block] lambda as [View.OnLongClickListener] to this View.
 * By default, [consume] is set to true because it's the most common use case, but you can set it to false.
 * If you want to return a value dynamically, use [View.setOnLongClickListener] instead.
 *
 * If this view is not long clickable, it becomes long clickable.
 */
inline fun View.onLongClick(consume: Boolean = true, crossinline block: () -> Unit) {
  setOnLongClickListener { block(); consume }
}
//endregion


//region View extension field: Gravity
inline val View.gravityCenter: Int get() = Gravity.CENTER
inline val View.gravityCenterVertical: Int get() = Gravity.CENTER_VERTICAL
inline val View.gravityCenterHorizontal: Int get() = Gravity.CENTER_HORIZONTAL

inline val View.gravityStart: Int get() = Gravity.START
inline val View.gravityTop: Int get() = Gravity.TOP
inline val View.gravityEnd: Int get() = Gravity.END
inline val View.gravityBottom: Int get() = Gravity.BOTTOM

inline val View.gravityStartTop: Int get() = Gravity.START or Gravity.TOP
inline val View.gravityStartBottom: Int get() = Gravity.START or Gravity.BOTTOM
inline val View.gravityEndTop: Int get() = Gravity.END or Gravity.TOP
inline val View.gravityEndBottom: Int get() = Gravity.END or Gravity.BOTTOM

inline val View.gravityStartCenter: Int get() = Gravity.START or Gravity.CENTER_VERTICAL
inline val View.gravityTopCenter: Int get() = Gravity.TOP or Gravity.CENTER_HORIZONTAL
inline val View.gravityEndCenter: Int get() = Gravity.END or Gravity.CENTER_VERTICAL
inline val View.gravityBottomCenter: Int get() = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
//endregion


//region View extension field: Padding

inline var View.allPadding: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@Px value) = setPadding(value, value, value, value)

inline var View.verticalPadding: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@Px value) = setPadding(paddingLeft, value, paddingRight, value)

inline var View.horizontalPadding: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@Px value) = setPadding(value, paddingTop, value, paddingBottom)

inline var View.topPadding: Int
  get() = paddingTop
  set(@Px value) = setPadding(paddingLeft, value, paddingRight, paddingBottom)

inline var View.bottomPadding: Int
  get() = paddingBottom
  set(@Px value) = setPadding(paddingLeft, paddingTop, paddingRight, value)

inline var View.leftPadding: Int
  get() = paddingLeft
  set(@Px value) = setPadding(value, paddingTop, paddingRight, paddingBottom)

inline var View.rightPadding: Int
  get() = paddingRight
  set(@Px value) = setPadding(paddingLeft, paddingTop, value, paddingBottom)

inline var View.startPadding: Int
  get() = paddingStart
  set(@Px value) {
    setPaddingRelative(value, paddingTop, paddingEnd, paddingBottom)
  }

inline var View.endPadding: Int
  get() = paddingEnd
  set(@Px value) {
    setPaddingRelative(paddingStart, paddingTop, value, paddingBottom)
  }
//endregion


//region View extension field: LayoutParams
/**
 * get the left margin if this view's [ViewGroup.LayoutParams] is a [ViewGroup.MarginLayoutParams], otherwise 0.
 *
 * @see ViewGroup.MarginLayoutParams
 */
inline var View.leftMargin: Int
  get() = (layoutParams as? ViewGroup.MarginLayoutParams)?.leftMargin ?: 0
  set(@Px value) {
    (layoutParams as ViewGroup.MarginLayoutParams).leftMargin = value
  }

inline var View.rightMargin: Int
  get() = (layoutParams as? ViewGroup.MarginLayoutParams)?.rightMargin ?: 0
  set(@Px value) {
    (layoutParams as ViewGroup.MarginLayoutParams).rightMargin = value
  }

inline var View.topMargin: Int
  get() = (layoutParams as? ViewGroup.MarginLayoutParams)?.topMargin ?: 0
  set(@Px value) {
    (layoutParams as ViewGroup.MarginLayoutParams).topMargin = value
  }

inline var View.bottomMargin: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@Px value) {
    (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin = value
  }

inline var View.startMargin: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@Px value) {
    (layoutParams as ViewGroup.MarginLayoutParams).marginStart = value
  }

inline var View.endMargin: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@Px value) {
    (layoutParams as ViewGroup.MarginLayoutParams).marginEnd = value
  }
//endregion


//region View extension field: LayoutDirection
/**
 * True if layout direction is **left to right**, like in English.
 *
 * This is always true on API 16 and below since layout direction support only came in API 17.
 */
inline val View.isLtr
  @SuppressLint("ObsoleteSdkInt")
  get() = Build.VERSION.SDK_INT < 17 || layoutDirection == View.LAYOUT_DIRECTION_LTR

/**
 * True if layout direction is **right to left**, like in Arabic.
 *
 * This is always false on API 16 and below since layout direction support only came in API 17.
 */
inline val View.isRtl get() = !isLtr
//endregion
