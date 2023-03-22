package com.weiwei.fluentview.ui.unit

import android.view.View
import kotlin.math.roundToInt

/**
 * @author weiwei
 * @date 2023.01.09
 */

// Use view Resources
fun View.dp(value: Int): Int = (value * this.resources.displayMetrics.density).roundToInt()
fun View.dp(value: Float): Float = value * this.resources.displayMetrics.density
