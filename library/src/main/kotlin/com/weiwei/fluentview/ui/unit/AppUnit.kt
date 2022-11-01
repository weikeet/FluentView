package com.weiwei.fluentview.ui.unit

import android.content.res.Resources
import com.weiwei.fluentview.app.mainContext
import kotlin.math.roundToInt

// Use system Resources
val Int.dip get() = (this * Resources.getSystem().displayMetrics.density).roundToInt()
val Float.dip get() = (this * Resources.getSystem().displayMetrics.density)

// Use context Resources
val Int.dp get() = (this * mainContext.resources.displayMetrics.density).roundToInt()
val Float.dp get() = (this * mainContext.resources.displayMetrics.density)
val Int.sp get() = (this * mainContext.resources.displayMetrics.scaledDensity).roundToInt()
val Float.sp get() = (this * mainContext.resources.displayMetrics.scaledDensity)
