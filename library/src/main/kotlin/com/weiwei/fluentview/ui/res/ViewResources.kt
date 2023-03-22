package com.weiwei.fluentview.ui.res

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
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
fun View.colorResource(@ColorRes colorId: Int): Int =
  if (Build.VERSION.SDK_INT >= 23) this.context.getColor(colorId) else this.context.resources.getColor(colorId)

/**
 * @see [ContextCompat.getColorStateList]
 */
fun View.colorStateList(@ColorRes colorId: Int): ColorStateList? =
  ResourcesCompat.getColorStateList(this.resources, colorId, this.context.theme)
//endregion

//region DimenResources
fun View.dimenResource(@DimenRes dimenId: Int): Float =
  this.resources.getDimension(dimenId)

fun View.dimenSizeResource(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelSize(dimenId)

fun View.dimenOffsetResource(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelOffset(dimenId)
//endregion

fun View.drawableResource(@DrawableRes drawableId: Int): Drawable? =
  ContextCompat.getDrawable(this.context, drawableId)

fun View.fontResource(@FontRes fontId: Int): Typeface? =
  ResourcesCompat.getFont(this.context, fontId)

//region StringResources
fun View.stringResource(@StringRes id: Int): String =
  this.resources.getString(id)

fun View.stringResource(@StringRes id: Int, vararg formatArgs: Any): String =
  this.resources.getString(id, *formatArgs)

fun View.stringArrayResource(@ArrayRes id: Int): Array<String> =
  this.resources.getStringArray(id)

fun View.pluralStringResource(@PluralsRes id: Int, count: Int): String =
  this.resources.getQuantityString(id, count)

fun View.pluralStringResource(@PluralsRes id: Int, count: Int, vararg formatArgs: Any): String =
  this.resources.getQuantityString(id, count, *formatArgs)
//endregion
