@file:Suppress("unused", "FunctionName")

package com.weicools.kotlinlayout.dsl

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
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.MarginLayoutParamsCompat

/**
 * @author weicools
 * @date 2020.05.14
 */

//<editor-fold desc="View extend field">
inline var View.ds_layout_width: Int
  get() {
    return 0
  }
  set(value) {
    val h = layoutParams?.height ?: 0
    layoutParams = ViewGroup.MarginLayoutParams(value, h)
  }

inline var View.ds_layout_height: Int
  get() {
    return 0
  }
  set(value) {
    val w = layoutParams?.width ?: 0
    layoutParams = ViewGroup.MarginLayoutParams(w, value)
  }

inline var View.ds_paddingTop: Int
  get() {
    return 0
  }
  set(value) {
    setPadding(paddingLeft, value, paddingRight, paddingBottom)
  }

inline var View.ds_paddingBottom: Int
  get() {
    return 0
  }
  set(value) {
    setPadding(paddingLeft, paddingTop, paddingRight, value)
  }

inline var View.ds_paddingStart: Int
  get() {
    return 0
  }
  set(value) {
    setPadding(value, paddingTop, paddingRight, paddingBottom)
  }

inline var View.ds_paddingEnd: Int
  get() {
    return 0
  }
  set(value) {
    setPadding(paddingLeft, paddingTop, value, paddingBottom)
  }

inline var View.ds_padding: Int
  get() {
    return 0
  }
  set(value) {
    setPadding(value, value, value, value)
  }

inline var View.ds_marginTop: Int
  get() {
    return 0
  }
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      topMargin = value
    }
  }

inline var View.ds_marginBottom: Int
  get() {
    return 0
  }
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      bottomMargin = value
    }
  }

inline var View.ds_marginStart: Int
  get() {
    return 0
  }
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      MarginLayoutParamsCompat.setMarginStart(this, value)
    }
  }

inline var View.ds_marginEnd: Int
  get() {
    return 0
  }
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      MarginLayoutParamsCompat.setMarginEnd(this, value)
    }
  }

inline var View.ds_backgroundRes: Int
  get() {
    return 0
  }
  set(value) {
    setBackgroundResource(value)
  }

inline var View.ds_backgroundColorRes: Int
  get() {
    return 0
  }
  set(value) {
    setBackgroundColor(ContextCompat.getColor(context, value))
  }

inline var View.ds_backgroundColor: String
  get() {
    return ""
  }
  set(value) {
    setBackgroundColor(Color.parseColor(value))
  }
//</editor-fold>

//<editor-fold desc="TextView extend field">
inline var TextView.ds_textRes: Int
  get() {
    return -1
  }
  set(value) = setText(value)

inline var TextView.ds_textColorRes: Int
  get() {
    return -1
  }
  set(value) {
    setTextColor(ContextCompat.getColor(context, value))
  }

inline var TextView.ds_textColor: String
  get() {
    return ""
  }
  set(value) {
    setTextColor(Color.parseColor(value))
  }

inline var TextView.ds_textSizeDp: Float
  get() {
    return 0f
  }
  set(value) {
    setTextSize(TypedValue.COMPLEX_UNIT_DIP, value)
  }

inline var TextView.ds_textStyle: Int
  get() {
    return -1
  }
  set(value) = setTypeface(typeface, value)

inline var TextView.ds_textFontFamily: Int
  get() {
    return 0
  }
  set(value) {
    typeface = ResourcesCompat.getFont(context, value)
  }

inline var TextView.ds_textEms: Int
  get() {
    return -1
  }
  set(value) = setEms(value)
//</editor-fold>

//<editor-fold desc="ImageView extend field">
inline var ImageView.ds_imageSrc: Int
  get() {
    return 0
  }
  set(value) {
    setImageDrawable(AppCompatResources.getDrawable(context, value))
  }
//</editor-fold>

//<editor-fold desc="ConstrainLayout extend field">
inline var View.ds_constraintTop_toTopOf: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      topToTop = value
      topToBottom = -1
    }
  }

