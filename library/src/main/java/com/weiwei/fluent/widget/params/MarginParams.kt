package com.weiwei.fluent.widget.params

import android.view.View
import android.view.ViewGroup
import androidx.core.view.MarginLayoutParamsCompat
import androidx.core.view.updateLayoutParams
import com.weiwei.fluent.widget.annotation.NO_GETTER
import com.weiwei.fluent.widget.annotation.noGetter

/**
 * @author weiwei
 * @date 2020.05.13
 */

//region View LayoutParams extend field
inline var View.margin_left: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    updateLayoutParams<ViewGroup.MarginLayoutParams> {
      leftMargin = value
    }
  }

inline var View.margin_right: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    updateLayoutParams<ViewGroup.MarginLayoutParams> {
      rightMargin = value
    }
  }

inline var View.margin_top: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    updateLayoutParams<ViewGroup.MarginLayoutParams> {
      topMargin = value
    }
  }

inline var View.margin_bottom: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    updateLayoutParams<ViewGroup.MarginLayoutParams> {
      bottomMargin = value
    }
  }

inline var View.margin_start: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    updateLayoutParams<ViewGroup.MarginLayoutParams> {
      MarginLayoutParamsCompat.setMarginStart(this, value)
    }
  }

inline var View.margin_end: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) {
    updateLayoutParams<ViewGroup.MarginLayoutParams> {
      MarginLayoutParamsCompat.setMarginEnd(this, value)
    }
  }
//endregion
