package com.weikeet.ui.res

import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment

//region ColorResources with context
/**
 * @see [ContextCompat.getColor]
 */
@Suppress("DEPRECATION")
fun Context.colorResources(@ColorRes colorId: Int): Int =
  if (Build.VERSION.SDK_INT >= 23) this.getColor(colorId) else this.resources.getColor(colorId)

/**
 * @see [ContextCompat.getColorStateList]
 */
fun Context.colorStateList(@ColorRes colorId: Int): ColorStateList? =
  ResourcesCompat.getColorStateList(this.resources, colorId, this.theme)
//endregion

//region ColorResources with fragment
/**
 * @see [ContextCompat.getColor]
 */
@Suppress("DEPRECATION")
fun Fragment.colorResources(@ColorRes colorId: Int): Int =
  if (Build.VERSION.SDK_INT >= 23) this.requireContext().getColor(colorId) else this.resources.getColor(colorId)

/**
 * @see [ContextCompat.getColorStateList]
 */
fun Fragment.colorStateList(@ColorRes colorId: Int): ColorStateList? =
  ResourcesCompat.getColorStateList(this.resources, colorId, this.requireContext().theme)
//endregion

//region ColorResources with view
/**
 * @see [ContextCompat.getColor]
 */
@Suppress("DEPRECATION")
fun View.colorResources(@ColorRes colorId: Int): Int =
  if (Build.VERSION.SDK_INT >= 23) this.context.getColor(colorId) else this.context.resources.getColor(colorId)

/**
 * @see [ContextCompat.getColorStateList]
 */
fun View.colorStateList(@ColorRes colorId: Int): ColorStateList? =
  ResourcesCompat.getColorStateList(this.resources, colorId, this.context.theme)
//endregion
