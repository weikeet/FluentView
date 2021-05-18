package com.weicools.kotlinlayout.widget

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.MarginLayoutParamsCompat

/**
 * @author weicools
 * @date 2021.05.18
 */

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
