package com.fluent.view.drawer

import android.content.Context
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import com.fluent.view.wrapContent
import com.fluent.view.wrapContextIfNeeded

inline fun ViewGroup.drawerLayout(id: Int? = null, style: Int? = null, init: DrawerLayout.() -> Unit): DrawerLayout {
  val widget = DrawerLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.drawerLayout(id: Int? = null, style: Int? = null, init: DrawerLayout.() -> Unit): DrawerLayout {
  val widget = DrawerLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}

inline fun drawerParams(width: Int = wrapContent, height: Int = wrapContent, init: DrawerLayout.LayoutParams.() -> Unit) =
  DrawerLayout.LayoutParams(width, height).apply(init)
