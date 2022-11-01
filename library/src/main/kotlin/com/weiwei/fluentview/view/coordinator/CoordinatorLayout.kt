package com.weiwei.fluentview.view.coordinator

import android.content.Context
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.weiwei.fluentview.view.wrapContent
import com.weiwei.fluentview.view.wrapContextIfNeeded

inline fun ViewGroup.coordinatorLayout(id: Int? = null, style: Int? = null, init: CoordinatorLayout.() -> Unit): CoordinatorLayout {
  val widget = CoordinatorLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.coordinatorLayout(id: Int? = null, style: Int? = null, init: CoordinatorLayout.() -> Unit): CoordinatorLayout {
  val widget = CoordinatorLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}

inline fun coordinatorParams(width: Int = wrapContent, height: Int = wrapContent, init: CoordinatorLayout.LayoutParams.() -> Unit) =
  CoordinatorLayout.LayoutParams(width, height).apply(init)
