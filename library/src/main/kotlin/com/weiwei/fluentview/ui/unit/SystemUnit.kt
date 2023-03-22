package com.weiwei.fluentview.ui.unit

import android.content.res.Resources
import kotlin.math.roundToInt

// Use system resources
val Int.dp get() = (this * Resources.getSystem().displayMetrics.density).roundToInt()
val Float.dp get() = (this * Resources.getSystem().displayMetrics.density)
