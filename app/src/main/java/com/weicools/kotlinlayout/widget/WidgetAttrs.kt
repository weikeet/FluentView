@file:Suppress("unused", "FunctionName")

package com.weicools.kotlinlayout.widget

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build.VERSION.SDK_INT
import android.text.InputFilter
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.widget.ImageViewCompat

/**
 * @author Weicools Create on 2020.05.13
 *
 * desc:
 */

const val NO_THEME = 0
const val NO_ID = View.NO_ID

@Suppress("NOTHING_TO_INLINE")
inline fun createRefs() = WidgetReferenceIds()

//region View layout constant
const val matchParent = ViewGroup.LayoutParams.MATCH_PARENT
const val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT

const val parentId = ConstraintLayout.LayoutParams.PARENT_ID

const val chainSpread = ConstraintLayout.LayoutParams.CHAIN_SPREAD
const val chainPacked = ConstraintLayout.LayoutParams.CHAIN_PACKED
const val chainSpreadInside = ConstraintLayout.LayoutParams.CHAIN_SPREAD_INSIDE
const val constraintHorizontal = ConstraintLayout.LayoutParams.HORIZONTAL
const val constraintVertical = ConstraintLayout.LayoutParams.VERTICAL
//endregion

//region layout helper attribute
val Int.dp get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Float.dp get() = (this * Resources.getSystem().displayMetrics.density)

val widthPixels get() = Resources.getSystem().displayMetrics.widthPixels

val heightPixels get() = Resources.getSystem().displayMetrics.heightPixels
//endregion

//region View extend field: Gravity
inline val View.gravity_center: Int get() = Gravity.CENTER
inline val View.gravity_centerVertical: Int get() = Gravity.CENTER_VERTICAL
inline val View.gravity_centerHorizontal: Int get() = Gravity.CENTER_HORIZONTAL

inline val View.gravity_start: Int get() = Gravity.START
inline val View.gravity_top: Int get() = Gravity.TOP
inline val View.gravity_end: Int get() = Gravity.END
inline val View.gravity_bottom: Int get() = Gravity.BOTTOM

inline val View.gravity_startTop: Int get() = Gravity.START or Gravity.TOP
inline val View.gravity_startBottom: Int get() = Gravity.START or Gravity.BOTTOM
inline val View.gravity_endTop: Int get() = Gravity.END or Gravity.TOP
inline val View.gravity_endBottom: Int get() = Gravity.END or Gravity.BOTTOM

inline val View.gravity_startCenter: Int get() = Gravity.START or Gravity.CENTER_VERTICAL
inline val View.gravity_topCenter: Int get() = Gravity.TOP or Gravity.CENTER_HORIZONTAL
inline val View.gravity_endCenter: Int get() = Gravity.END or Gravity.CENTER_VERTICAL
inline val View.gravity_bottomCenter: Int get() = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
//endregion

//region View extend field: Resource
@Suppress("NOTHING_TO_INLINE")
inline fun View.string_of(@StringRes stringId: Int) = context.getString(stringId)

@Suppress("NOTHING_TO_INLINE")
inline fun View.strings_of(@StringRes stringId: Int, vararg formatArgs: Any) = context.getString(stringId, *formatArgs)

@Suppress("NOTHING_TO_INLINE")
inline fun View.color_of(@ColorRes colorId: Int) = ContextCompat.getColor(context, colorId)

@Suppress("NOTHING_TO_INLINE")
inline fun View.colors_of(@ColorRes colorId: Int) = ContextCompat.getColorStateList(context, colorId)

@Suppress("NOTHING_TO_INLINE")
inline fun View.drawable_of(@DrawableRes drawableId: Int) = ContextCompat.getDrawable(context, drawableId)

@Suppress("NOTHING_TO_INLINE")
inline fun View.drawable_ofCompat(@DrawableRes drawableId: Int) = AppCompatResources.getDrawable(context, drawableId)
//endregion

//region View extend field: Click
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

//region View extend field: LayoutDirection
/**
 * True if layout direction is **left to right**, like in English.
 *
 * This is always true on API 16 and below since layout direction support only came in API 17.
 */
