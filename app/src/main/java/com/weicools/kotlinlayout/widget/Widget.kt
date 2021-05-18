@file:Suppress("unused", "FunctionName")

package com.weicools.kotlinlayout.widget

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Space
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.helper.widget.Layer
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout

/**
 * @author weicools
 * @date 2020.05.14
 */

@Suppress("NOTHING_TO_INLINE")
inline fun Context.withTheme(theme: Int): Context = ContextThemeWrapper(this, theme)

@Suppress("NOTHING_TO_INLINE")
inline fun wrapContextIfNeeded(context: Context, theme: Int? = null): Context = if (theme == null) context else ContextThemeWrapper(context, theme)

//region create widget function by ViewGroup
/**
 * create Widget instance within a [ViewGroup]
 * param style an style int value defined in xml
 * param init set attributes for this view in this lambda
 */

inline fun ViewGroup.view(id: Int? = null, style: Int? = null, init: View.() -> Unit): View {
  val widget = View(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.space(id: Int? = null, init: Space.() -> Unit): Space {
  val widget = Space(context)
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.imageView(id: Int? = null, style: Int? = null, init: AppCompatImageView.() -> Unit): AppCompatImageView {
  val widget = AppCompatImageView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.textView(id: Int? = null, style: Int? = null, init: AppCompatTextView.() -> Unit): AppCompatTextView {
  val widget = AppCompatTextView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.button(id: Int? = null, style: Int? = null, init: AppCompatButton.() -> Unit): AppCompatButton {
  val widget = AppCompatButton(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.materialButton(id: Int? = null, style: Int? = null, init: MaterialButton.() -> Unit): MaterialButton {
  val widget = MaterialButton(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.editText(id: Int? = null, style: Int? = null, init: EditText.() -> Unit): EditText {
  val widget = EditText(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.recyclerView(id: Int? = null, style: Int? = null, init: RecyclerView.() -> Unit): RecyclerView {
  val widget = RecyclerView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.nestedScrollView(id: Int? = null, style: Int? = null, init: NestedScrollView.() -> Unit): NestedScrollView {
  val widget = NestedScrollView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.toolbar(id: Int? = null, style: Int? = null, init: Toolbar.() -> Unit): Toolbar {
  val widget = Toolbar(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.tabLayout(id: Int? = null, style: Int? = null, init: TabLayout.() -> Unit): TabLayout {
  val widget = TabLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.viewPager(id: Int? = null, style: Int? = null, init: ViewPager.() -> Unit): ViewPager {
  val widget = ViewPager(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.frameLayout(id: Int? = null, style: Int? = null, init: FrameLayout.() -> Unit): FrameLayout {
  val widget = FrameLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.linearLayout(id: Int? = null, style: Int? = null, init: LinearLayout.() -> Unit): LinearLayout {
  val widget = LinearLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.relativeLayout(id: Int? = null, style: Int? = null, init: RelativeLayout.() -> Unit): RelativeLayout {
  val widget = RelativeLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ViewGroup.constraintLayout(id: Int? = null, style: Int? = null, init: ConstraintLayout.() -> Unit): ConstraintLayout {
  val widget = ConstraintLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}


inline fun ConstraintLayout.guideline(id: Int, orientationValue: Int, init: Guideline.() -> Unit): Guideline {
  val guideline = Guideline(context)
  guideline.id = id
  guideline.layoutParams = constraintLayoutParams { orientation = orientationValue }
  return guideline.apply(init).also { addView(it) }
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
  val widget = View(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.imageView(id: Int? = null, style: Int? = null, init: AppCompatImageView.() -> Unit): AppCompatImageView {
  val widget = AppCompatImageView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.textView(id: Int? = null, style: Int? = null, init: AppCompatTextView.() -> Unit): AppCompatTextView {
  val widget = AppCompatTextView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.button(id: Int? = null, style: Int? = null, init: AppCompatButton.() -> Unit): AppCompatButton {
  val widget = AppCompatButton(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.materialButton(id: Int? = null, style: Int? = null, init: MaterialButton.() -> Unit): MaterialButton {
  val widget = MaterialButton(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.recyclerView(id: Int? = null, style: Int? = null, init: RecyclerView.() -> Unit): RecyclerView {
  val widget = RecyclerView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.nestedScrollView(id: Int? = null, style: Int? = null, init: NestedScrollView.() -> Unit): NestedScrollView {
  val widget = NestedScrollView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.frameLayout(id: Int? = null, style: Int? = null, init: FrameLayout.() -> Unit): FrameLayout {
  val widget = FrameLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.linearLayout(id: Int? = null, style: Int? = null, init: LinearLayout.() -> Unit): LinearLayout {
  val widget = LinearLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.relativeLayout(id: Int? = null, style: Int? = null, init: RelativeLayout.() -> Unit): RelativeLayout {
  val widget = RelativeLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}


inline fun Context.constraintLayout(id: Int? = null, style: Int? = null, init: ConstraintLayout.() -> Unit): ConstraintLayout {
  val widget = ConstraintLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion
