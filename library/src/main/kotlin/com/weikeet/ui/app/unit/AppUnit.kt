package com.weikeet.ui.app.unit

import com.weikeet.ui.app.mainContext

// Use app context Resources
fun Int.dpOf(value: Int): Int = (value * mainContext.resources.displayMetrics.density + 0.5f).toInt()
fun Int.dpOf(value: Float): Float = value * mainContext.resources.displayMetrics.density
