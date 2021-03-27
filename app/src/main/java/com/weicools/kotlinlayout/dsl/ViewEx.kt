package com.weicools.kotlinlayout.dsl

import android.content.res.Resources
import android.graphics.Color
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
 * @author Weicools Create on 2021.03.27
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

//region View extend field
// TODO: 3/27/21 fix new params
inline var View.Layout_width: Int
  get() = 0
  set(value) {
    val h = layoutParams?.height ?: 0
    layoutParams = ViewGroup.MarginLayoutParams(value, h)
  }

inline var View.Layout_height: Int
  get() = 0
  set(value) {
    val w = layoutParams?.width ?: 0
    layoutParams = ViewGroup.MarginLayoutParams(w, value)
  }

inline var View.PaddingTop: Int
  get() = 0
  set(value) {
    setPadding(paddingLeft, value, paddingRight, paddingBottom)
  }

inline var View.PaddingBottom: Int
  get() = 0
  set(value) {
    setPadding(paddingLeft, paddingTop, paddingRight, value)
  }

inline var View.PaddingLeft: Int
  get() = 0
  set(value) {
    setPadding(value, paddingTop, paddingRight, paddingBottom)
  }

inline var View.PaddingRight: Int
  get() = 0
  set(value) {
    setPadding(paddingLeft, paddingTop, value, paddingBottom)
  }

inline var View.Padding: Int
  get() = 0
  set(value) {
    setPadding(value, value, value, value)
  }

inline var View.MarginTop: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply { topMargin = value }
  }

inline var View.MarginBottom: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply { bottomMargin = value }
  }

inline var View.MarginStart: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply { MarginLayoutParamsCompat.setMarginStart(this, value) }
  }

inline var View.MarginEnd: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply { MarginLayoutParamsCompat.setMarginEnd(this, value) }
  }

// TODO: 3/27/21 override
inline var View.Background: Int
  get() = 0
  set(value) {
    setBackgroundResource(value)
  }

inline var View.BackgroundColor: Int
  get() = 0
  set(value) {
    setBackgroundColor(value)
  }

inline var View.BackgroundColorRes: Int
  get() = 0
  set(value) {
    setBackgroundColor(ContextCompat.getColor(context, value))
  }

inline var View.BackgroundColorString: String
  get() = ""
  set(value) {
    setBackgroundColor(Color.parseColor(value))
  }
//endregion

//region TextView extend field
inline var TextView.textRes: Int
  get() = -1
  set(value) = setText(value)

inline var TextView.textColorRes: Int
  get() = -1
  set(value) {
    setTextColor(ContextCompat.getColor(context, value))
  }

inline var TextView.textColorString: String
  get() = ""
  set(value) {
    setTextColor(Color.parseColor(value))
  }

inline var TextView.textSizeDp: Float
  get() = 0f
  set(value) {
    setTextSize(TypedValue.COMPLEX_UNIT_DIP, value)
  }

inline var TextView.textStyle: Int
  get() = -1
  set(value) = setTypeface(typeface, value)

inline var TextView.textFontFamily: Int
  get() = 0
  set(value) {
    typeface = ResourcesCompat.getFont(context, value)
  }

inline var TextView.textEms: Int
  get() = -1
  set(value) = setEms(value)
//endregion

//region ImageView extend field
inline var ImageView.Src: Int
  get() = 0
  set(value) {
    setImageDrawable(AppCompatResources.getDrawable(context, value))
  }
//endregion

//region ConstrainLayout extend field
inline var View.TopToTop: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      topToTop = value
      topToBottom = -1
    }
  }

inline var View.TopToBottom: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      topToBottom = value
      topToTop = -1
    }
  }

inline var View.BottomToBottom: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      bottomToBottom = value
      bottomToTop = -1
    }
  }

inline var View.BottomToTop: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      bottomToTop = value
      bottomToBottom = -1
    }
  }

inline var View.StartToStart: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      startToStart = value
      startToEnd = -1
    }
  }

inline var View.StartToEnd: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      startToEnd = value
      startToStart = -1
    }
  }

inline var View.EndToEnd: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      endToEnd = value
      endToStart = -1
    }
  }

inline var View.EndToStart: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      endToStart = value
      endToEnd = -1
    }
  }

inline var View.BaselineToBaseline: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      baselineToBaseline = value
    }
  }

inline var View.AlignCenterOf: Int
  get() = -1
  set(value) {
    StartToStart = value
    EndToEnd = value
    TopToTop = value
    BottomToBottom = value
  }

inline var View.AlignHorizontalOf: Int
  get() = -1
  set(value) {
    StartToStart = value
    EndToEnd = value
  }

inline var View.AlignVerticalOf: Int
  get() = -1
  set(value) {
    TopToTop = value
    BottomToBottom = value
  }

inline var View.HorizontalBias: Float
  get() = 0f
  set(value) {
    layoutParams = layoutParams.append {
      horizontalBias = value
    }
  }

inline var View.VerticalBias: Float
  get() = 0f
  set(value) {
    layoutParams = layoutParams.append {
      verticalBias = value
    }
  }

inline var View.HorizontalChainStyle: Int
  get() = 0
  set(value) {
    layoutParams = layoutParams.append {
      horizontalChainStyle = value
    }
  }

inline var View.VerticalChainStyle: Int
  get() = 0
  set(value) {
    layoutParams = layoutParams.append {
      verticalChainStyle = value
    }
  }

inline var Flow.flowHorizontalGap: Int
  get() = 0
  set(value) {
    setHorizontalGap(value)
  }

inline var Flow.flowVerticalGap: Int
  get() = 0
  set(value) {
    setVerticalGap(value)
  }

inline var Flow.flowWrapMode: Int
  get() = 0
  set(value) {
    setWrapMode(value)
  }
//endregion

//region LinearLayout extend field
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

//region RelativeLayout extend field
inline var View.AlignParentStart: Boolean
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

inline var View.AlignParentEnd: Boolean
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

inline var View.CenterInParent: Boolean
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

inline var View.CenterHorizontal: Boolean
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

inline var View.CenterVertical: Boolean
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

//region layout helper attribute
val Int.dp
  get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()

val Float.dp
  get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)
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