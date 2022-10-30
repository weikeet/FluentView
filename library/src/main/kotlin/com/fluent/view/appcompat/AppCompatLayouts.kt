package com.fluent.view.appcompat

import android.content.Context
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.fluent.view.wrapContent
import com.fluent.view.wrapContextIfNeeded

inline fun ViewGroup.toolbar(id: Int? = null, style: Int? = null, init: Toolbar.() -> Unit): Toolbar {
  val widget = Toolbar(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.toolbar(id: Int? = null, style: Int? = null, init: Toolbar.() -> Unit): Toolbar {
  val widget = Toolbar(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}

inline fun toolbarParams(width: Int = wrapContent, height: Int = wrapContent, init: Toolbar.LayoutParams.() -> Unit) =
  Toolbar.LayoutParams(width, height).apply(init)