inline val View.isLtr
  @SuppressLint("ObsoleteSdkInt")
  get() = SDK_INT < 17 || layoutDirection == View.LAYOUT_DIRECTION_LTR

/**
 * True if layout direction is **right to left**, like in Arabic.
 *
 * This is always false on API 16 and below since layout direction support only came in API 17.
 */
inline val View.isRtl get() = !isLtr
//endregion

//region View extend field: Padding
inline var View.padding_top: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setPadding(paddingLeft, value, paddingRight, paddingBottom)

inline var View.padding_bottom: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setPadding(paddingLeft, paddingTop, paddingRight, value)

inline var View.padding_topBottom: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setPadding(paddingLeft, value, paddingRight, value)

inline var View.padding_left: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setPadding(value, paddingTop, paddingRight, paddingBottom)

inline var View.padding_right: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setPadding(paddingLeft, paddingTop, value, paddingBottom)

inline var View.padding_leftRight: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setPadding(value, paddingTop, value, paddingBottom)

inline var View.paddings: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setPadding(value, value, value, value)
//endregion

//region View extend field: Background
inline var View.background_resource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setBackgroundResource(value)

/**
 * Set only property that takes a color int.
 */
inline var View.background_color: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorInt color) = setBackgroundColor(color)

/**
 * Set only property that takes a color resource.
 */
inline var View.background_colorResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) = setBackgroundColor(ContextCompat.getColor(context, colorId))

/**
 * Set only property that takes a color String.
 */
inline var View.background_colorString: String
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(colorValue) = setBackgroundColor(Color.parseColor(colorValue))

inline var View.background_tintColors: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) {
    if (SDK_INT >= 21) {
      backgroundTintList = ContextCompat.getColorStateList(context, colorId)
    } else {
      ViewCompat.setBackgroundTintList(this, ContextCompat.getColorStateList(context, colorId))
    }
  }

inline var View.background_tintList: ColorStateList?
  get() = if (SDK_INT >= 21) backgroundTintList else ViewCompat.getBackgroundTintList(this)
  set(colorList) {
    if (SDK_INT >= 21) {
      backgroundTintList = colorList
    } else {
      ViewCompat.setBackgroundTintList(this, colorList)
    }
  }

inline var View.background_tintMode: PorterDuff.Mode?
  get() = if (SDK_INT >= 21) backgroundTintMode else ViewCompat.getBackgroundTintMode(this)
  set(mode) {
    if (SDK_INT >= 21) {
      backgroundTintMode = mode
    } else {
      ViewCompat.setBackgroundTintMode(this, mode)
    }
  }
//endregion

//region View extend field: Elevation
inline var View.elevation_compat: Float
  get() = if (SDK_INT >= 21) elevation else 0f
  set(value) {
    if (SDK_INT >= 21) elevation = value
  }
//endregion

//region TextView extend field
inline var TextView.text_resource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@StringRes stringId) = setText(stringId)

inline var TextView.text_color: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorInt colorInt) = setTextColor(colorInt)

inline var TextView.text_colors: ColorStateList?
  get() = textColors
  set(colorList) = setTextColor(colorList)

inline var TextView.text_colorResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) = setTextColor(ContextCompat.getColor(context, colorId))

inline var TextView.text_colorsResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) = setTextColor(ContextCompat.getColorStateList(context, colorId))

inline var TextView.text_colorString: String
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(colorString) = setTextColor(Color.parseColor(colorString))

inline var TextView.text_sizeDp: Float
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(sizeDp) = setTextSize(TypedValue.COMPLEX_UNIT_DIP, sizeDp)

inline var TextView.text_style: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(style) = setTypeface(typeface, style)

inline var TextView.text_fontFamily: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@FontRes fontId) {
    typeface = ResourcesCompat.getFont(context, fontId)
  }

inline var TextView.text_ems: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setEms(value)

inline var TextView.text_lines: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setLines(value)

inline var TextView.text_maxLine: Int
  get() = maxLines
  set(value) {
    maxLines = value
  }

inline var TextView.text_maxLength: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(maxLength) {
    filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
  }

inline var TextView.hint_colorResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) = setHintTextColor(ContextCompat.getColor(context, colorId))

