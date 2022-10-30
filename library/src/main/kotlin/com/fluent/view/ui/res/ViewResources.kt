package com.fluent.view.ui.res

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
  if (Build.VERSION.SDK_INT >= 23) context.getColor(colorId) else context.resources.getColor(colorId)

/**
 * @see [ContextCompat.getColorStateList]
 */
fun View.colorStateList(@ColorRes colorId: Int): ColorStateList? =
  ResourcesCompat.getColorStateList(context.resources, colorId, context.theme)
//endregion

//region DimenResource
fun View.dimenResource(@DimenRes dimenId: Int): Float =
  context.resources.getDimension(dimenId)

fun View.dimenSizeResource(@DimenRes dimenId: Int): Int =
  context.resources.getDimensionPixelSize(dimenId)

fun View.dimenOffsetResource(@DimenRes dimenId: Int): Int =
  context.resources.getDimensionPixelOffset(dimenId)
//endregion

fun View.drawableResource(@DrawableRes drawableId: Int): Drawable? =
  ContextCompat.getDrawable(context, drawableId)

fun View.fontResource(@FontRes fontId: Int): Typeface? =
  ResourcesCompat.getFont(context, fontId)

//region StringResources
fun View.stringResource(@StringRes id: Int): String =
  context.resources.getString(id)

fun View.stringResource(@StringRes id: Int, vararg formatArgs: Any): String =
  context.resources.getString(id, *formatArgs)

fun View.stringArrayResource(@ArrayRes id: Int): Array<String> =
  context.resources.getStringArray(id)

fun View.pluralStringResource(@PluralsRes id: Int, count: Int): String =
  context.resources.getQuantityString(id, count)

fun View.pluralStringResource(@PluralsRes id: Int, count: Int, vararg formatArgs: Any): String =
  context.resources.getQuantityString(id, count, *formatArgs)
//endregion
