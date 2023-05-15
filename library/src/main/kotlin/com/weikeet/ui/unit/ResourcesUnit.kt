package com.weikeet.ui.unit

import android.content.Context
import android.content.res.Resources
import android.view.View
import androidx.fragment.app.Fragment

// Use system resources
val Int.dp get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
val Float.dp get() = (this * Resources.getSystem().displayMetrics.density)

// Use context Resources
fun Context.dp(value: Int): Int = (value * this.resources.displayMetrics.density + 0.5f).toInt()
fun Context.dp(value: Float): Float = value * this.resources.displayMetrics.density

// Use fragment resources
fun Fragment.dp(value: Int): Int = (value * this.resources.displayMetrics.density + 0.5f).toInt()
fun Fragment.dp(value: Float): Float = value * this.resources.displayMetrics.density

// Use view Resources
fun View.dp(value: Int): Int = (value * this.resources.displayMetrics.density + 0.5f).toInt()
fun View.dp(value: Float): Float = value * this.resources.displayMetrics.density