inline var TextView.hint_colorString: String
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(colorString) = setHintTextColor(Color.parseColor(colorString))

inline var TextView.text_hintResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@StringRes stringId) = setHint(stringId)

inline var TextView.text_hint: String
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(hintText) {
    hint = hintText
  }

inline var TextView.text_lineSpacingMultiplier: Float
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(multi) = setLineSpacing(lineSpacingExtra, multi)

inline var TextView.text_lineSpacingExtra: Float
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(add) = setLineSpacing(add, lineSpacingMultiplier)

inline val TextView.sans_serif: Typeface
  get() = Typeface.create("sans-serif", Typeface.NORMAL)

inline val TextView.sans_serifMedium: Typeface
  get() = Typeface.create("sans-serif-medium", Typeface.NORMAL)

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

//region ImageView extend field
/**
 * Sets a drawable resource as the content of this ImageView.
 * Allows the use of vector drawables when running on older versions of the platform.
 *
 * **This does Bitmap reading and decoding on the UI thread, which can cause a latency hiccup.**
 * If that's a concern, consider using [image_srcCompat] or [image_bitmap] and [BitmapFactory] instead.
 */
inline var ImageView.image_resource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@DrawableRes drawableId) = setImageResource(drawableId)

/**
 * Sets a drawable resource as the content of this ImageView.
 * Not allowed the use of vector drawables when running on older versions of the platform.
 */
inline var ImageView.image_src: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@DrawableRes drawableId) = setImageDrawable(ContextCompat.getDrawable(context, drawableId))

/**
 * Sets a drawable resource as the content of this ImageView.
 * Allows the use of vector drawables when running on older versions of the platform.
 */
inline var ImageView.image_srcCompat: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@DrawableRes drawableId) = setImageDrawable(AppCompatResources.getDrawable(context, drawableId))

/**
 * Sets a drawable as the content of this ImageView.
 * A null value will clear the content.
 */
inline var ImageView.image_drawable: Drawable?
  get() = drawable
  set(value) = setImageDrawable(value)

/**
 * Sets a Bitmap as the content of this ImageView.
 */
inline var ImageView.image_bitmap: Bitmap
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(bitmap) = setImageBitmap(bitmap)

/**
 * Applies a tint to the image drawable. Does not modify the current tintMode, which is [PorterDuff.Mode.SRC_IN] by default.
 */
inline var ImageView.image_tintColors: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) {
    if (SDK_INT >= 21) {
      imageTintList = ContextCompat.getColorStateList(context, colorId)
    } else {
      ImageViewCompat.setImageTintList(this, ContextCompat.getColorStateList(context, colorId))
    }
  }

inline var ImageView.image_tintList: ColorStateList?
  get() = if (SDK_INT >= 21) imageTintList else ImageViewCompat.getImageTintList(this)
  set(tintList) {
    if (SDK_INT >= 21) {
      imageTintList = tintList
    } else {
      ImageViewCompat.setImageTintList(this, tintList)
    }
  }

inline var ImageView.image_tintMode: PorterDuff.Mode?
  get() = if (SDK_INT >= 21) imageTintMode else ImageViewCompat.getImageTintMode(this)
  set(mode) {
    if (SDK_INT >= 21) {
      imageTintMode = mode
    } else {
      ImageViewCompat.setImageTintMode(this, mode)
    }
  }

inline val ImageView.scaleCenter get() = ImageView.ScaleType.CENTER
inline val ImageView.scaleCenterCrop get() = ImageView.ScaleType.CENTER_CROP
inline val ImageView.scaleCenterInside get() = ImageView.ScaleType.CENTER_INSIDE
inline val ImageView.scaleFitCenter get() = ImageView.ScaleType.FIT_CENTER
inline val ImageView.scaleFitStart get() = ImageView.ScaleType.FIT_START
inline val ImageView.scaleFitEnd get() = ImageView.ScaleType.FIT_END
inline val ImageView.scaleFixXy get() = ImageView.ScaleType.FIT_XY
inline val ImageView.scaleMatrix get() = ImageView.ScaleType.MATRIX
//endregion
