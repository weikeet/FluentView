@file:Suppress("unused", "FunctionName")

package com.weicools.kotlinlayout.widget

import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.text.InputFilter
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import kotlin.math.roundToInt

/**
 * @author Weicools Create on 2020.05.13
 *
 * desc:
 */

const val NO_THEME = 0
const val NO_ID = View.NO_ID

//region View layout constant
const val matchParent = ViewGroup.LayoutParams.MATCH_PARENT
const val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT

const val parentId = ConstraintLayout.LayoutParams.PARENT_ID

const val chainSpread = ConstraintLayout.LayoutParams.CHAIN_SPREAD
const val chainPacked = ConstraintLayout.LayoutParams.CHAIN_PACKED
const val chainSpreadInside = ConstraintLayout.LayoutParams.CHAIN_SPREAD_INSIDE
const val constraintHorizontal = ConstraintLayout.LayoutParams.HORIZONTAL
const val constraintVertical = ConstraintLayout.LayoutParams.VERTICAL

val scaleCenter = ImageView.ScaleType.CENTER
val scaleCenterCrop = ImageView.ScaleType.CENTER_CROP
val scaleCenterInside = ImageView.ScaleType.CENTER_INSIDE
val scaleFitCenter = ImageView.ScaleType.FIT_CENTER
val scaleFitStart = ImageView.ScaleType.FIT_START
val scaleFitEnd = ImageView.ScaleType.FIT_END
val scaleFixXy = ImageView.ScaleType.FIT_XY
val scaleMatrix = ImageView.ScaleType.MATRIX
//endregion

//region layout helper attribute
val Int.dp get() = (this * Resources.getSystem().displayMetrics.density).roundToInt()

val Float.dp get() = (this * Resources.getSystem().displayMetrics.density)

val widthPixels get() = Resources.getSystem().displayMetrics.widthPixels

val heightPixels get() = Resources.getSystem().displayMetrics.heightPixels
//endregion

@Suppress("NOTHING_TO_INLINE")
inline fun View.color_Of(colorId: Int) = ContextCompat.getColor(context, colorId)

@Suppress("NOTHING_TO_INLINE")
inline fun View.colors_Of(colorId: Int) = ContextCompat.getColorStateList(context, colorId)

@Suppress("NOTHING_TO_INLINE")
inline fun createRefs() = WidgetReferenceIds()

//region View extend field
inline var View.padding_Top: Int
  get() = 0
  set(value) = setPadding(paddingLeft, value, paddingRight, paddingBottom)

inline var View.padding_Bottom: Int
  get() = 0
  set(value) = setPadding(paddingLeft, paddingTop, paddingRight, value)

inline var View.padding_Left: Int
  get() = 0
  set(value) = setPadding(value, paddingTop, paddingRight, paddingBottom)

inline var View.padding_Right: Int
  get() = 0
  set(value) = setPadding(paddingLeft, paddingTop, value, paddingBottom)

inline var View.paddings: Int
  get() = 0
  set(value) = setPadding(value, value, value, value)

inline var View.background_res: Int
  get() = 0
  set(value) = setBackgroundResource(value)

inline var View.background_color: Int
  get() = 0
  set(value) = setBackgroundColor(value)

inline var View.background_colorRes: Int
  get() = 0
  set(value) {
    setBackgroundColor(ContextCompat.getColor(context, value))
  }

inline var View.background_colorString: String
  get() = ""
  set(value) {
    setBackgroundColor(Color.parseColor(value))
  }

inline var View.elevation_compat: Float
  get() = 0f
  set(value) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) elevation = value
  }
//endregion

//region TextView extend field
inline var TextView.text_res: Int
  get() = -1
  set(value) = setText(value)

inline var TextView.text_colorRes: Int
  get() = -1
  set(value) {
    setTextColor(ContextCompat.getColor(context, value))
  }

inline var TextView.text_colorString: String
  get() = ""
  set(value) = setTextColor(Color.parseColor(value))

inline var TextView.text_sizeDp: Float
  get() = 0f
  set(value) = setTextSize(TypedValue.COMPLEX_UNIT_DIP, value)

inline var TextView.text_style: Int
  get() = -1
  set(value) = setTypeface(typeface, value)

inline var TextView.text_fontFamily: Int
  get() = 0
  set(value) {
    typeface = ResourcesCompat.getFont(context, value)
  }

inline var TextView.text_ems: Int
  get() = -1
  set(value) = setEms(value)

inline var TextView.text_maxLength: Int
  get() = 1
  set(value) {
    filters = arrayOf<InputFilter>(InputFilter.LengthFilter(value))
  }

inline var TextView.hint_colorRes: Int
  get() = -1
  set(value) = setHintTextColor(ContextCompat.getColor(context, value))

inline var TextView.hint_colorString: String
  get() = ""
  set(value) = setHintTextColor(Color.parseColor(value))

inline var TextView.text_hintRes: Int
  get() = -1
  set(value) = setHint(value)

inline var TextView.text_hint: String
  get() = ""
  set(value) {
    hint = value
  }

inline var TextView.line_spaceMultiplier: Float
  get() = -1f
  set(value) = setLineSpacing(lineSpacingExtra, value)

inline var TextView.line_spacingExtra: Float
  get() = -1f
  set(value) = setLineSpacing(value, lineSpacingMultiplier)

//endregion

//region ImageView extend field
inline var ImageView.src: Int
  get() = 0
  set(value) {
    setImageResource(value)
  }

inline var ImageView.src_compat: Int
  get() = 0
  set(value) {
    setImageDrawable(AppCompatResources.getDrawable(context, value))
  }
//endregion
