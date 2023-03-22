package com.weiwei.fluentview.ui.unit

import androidx.fragment.app.Fragment
import kotlin.math.roundToInt

/**
 * @author weiwei
 * @date 2023.01.09
 */

// Use view Resources
fun Fragment.dp(value: Int): Int = (value * this.resources.displayMetrics.density).roundToInt()
fun Fragment.dp(value: Float): Float = value * this.resources.displayMetrics.density
