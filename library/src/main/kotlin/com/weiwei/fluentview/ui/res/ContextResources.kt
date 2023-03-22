package com.weiwei.fluentview.ui.res

import android.content.Context
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

//region ColorResources
/**
 * @see [ContextCompat.getColor]
 */
@Suppress("DEPRECATION")
fun Context.colorResource(@ColorRes colorId: Int): Int =
  if (Build.VERSION.SDK_INT >= 23) this.getColor(colorId) else this.resources.getColor(colorId)

/**
 * @see [ContextCompat.getColorStateList]
 */
fun Context.colorStateList(@ColorRes colorId: Int): ColorStateList? =
  ResourcesCompat.getColorStateList(this.resources, colorId, this.theme)
//endregion

//region DimenResources
fun Context.dimenResource(@DimenRes dimenId: Int): Float =
  this.resources.getDimension(dimenId)

fun Context.dimenSizeResource(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelSize(dimenId)

fun Context.dimenOffsetResource(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelOffset(dimenId)
//endregion

fun Context.drawableResource(@DrawableRes drawableId: Int): Drawable? =
  ContextCompat.getDrawable(this, drawableId)

fun Context.fontResource(@FontRes fontId: Int): Typeface? =
  ResourcesCompat.getFont(this, fontId)

//region StringResources
fun Context.stringResource(@StringRes id: Int): String =
  this.resources.getString(id)

fun Context.stringResource(@StringRes id: Int, vararg formatArgs: Any): String =
  this.resources.getString(id, *formatArgs)

fun Context.stringArrayResource(@ArrayRes id: Int): Array<String> =
  this.resources.getStringArray(id)

fun Context.pluralStringResource(@PluralsRes id: Int, count: Int): String =
  this.resources.getQuantityString(id, count)

fun Context.pluralStringResource(@PluralsRes id: Int, count: Int, vararg formatArgs: Any): String =
  this.resources.getQuantityString(id, count, *formatArgs)
//endregion
