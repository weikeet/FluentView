package com.fluent.view.core

import android.content.Context
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import com.fluent.view.wrapContextIfNeeded

inline fun ViewGroup.nestedScrollView(id: Int? = null, style: Int? = null, init: NestedScrollView.() -> Unit): NestedScrollView {
  val widget = NestedScrollView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.nestedScrollView(id: Int? = null, style: Int? = null, init: NestedScrollView.() -> Unit): NestedScrollView {
  val widget = NestedScrollView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}

// NestedScrollView extends FrameLayout, LayoutParams: FrameLayout.LayoutParams
