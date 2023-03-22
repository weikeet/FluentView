package com.weiwei.fluentview.ui.res

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment

//region ColorResources
/**
 * @see [ContextCompat.getColor]
 */
@Suppress("DEPRECATION")
fun Fragment.colorResource(@ColorRes colorId: Int): Int =
  if (Build.VERSION.SDK_INT >= 23) this.requireContext().getColor(colorId) else this.resources.getColor(colorId)

/**
 * @see [ContextCompat.getColorStateList]
 */
fun Fragment.colorStateList(@ColorRes colorId: Int): ColorStateList? =
  ResourcesCompat.getColorStateList(this.resources, colorId, this.requireContext().theme)
//endregion

//region DimenResources
fun Fragment.dimenResource(@DimenRes dimenId: Int): Float =
  this.resources.getDimension(dimenId)

fun Fragment.dimenSizeResource(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelSize(dimenId)

fun Fragment.dimenOffsetResource(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelOffset(dimenId)
//endregion

fun Fragment.drawableResource(@DrawableRes drawableId: Int): Drawable? =
  ContextCompat.getDrawable(this.requireContext(), drawableId)

fun Fragment.fontResource(@FontRes fontId: Int): Typeface? =
  ResourcesCompat.getFont(this.requireContext(), fontId)

//region StringResources
fun Fragment.stringResource(@StringRes id: Int): String =
  this.resources.getString(id)

fun Fragment.stringResource(@StringRes id: Int, vararg formatArgs: Any): String =
  this.resources.getString(id, *formatArgs)

fun Fragment.stringArrayResource(@ArrayRes id: Int): Array<String> =
  this.resources.getStringArray(id)

fun Fragment.pluralStringResource(@PluralsRes id: Int, count: Int): String =
  this.resources.getQuantityString(id, count)

fun Fragment.pluralStringResource(@PluralsRes id: Int, count: Int, vararg formatArgs: Any): String =
  this.resources.getQuantityString(id, count, *formatArgs)
//endregion
