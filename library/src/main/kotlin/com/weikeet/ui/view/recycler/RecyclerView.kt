package com.weikeet.ui.view.recycler

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.weikeet.ui.view.wrapContent
import com.weikeet.ui.view.wrapContextIfNeeded

inline fun ViewGroup.recyclerView(id: Int? = null, style: Int? = null, init: RecyclerView.() -> Unit): RecyclerView {
  val widget = RecyclerView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.recyclerView(id: Int? = null, style: Int? = null, init: RecyclerView.() -> Unit): RecyclerView {
  val widget = RecyclerView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}

inline fun recyclerParams(width: Int = wrapContent, height: Int = wrapContent, init: RecyclerView.LayoutParams.() -> Unit) =
  RecyclerView.LayoutParams(width, height).apply(init)