inline var View.ds_constraintTop_toBottomOf: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      topToBottom = value
      topToTop = -1
    }
  }

inline var View.ds_constraintBottom_toBottomOf: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      bottomToBottom = value
      bottomToTop = -1
    }
  }

inline var View.ds_constraintBottom_toTopOf: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      bottomToTop = value
      bottomToBottom = -1
    }
  }

inline var View.ds_constraintStart_toStartOf: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      startToStart = value
      startToEnd = -1
    }
  }

inline var View.ds_constraintStart_toEndOf: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      startToEnd = value
      startToStart = -1
    }
  }

inline var View.ds_constraintEnd_toEndOf: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      endToEnd = value
      endToStart = -1
    }
  }

inline var View.ds_constraintEnd_toStartOf: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      endToStart = value
      endToEnd = -1
    }
  }

inline var View.ds_constraintBaseline_toBaselineOf: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      baselineToBaseline = value
    }
  }

inline var View.ds_constraintCenter_alignOf: Int
  get() {
    return -1
  }
  set(value) {
    ds_constraintStart_toStartOf = value
    ds_constraintEnd_toEndOf = value
    ds_constraintTop_toTopOf = value
    ds_constraintBottom_toBottomOf = value
  }

inline var View.ds_constraintHorizontal_alignOf: Int
  get() {
    return -1
  }
  set(value) {
    ds_constraintStart_toStartOf = value
    ds_constraintEnd_toEndOf = value
  }

inline var View.ds_constraintVertical_alignOf: Int
  get() {
    return -1
  }
  set(value) {
    ds_constraintTop_toTopOf = value
    ds_constraintBottom_toBottomOf = value
  }

inline var View.ds_constraintHorizontal_bias: Float
  get() {
    return 0f
  }
  set(value) {
    layoutParams = layoutParams.append {
      horizontalBias = value
    }
  }

inline var View.ds_constraintVertical_bias: Float
  get() {
    return 0f
  }
  set(value) {
    layoutParams = layoutParams.append {
      verticalBias = value
    }
  }

inline var View.ds_constraintHorizontal_chainStyle: Int
  get() {
    return 0
  }
  set(value) {
    layoutParams = layoutParams.append {
      horizontalChainStyle = value
    }
  }

inline var View.ds_constraintVertical_chainStyle: Int
  get() {
    return 0
  }
  set(value) {
    layoutParams = layoutParams.append {
      verticalChainStyle = value
    }
  }

inline var Flow.ds_flow_horizontalGap: Int
  get() {
    return 0
  }
  set(value) {
    setHorizontalGap(value)
  }

inline var Flow.ds_flow_verticalGap: Int
  get() {
    return 0
  }
  set(value) {
    setVerticalGap(value)
  }

inline var Flow.ds_flow_wrapMode: Int
  get() {
    return 0
  }
  set(value) {
    setWrapMode(value)
  }
//</editor-fold>

//<editor-fold desc="LinearLayout extend field">
inline var View.ds_linear_weight: Float
  get() {
    return 0f
  }
  set(value) {
    layoutParams = LinearLayout.LayoutParams(layoutParams.width, layoutParams.height).also {
      it.gravity = (layoutParams as? LinearLayout.LayoutParams)?.gravity ?: -1
      it.weight = value
    }
  }

inline var View.ds_linear_layout_gravity: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = LinearLayout.LayoutParams(layoutParams.width, layoutParams.height).also {
      it.weight = (layoutParams as? LinearLayout.LayoutParams)?.weight ?: 0f
      it.gravity = value
    }
  }
//</editor-fold>

//<editor-fold desc="RelativeLayout extend field">
inline var View.ds_relative_alignParentStart: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE)
    }
  }

inline var View.ds_relative_alignParentEnd: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE)
    }
  }

inline var View.ds_relative_centerInParent: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
    }
  }

inline var View.ds_relative_centerHorizontal: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
    }
  }

inline var View.ds_relative_centerVertical: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
    }
  }
//</editor-fold>