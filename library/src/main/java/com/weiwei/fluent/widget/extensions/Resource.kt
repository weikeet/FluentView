@file:Suppress("unused")

package com.weiwei.fluent.widget.extensions

import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import kotlin.math.roundToInt

/**
 * @author weiwei
 * @date 2020.05.13
 */

//region displayMetrics
val Int.dp get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).roundToInt()

val Float.dp get() = (this * Resources.getSystem().displayMetrics.density)

val widthPixels get() = Resources.getSystem().displayMetrics.widthPixels

val heightPixels get() = Resources.getSystem().displayMetrics.heightPixels
//endregion

//region View extend field: Resource
@Suppress("NOTHING_TO_INLINE")
inline fun View.string_of(@StringRes stringId: Int): String =
  context.getString(stringId)

@Suppress("NOTHING_TO_INLINE")
inline fun View.strings_of(@StringRes stringId: Int, vararg formatArgs: Any): String =
  context.getString(stringId, *formatArgs)

@Suppress("NOTHING_TO_INLINE")
inline fun View.color_of(@ColorRes colorId: Int): Int =
  ContextCompat.getColor(context, colorId)

@Suppress("NOTHING_TO_INLINE")
inline fun View.colors_of(@ColorRes colorId: Int): ColorStateList? =
  ContextCompat.getColorStateList(context, colorId)

@Suppress("NOTHING_TO_INLINE")
inline fun View.drawable_of(@DrawableRes drawableId: Int): Drawable? =
  if (Build.VERSION.SDK_INT >= 21) {
    ContextCompat.getDrawable(context, drawableId)
  } else {
    AppCompatResources.getDrawable(context, drawableId)
  }

@Suppress("NOTHING_TO_INLINE")
inline fun View.dimen_of(@DimenRes dimenId: Int): Float =
  context.resources.getDimension(dimenId)

@Suppress("NOTHING_TO_INLINE")
inline fun View.dimenSize_of(@DimenRes dimenId: Int): Int =
  context.resources.getDimensionPixelSize(dimenId)

@Suppress("NOTHING_TO_INLINE")
inline fun View.dimenOffset_of(@DimenRes dimenId: Int): Int =
  context.resources.getDimensionPixelOffset(dimenId)

@Suppress("NOTHING_TO_INLINE")
inline fun View.font_of(@FontRes fontId: Int): Typeface? =
  ResourcesCompat.getFont(context, fontId)

//endregion
