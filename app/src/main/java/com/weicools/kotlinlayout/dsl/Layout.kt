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

inline fun ViewGroup.View(init: View.() -> Unit) = View(context).apply(init).also { addView(it) }

inline fun ViewGroup.View(style: Int, init: View.() -> Unit) = View(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.ImageView(init: AppCompatImageView.() -> Unit) = AppCompatImageView(context).apply(init).also { addView(it) }

inline fun ViewGroup.ImageView(style: Int, init: AppCompatImageView.() -> Unit) = AppCompatImageView(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.TextView(init: AppCompatTextView.() -> Unit) = AppCompatTextView(context).apply(init).also { addView(it) }

inline fun ViewGroup.TextView(style: Int, init: AppCompatTextView.() -> Unit) = AppCompatTextView(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.Button(init: Button.() -> Unit) = AppCompatButton(context).apply(init).also { addView(it) }

inline fun ViewGroup.Button(style: Int, init: Button.() -> Unit) = AppCompatButton(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.EditText(init: EditText.() -> Unit) = EditText(context).apply(init).also { addView(it) }

inline fun ViewGroup.EditText(style: Int, init: EditText.() -> Unit) = EditText(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.RecyclerView(init: RecyclerView.() -> Unit) = RecyclerView(context).apply(init).also { addView(it) }

inline fun ViewGroup.RecyclerView(style: Int, init: RecyclerView.() -> Unit) = RecyclerView(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.NestedScrollView(init: NestedScrollView.() -> Unit) = NestedScrollView(context).apply(init).also { addView(it) }

inline fun ViewGroup.NestedScrollView(style: Int, init: NestedScrollView.() -> Unit) = NestedScrollView(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.LinearLayout(init: LinearLayout.() -> Unit) = LinearLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.LinearLayout(style: Int, init: LinearLayout.() -> Unit) = LinearLayout(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.FrameLayout(init: FrameLayout.() -> Unit) = FrameLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.FrameLayout(style: Int, init: FrameLayout.() -> Unit) = FrameLayout(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.RelativeLayout(init: RelativeLayout.() -> Unit) = RelativeLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.RelativeLayout(style: Int, init: RelativeLayout.() -> Unit) = RelativeLayout(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ViewGroup.ConstraintLayout(init: ConstraintLayout.() -> Unit) = ConstraintLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.ConstraintLayout(style: Int, init: ConstraintLayout.() -> Unit) = ConstraintLayout(ContextThemeWrapper(context, style)).apply(init).also { addView(it) }


inline fun ConstraintLayout.Guideline(init: Guideline.() -> Unit) = Guideline(context).apply(init).also { addView(it) }

inline fun ConstraintLayout.Flow(init: Flow.() -> Unit) = Flow(context).apply(init).also { addView(it) }

inline fun ConstraintLayout.Layer(init: Layer.() -> Unit) = Layer(context).apply(init).also { addView(it) }
//endregion

//region create widget function by Context
/**
 * create Widget instance within a [Context]
 * param style an style int value defined in xml
 * param init set attributes for this view in this lambda
 */

inline fun Context.View(init: View.() -> Unit) = View(this).apply(init)

inline fun Context.View(style: Int, init: View.() -> Unit) = View(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.ImageView(init: ImageView.() -> Unit) = AppCompatImageView(this).apply(init)

inline fun Context.ImageView(style: Int, init: ImageView.() -> Unit) = AppCompatImageView(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.TextView(init: TextView.() -> Unit) = AppCompatTextView(this).apply(init)

inline fun Context.TextView(style: Int, init: TextView.() -> Unit) = AppCompatTextView(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.Button(init: Button.() -> Unit) = AppCompatButton(this).apply(init)

inline fun Context.Button(style: Int, init: Button.() -> Unit) = AppCompatButton(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.RecyclerView(init: RecyclerView.() -> Unit) = RecyclerView(this).apply(init)

inline fun Context.RecyclerView(style: Int, init: RecyclerView.() -> Unit) = RecyclerView(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.NestedScrollView(init: NestedScrollView.() -> Unit) = NestedScrollView(this).apply(init)

inline fun Context.NestedScrollView(style: Int, init: NestedScrollView.() -> Unit) = NestedScrollView(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.FrameLayout(init: FrameLayout.() -> Unit) = FrameLayout(this).apply(init)

inline fun Context.FrameLayout(style: Int, init: FrameLayout.() -> Unit) = FrameLayout(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.LinearLayout(init: LinearLayout.() -> Unit) = LinearLayout(this).apply(init)

inline fun Context.LinearLayout(style: Int, init: LinearLayout.() -> Unit) = LinearLayout(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.RelativeLayout(init: RelativeLayout.() -> Unit) = RelativeLayout(this).apply(init)

inline fun Context.RelativeLayout(style: Int, init: RelativeLayout.() -> Unit) = RelativeLayout(ContextThemeWrapper(this, style)).apply(init)


inline fun Context.ConstraintLayout(init: ConstraintLayout.() -> Unit) = ConstraintLayout(this).apply(init)

inline fun Context.ConstraintLayout(style: Int, init: ConstraintLayout.() -> Unit) = ConstraintLayout(ContextThemeWrapper(this, style)).apply(init)
//endregion
