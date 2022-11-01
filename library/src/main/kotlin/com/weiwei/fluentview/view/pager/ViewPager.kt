package com.weiwei.fluentview.view.pager

import android.content.Context
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.weiwei.fluentview.view.wrapContextIfNeeded

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
