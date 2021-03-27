@file:Suppress("unused", "FunctionName")

package com.weicools.kotlinlayout.dsl

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.helper.widget.Layer
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

/**
 * @author weicools
 * @date 2020.05.14
 */

//region create widget function by ViewGroup
/**
 * create Widget instance within a [ViewGroup]
 * param style an style int value defined in xml
 * param init set attributes for this view in this lambda
 */

inline fun ViewGroup.view(id: Int? = null, style: Int? = null, init: View.() -> Unit): View {
  val widget = if (style == null) View(context) else View(ContextThemeWrapper(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.imageView(id: Int? = null, style: Int? = null, init: AppCompatImageView.() -> Unit): AppCompatImageView {
  val widget = if (style == null) AppCompatImageView(context) else AppCompatImageView(ContextThemeWrapper(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.textView(id: Int? = null, style: Int? = null, init: AppCompatTextView.() -> Unit): AppCompatTextView {
  val widget = if (style == null) AppCompatTextView(context) else AppCompatTextView(ContextThemeWrapper(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.button(id: Int? = null, style: Int? = null, init: AppCompatButton.() -> Unit): AppCompatButton {
  val widget = if (style == null) AppCompatButton(context) else AppCompatButton(ContextThemeWrapper(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.editText(id: Int? = null, style: Int? = null, init: EditText.() -> Unit): EditText {
  val widget = if (style == null) EditText(context) else EditText(ContextThemeWrapper(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.recyclerView(id: Int? = null, style: Int? = null, init: RecyclerView.() -> Unit): RecyclerView {
  val widget = if (style == null) RecyclerView(context) else RecyclerView(ContextThemeWrapper(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.nestedScrollView(id: Int? = null, style: Int? = null, init: NestedScrollView.() -> Unit): NestedScrollView {
  val widget = if (style == null) NestedScrollView(context) else NestedScrollView(ContextThemeWrapper(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.frameLayout(id: Int? = null, style: Int? = null, init: FrameLayout.() -> Unit): FrameLayout {
  val widget = if (style == null) FrameLayout(context) else FrameLayout(ContextThemeWrapper(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.linearLayout(id: Int? = null, style: Int? = null, init: LinearLayout.() -> Unit): LinearLayout {
  val widget = if (style == null) LinearLayout(context) else LinearLayout(ContextThemeWrapper(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.relativeLayout(id: Int? = null, style: Int? = null, init: RelativeLayout.() -> Unit): RelativeLayout {
  val widget = if (style == null) RelativeLayout(context) else RelativeLayout(ContextThemeWrapper(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.constraintLayout(id: Int? = null, style: Int? = null, init: ConstraintLayout.() -> Unit): ConstraintLayout {
  val widget = if (style == null) ConstraintLayout(context) else ConstraintLayout(ContextThemeWrapper(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ConstraintLayout.guideline(id: Int? = null, init: Guideline.() -> Unit): Guideline {
  val widget = Guideline(context)
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun ConstraintLayout.flow(id: Int? = null, init: Flow.() -> Unit): Flow {
  val widget = Flow(context)
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun ConstraintLayout.layer(id: Int? = null, init: Layer.() -> Unit): Layer {
  val widget = Layer(context)
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}
//endregion

//region create widget function by Context
/**
 * create Widget instance within a [Context]
 * param style an style int value defined in xml
 * param init set attributes for this view in this lambda
 */

inline fun Context.view(id: Int? = null, style: Int? = null, init: View.() -> Unit): View {
  val widget = if (style == null) View(this) else View(ContextThemeWrapper(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.imageView(id: Int? = null, style: Int? = null, init: AppCompatImageView.() -> Unit): AppCompatImageView {
  val widget = if (style == null) AppCompatImageView(this) else AppCompatImageView(ContextThemeWrapper(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.textView(id: Int? = null, style: Int? = null, init: AppCompatTextView.() -> Unit): AppCompatTextView {
  val widget = if (style == null) AppCompatTextView(this) else AppCompatTextView(ContextThemeWrapper(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.button(id: Int? = null, style: Int? = null, init: AppCompatButton.() -> Unit): AppCompatButton {
  val widget = if (style == null) AppCompatButton(this) else AppCompatButton(ContextThemeWrapper(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.materialButton(id: Int? = null, style: Int? = null, init: MaterialButton.() -> Unit): MaterialButton {
  val widget = if (style == null) MaterialButton(this) else MaterialButton(ContextThemeWrapper(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.recyclerView(id: Int? = null, style: Int? = null, init: RecyclerView.() -> Unit): RecyclerView {
  val widget = if (style == null) RecyclerView(this) else RecyclerView(ContextThemeWrapper(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.nestedScrollView(id: Int? = null, style: Int? = null, init: NestedScrollView.() -> Unit): NestedScrollView {
  val widget = if (style == null) NestedScrollView(this) else NestedScrollView(ContextThemeWrapper(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.frameLayout(id: Int? = null, style: Int? = null, init: FrameLayout.() -> Unit): FrameLayout {
  val widget = if (style == null) FrameLayout(this) else FrameLayout(ContextThemeWrapper(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.linearLayout(id: Int? = null, style: Int? = null, init: LinearLayout.() -> Unit): LinearLayout {
  val widget = if (style == null) LinearLayout(this) else LinearLayout(ContextThemeWrapper(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.relativeLayout(id: Int? = null, style: Int? = null, init: RelativeLayout.() -> Unit): RelativeLayout {
  val widget = if (style == null) RelativeLayout(this) else RelativeLayout(ContextThemeWrapper(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.constraintLayout(id: Int? = null, style: Int? = null, init: ConstraintLayout.() -> Unit): ConstraintLayout {
  val widget = if (style == null) ConstraintLayout(this) else ConstraintLayout(ContextThemeWrapper(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion
