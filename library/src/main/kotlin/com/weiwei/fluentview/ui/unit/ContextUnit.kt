package com.weiwei.fluentview.ui.unit

import android.content.Context
import kotlin.math.roundToInt

/**
 * @author weiwei
 * @date 2023.01.09
 */

// Use view Resources
fun Context.dp(value: Int): Int = (value * this.resources.displayMetrics.density).roundToInt()
fun Context.dp(value: Float): Float = value * this.resources.displayMetrics.density
