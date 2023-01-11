@file:Suppress("unused", "FunctionName")

package com.weiwei.fluentview.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.view.ViewCompat

/**
 * create Widget instance within a [ViewGroup] or [Context]
 * param style an style int value defined in xml
 * param init set attributes for this view in this lambda
 */

//region space
inline fun ViewGroup.space(id: Int? = null, init: Space.() -> Unit): Space {
  val widget = Space(context)
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}
//endregion

//region view
inline fun ViewGroup.view(id: Int? = null, style: Int? = null, init: View.() -> Unit): View {
  val widget = View(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.view(id: Int? = null, style: Int? = null, init: View.() -> Unit): View {
  val widget = View(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

const val NO_THEME = 0

@Suppress("NOTHING_TO_INLINE")
inline fun Context.withTheme(theme: Int): Context = ContextThemeWrapper(this, theme)

@Suppress("NOTHING_TO_INLINE")
inline fun wrapContextIfNeeded(context: Context, theme: Int? = null): Context =
  if (theme == null) context else ContextThemeWrapper(context, theme)

inline fun <T : View> T.autoAddView(parent: ViewGroup, initView: T.() -> Unit): T = apply {
  initView()
  parent.addView(this)
}

const val NO_ID = View.NO_ID

@Suppress("NOTHING_TO_INLINE")
inline fun createRefs() = ViewIds()

class ViewIds {
  operator fun component1(): Int = ViewCompat.generateViewId()
  operator fun component2(): Int = ViewCompat.generateViewId()
  operator fun component3(): Int = ViewCompat.generateViewId()
  operator fun component4(): Int = ViewCompat.generateViewId()
  operator fun component5(): Int = ViewCompat.generateViewId()
  operator fun component6(): Int = ViewCompat.generateViewId()
  operator fun component7(): Int = ViewCompat.generateViewId()
  operator fun component8(): Int = ViewCompat.generateViewId()
  operator fun component9(): Int = ViewCompat.generateViewId()
  operator fun component10(): Int = ViewCompat.generateViewId()
  operator fun component11(): Int = ViewCompat.generateViewId()
  operator fun component12(): Int = ViewCompat.generateViewId()
  operator fun component13(): Int = ViewCompat.generateViewId()
  operator fun component14(): Int = ViewCompat.generateViewId()
  operator fun component15(): Int = ViewCompat.generateViewId()
  operator fun component16(): Int = ViewCompat.generateViewId()
  operator fun component17(): Int = ViewCompat.generateViewId()
  operator fun component18(): Int = ViewCompat.generateViewId()
  operator fun component19(): Int = ViewCompat.generateViewId()
  operator fun component20(): Int = ViewCompat.generateViewId()
  operator fun component21(): Int = ViewCompat.generateViewId()
  operator fun component22(): Int = ViewCompat.generateViewId()
  operator fun component23(): Int = ViewCompat.generateViewId()
  operator fun component24(): Int = ViewCompat.generateViewId()
  operator fun component25(): Int = ViewCompat.generateViewId()
  operator fun component26(): Int = ViewCompat.generateViewId()
  operator fun component27(): Int = ViewCompat.generateViewId()
  operator fun component28(): Int = ViewCompat.generateViewId()
  operator fun component29(): Int = ViewCompat.generateViewId()
  operator fun component30(): Int = ViewCompat.generateViewId()
  operator fun component31(): Int = ViewCompat.generateViewId()
  operator fun component32(): Int = ViewCompat.generateViewId()
  operator fun component33(): Int = ViewCompat.generateViewId()
  operator fun component34(): Int = ViewCompat.generateViewId()
  operator fun component35(): Int = ViewCompat.generateViewId()
  operator fun component36(): Int = ViewCompat.generateViewId()
}