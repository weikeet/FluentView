package com.fluent.view.ui.unit

import android.content.res.Resources
import com.fluent.view.app.mainContext
import kotlin.math.roundToInt

val Int.dp get() = (this * Resources.getSystem().displayMetrics.density).roundToInt()
val Float.dp get() = (this * Resources.getSystem().displayMetrics.density)

val Int.dip get() = (this * mainContext.resources.displayMetrics.density).roundToInt()
val Float.dip get() = (this * mainContext.resources.displayMetrics.density)
