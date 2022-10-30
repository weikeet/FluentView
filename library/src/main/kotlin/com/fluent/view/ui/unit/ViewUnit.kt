package com.fluent.view.ui.unit

import android.view.View
import kotlin.math.roundToInt

fun View.dip(value: Int): Int = (value * resources.displayMetrics.density).roundToInt()
fun View.dip(value: Float): Float = (value * resources.displayMetrics.density)

fun View.sp(value: Int): Int = (value * resources.displayMetrics.scaledDensity).roundToInt()
fun View.sp(value: Float): Float = (value * resources.displayMetrics.scaledDensity)
