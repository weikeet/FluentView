@file:Suppress("unused", "FunctionName")

package com.weicools.kotlinlayout.dsl

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.*
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

inline fun ViewGroup.view(init: View.() -> Unit) = View(context).apply(init).also { addView(it) }

inline fun ViewGroup.view(style: Int, init: View.() -> Unit) = View(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.imageView(init: AppCompatImageView.() -> Unit) = AppCompatImageView(context).apply(init).also { addView(it) }

inline fun ViewGroup.imageView(style: Int, init: AppCompatImageView.() -> Unit) = AppCompatImageView(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.textView(init: AppCompatTextView.() -> Unit) = AppCompatTextView(context).apply(init).also { addView(it) }

inline fun ViewGroup.textView(style: Int, init: AppCompatTextView.() -> Unit) = AppCompatTextView(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.button(init: Button.() -> Unit) = AppCompatButton(context).apply(init).also { addView(it) }

inline fun ViewGroup.button(style: Int, init: Button.() -> Unit) = AppCompatButton(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.editText(init: EditText.() -> Unit) = EditText(context).apply(init).also { addView(it) }

inline fun ViewGroup.editText(style: Int, init: EditText.() -> Unit) = EditText(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.recyclerView(init: RecyclerView.() -> Unit) = RecyclerView(context).apply(init).also { addView(it) }

inline fun ViewGroup.recyclerView(style: Int, init: RecyclerView.() -> Unit) = RecyclerView(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.nestedScrollView(init: NestedScrollView.() -> Unit) = NestedScrollView(context).apply(init).also { addView(it) }

inline fun ViewGroup.nestedScrollView(style: Int, init: NestedScrollView.() -> Unit) = NestedScrollView(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.linearLayout(init: LinearLayout.() -> Unit) = LinearLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.linearLayout(style: Int, init: LinearLayout.() -> Unit) = LinearLayout(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.frameLayout(init: FrameLayout.() -> Unit) = FrameLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.frameLayout(style: Int, init: FrameLayout.() -> Unit) = FrameLayout(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.relativeLayout(init: RelativeLayout.() -> Unit) = RelativeLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.relativeLayout(style: Int, init: RelativeLayout.() -> Unit) = RelativeLayout(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.constraintLayout(init: ConstraintLayout.() -> Unit) = ConstraintLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.constraintLayout(style: Int, init: ConstraintLayout.() -> Unit) = ConstraintLayout(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ConstraintLayout.guideline(init: Guideline.() -> Unit) = Guideline(context).apply(init).also { addView(it) }

inline fun ConstraintLayout.flow(init: Flow.() -> Unit) = Flow(context).apply(init).also { addView(it) }

inline fun ConstraintLayout.layer(init: Layer.() -> Unit) = Layer(context).apply(init).also { addView(it) }
//endregion

//region create widget function by Context
/**
 * create Widget instance within a [Context]
 * param style an style int value defined in xml
 * param init set attributes for this view in this lambda
 */

inline fun Context.view(init: View.() -> Unit) = View(this).apply(init)

inline fun Context.view(style: Int, init: View.() -> Unit) = View(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.imageView(init: ImageView.() -> Unit) = AppCompatImageView(this).apply(init)

inline fun Context.imageView(style: Int, init: ImageView.() -> Unit) = AppCompatImageView(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.textView(init: TextView.() -> Unit) = AppCompatTextView(this).apply(init)

inline fun Context.textView(style: Int, init: TextView.() -> Unit) = AppCompatTextView(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.button(init: Button.() -> Unit) = AppCompatButton(this).apply(init)

inline fun Context.button(style: Int, init: Button.() -> Unit) = AppCompatButton(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.recyclerView(init: RecyclerView.() -> Unit) = RecyclerView(this).apply(init)

inline fun Context.recyclerView(style: Int, init: RecyclerView.() -> Unit) = RecyclerView(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.nestedScrollView(init: NestedScrollView.() -> Unit) = NestedScrollView(this).apply(init)

inline fun Context.nestedScrollView(style: Int, init: NestedScrollView.() -> Unit) = NestedScrollView(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.frameLayout(init: FrameLayout.() -> Unit) = FrameLayout(this).apply(init)

inline fun Context.frameLayout(style: Int, init: FrameLayout.() -> Unit) = FrameLayout(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.linearLayout(init: LinearLayout.() -> Unit) = LinearLayout(this).apply(init)

inline fun Context.linearLayout(style: Int, init: LinearLayout.() -> Unit) = LinearLayout(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.relativeLayout(init: RelativeLayout.() -> Unit) = RelativeLayout(this).apply(init)

inline fun Context.relativeLayout(style: Int, init: RelativeLayout.() -> Unit) = RelativeLayout(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.constraintLayout(init: ConstraintLayout.() -> Unit) = ConstraintLayout(this).apply(init)

inline fun Context.constraintLayout(style: Int, init: ConstraintLayout.() -> Unit) = ConstraintLayout(ContextThemeWrapper(this, style)).apply(init)
//endregion
