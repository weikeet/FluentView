@file:Suppress("unused", "FunctionName")

package com.weicools.kotlinlayout.dsl

import android.content.res.Resources
import android.graphics.Color
import android.text.InputFilter
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.MarginLayoutParamsCompat

/**
 * @author Weicools Create on 2020.05.13
 *
 * desc:
 */

//region View layout constant
const val matchParent = ViewGroup.LayoutParams.MATCH_PARENT
const val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT

const val parentId = ConstraintLayout.LayoutParams.PARENT_ID

const val chainSpread = ConstraintLayout.LayoutParams.CHAIN_SPREAD
const val chainPacked = ConstraintLayout.LayoutParams.CHAIN_PACKED
const val chainSpreadInside = ConstraintLayout.LayoutParams.CHAIN_SPREAD_INSIDE

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
val Int.dp
  get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Float.dp
  get() = (this * Resources.getSystem().displayMetrics.density)
//endregion

@Suppress("NOTHING_TO_INLINE")
inline fun createRefs() = LayoutReferenceIds()

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

//region View extend common params field
inline var View.layout_width: Int
  get() = 0
  set(value) {
    val h = layoutParams?.height ?: 0
    layoutParams = if (layoutParams == null) {
      ViewGroup.MarginLayoutParams(value, h)
    } else {
      layoutParams.append {
        width = value
        height = h
      }
    }
  }

inline var View.layout_height: Int
  get() = 0
  set(value) {
    val w = layoutParams?.width ?: 0
    layoutParams = if (layoutParams == null) {
      ViewGroup.MarginLayoutParams(w, value)
    } else {
      layoutParams.append {
        width = w
        height = value
      }
    }
  }

inline var View.margin_Top: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply { topMargin = value }
  }

inline var View.margin_Bottom: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply { bottomMargin = value }
  }

inline var View.margin_Left: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply { leftMargin = value }
  }

inline var View.margin_Right: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply { rightMargin = value }
  }

inline var View.margin_Start: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply { MarginLayoutParamsCompat.setMarginStart(this, value) }
  }

inline var View.margin_End: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply { MarginLayoutParamsCompat.setMarginEnd(this, value) }
  }
//endregion

//region View extend linear params field
inline var View.linearWeight: Float
  get() = 0f
  set(value) {
    layoutParams = LinearLayout.LayoutParams(layoutParams.width, layoutParams.height).also {
      it.gravity = (layoutParams as? LinearLayout.LayoutParams)?.gravity ?: -1
      it.weight = value
    }
  }

inline var View.linearGravity: Int
  get() = -1
  set(value) {
    layoutParams = LinearLayout.LayoutParams(layoutParams.width, layoutParams.height).also {
      it.weight = (layoutParams as? LinearLayout.LayoutParams)?.weight ?: 0f
      it.gravity = value
    }
  }
//endregion

//region View extend relative params field
inline var View.alignParentStart: Boolean
  get() = false
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE)
    }
  }

inline var View.alignParentEnd: Boolean
  get() = false
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE)
    }
  }

inline var View.centerInParent: Boolean
  get() = false
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
    }
  }

inline var View.centerHorizontal: Boolean
  get() = false
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
    }
  }

inline var View.centerVertical: Boolean
  get() = false
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
    }
  }
//endregion

//region View extend constraint params field
inline var View.top_toTopOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      topToTop = value
      topToBottom = -1
    }
  }

inline var View.top_toBottomOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      topToBottom = value
      topToTop = -1
    }
  }

inline var View.bottom_toBottomOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      bottomToBottom = value
      bottomToTop = -1
    }
  }

inline var View.bottom_toTopOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      bottomToTop = value
      bottomToBottom = -1
    }
  }

inline var View.start_toStartOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      startToStart = value
      startToEnd = -1
    }
  }

inline var View.start_toEndOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      startToEnd = value
      startToStart = -1
    }
  }

inline var View.end_toEndOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      endToEnd = value
      endToStart = -1
    }
  }

inline var View.end_toStartOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      endToStart = value
      endToEnd = -1
    }
  }

inline var View.baseline_toBaselineOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      baselineToBaseline = value
    }
  }

inline var View.center_of: Int
  get() = -1
  set(value) {
    start_toStartOf = value
    end_toEndOf = value
    top_toTopOf = value
    bottom_toBottomOf = value
  }

inline var View.center_horizontalOf: Int
  get() = -1
  set(value) {
    start_toStartOf = value
    end_toEndOf = value
  }

inline var View.center_verticalOf: Int
  get() = -1
  set(value) {
    top_toTopOf = value
    bottom_toBottomOf = value
  }

inline var View.horizontal_bias: Float
  get() = 0f
  set(value) {
    layoutParams = layoutParams.append {
      horizontalBias = value
    }
  }

inline var View.vertical_bias: Float
  get() = 0f
  set(value) {
    layoutParams = layoutParams.append {
      verticalBias = value
    }
  }

inline var View.horizontal_chainStyle: Int
  get() = 0
  set(value) {
    layoutParams = layoutParams.append {
      horizontalChainStyle = value
    }
  }

inline var View.vertical_chainStyle: Int
  get() = 0
  set(value) {
    layoutParams = layoutParams.append {
      verticalChainStyle = value
    }
  }

inline var Flow.flow_horizontalGap: Int
  get() = 0
  set(value) {
    setHorizontalGap(value)
  }

inline var Flow.flow_verticalGap: Int
  get() = 0
  set(value) {
    setVerticalGap(value)
  }

inline var Flow.flow_wrapMode: Int
  get() = 0
  set(value) {
    setWrapMode(value)
  }
//endregion

//region layout params helper
fun ViewGroup.MarginLayoutParams.toConstraintLayoutParam() =
  ConstraintLayout.LayoutParams(width, height).also {
    it.topMargin = this.topMargin
    it.bottomMargin = this.bottomMargin
    it.leftMargin = this.leftMargin
    it.rightMargin = this.rightMargin
  }

fun ViewGroup.LayoutParams.append(set: ConstraintLayout.LayoutParams.() -> Unit) =
  (this as? ConstraintLayout.LayoutParams)?.apply(set) ?: (this as? ViewGroup.MarginLayoutParams)?.toConstraintLayoutParam()?.apply(set)
//endregion
