@file:Suppress("unused")

package com.fluent.view.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.InputFilter
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fluent.annotation.NO_GETTER
import com.fluent.annotation.noGetter

//region TextView extension field
inline var TextView.textResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@StringRes stringId) = setText(stringId)

inline var TextView.textColor: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorInt colorInt) = setTextColor(colorInt)

inline var TextView.textColorResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) = setTextColor(ContextCompat.getColor(context, colorId))

inline var TextView.textColorList: ColorStateList?
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(colorList) = setTextColor(colorList)

inline var TextView.textColorListResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) = setTextColor(ContextCompat.getColorStateList(context, colorId))

inline var TextView.textColorString: String
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(colorString) = setTextColor(Color.parseColor(colorString))

inline var TextView.textSizeDp: Float
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(sizeDp) = setTextSize(TypedValue.COMPLEX_UNIT_DIP, sizeDp)

inline var TextView.textStyle: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(style) = setTypeface(typeface, style)

inline var TextView.fontFamily: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@FontRes fontId) {
    typeface = ResourcesCompat.getFont(context, fontId)
  }

inline var TextView.ems: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setEms(value)

inline var TextView.lines: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setLines(value)

inline var TextView.singleLine: Boolean
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(v) {
    isSingleLine = v
  }

inline var TextView.maxLength: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(maxLength) {
    filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
  }

inline var TextView.hintTextColor: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorInt colorValue) = setHintTextColor(colorValue)

inline var TextView.hintTextColorResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) = setHintTextColor(ContextCompat.getColor(context, colorId))

inline var TextView.hintTextColorString: String
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(colorString) = setHintTextColor(Color.parseColor(colorString))

inline var TextView.hintResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@StringRes stringId) = setHint(stringId)

inline var TextView.textLineSpacingMultiplier: Float
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(multi) = setLineSpacing(lineSpacingExtra, multi)

inline var TextView.textLineSpacingExtra: Float
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(add) = setLineSpacing(add, lineSpacingMultiplier)

inline var TextView.linkTextColor: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(v) = setLinkTextColor(v)

inline var TextView.textAppearance: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  @Suppress("DEPRECATION")
  set(@StyleRes value) = if (Build.VERSION.SDK_INT < 23) {
    setTextAppearance(context, value)
  } else {
    setTextAppearance(value)
  }

inline val TextView.sans_serif: Typeface
  get() = Typeface.create("sans-serif", Typeface.NORMAL)

inline val TextView.sans_serif_medium: Typeface
  get() = Typeface.create("sans-serif-medium", Typeface.NORMAL)

fun TextView.centerText() {
  textAlignment = View.TEXT_ALIGNMENT_CENTER
  gravity = Gravity.CENTER
}

fun TextView.alignTextToStart() {
  textAlignment = View.TEXT_ALIGNMENT_VIEW_START
  gravity = Gravity.START
}

fun TextView.alignTextToEnd() {
  textAlignment = View.TEXT_ALIGNMENT_VIEW_END
  gravity = Gravity.END
}

@Suppress("NOTHING_TO_INLINE")
inline fun TextView.setCompoundDrawables(
  start: Drawable? = null, top: Drawable? = null,
  end: Drawable? = null, bottom: Drawable? = null,
  intrinsicBounds: Boolean = false
) {
  val left = if (isLtr) start else end
  val right = if (isRtl) start else end
  if (intrinsicBounds) setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
  else setCompoundDrawables(left, top, right, bottom)
}

@Suppress("NOTHING_TO_INLINE")
inline fun TextView.setCompoundDrawables(
  @DrawableRes start: Int = 0, @DrawableRes top: Int = 0,
  @DrawableRes end: Int = 0, @DrawableRes bottom: Int = 0
) {
  val left = if (isLtr) start else end
  val right = if (isRtl) start else end
  setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
}

@Suppress("NOTHING_TO_INLINE")
inline fun TextView.clearCompoundDrawables() = setCompoundDrawables(null, null, null, null)
//endregion
