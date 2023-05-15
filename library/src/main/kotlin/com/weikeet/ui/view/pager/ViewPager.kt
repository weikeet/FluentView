package com.weikeet.ui.view.pager

import android.content.Context
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.weikeet.ui.view.wrapContextIfNeeded

inline fun ViewGroup.viewPager(id: Int? = null, style: Int? = null, init: ViewPager.() -> Unit): ViewPager {
  val widget = ViewPager(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.viewPager(id: Int? = null, style: Int? = null, init: ViewPager.() -> Unit): ViewPager {
  val widget = ViewPager(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}

inline fun ViewGroup.viewPager2(id: Int? = null, style: Int? = null, init: ViewPager2.() -> Unit): ViewPager2 {
  val widget = ViewPager2(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.viewPager2(id: Int? = null, style: Int? = null, init: ViewPager2.() -> Unit): ViewPager2 {
  val widget = ViewPager2(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
