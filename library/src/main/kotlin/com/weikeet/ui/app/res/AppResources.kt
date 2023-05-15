package com.weikeet.ui.app.res

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
import com.weikeet.ui.app.mainContext

//region ColorResources
/**
 * @see [ContextCompat.getColor]
 */
@Suppress("DEPRECATION")
fun colorResourceOf(@ColorRes colorId: Int): Int =
  if (Build.VERSION.SDK_INT >= 23) mainContext.getColor(colorId) else mainContext.resources.getColor(colorId)

/**
 * @see [ContextCompat.getColorStateList]
 */
fun colorStateListOf(@ColorRes colorId: Int): ColorStateList? =
  ResourcesCompat.getColorStateList(mainContext.resources, colorId, mainContext.theme)
//endregion

//region DimenResources
fun dimenResourceOf(@DimenRes dimenId: Int): Float =
  mainContext.resources.getDimension(dimenId)

fun dimenSizeResourceOf(@DimenRes dimenId: Int): Int =
  mainContext.resources.getDimensionPixelSize(dimenId)

fun dimenOffsetResourceOf(@DimenRes dimenId: Int): Int =
  mainContext.resources.getDimensionPixelOffset(dimenId)
//endregion

fun drawableResourceOf(@DrawableRes drawableId: Int): Drawable? =
  ContextCompat.getDrawable(mainContext, drawableId)

fun fontResourceOf(@FontRes fontId: Int): Typeface? =
  ResourcesCompat.getFont(mainContext, fontId)

//region StringResources
fun stringResourceOf(@StringRes id: Int): String =
  mainContext.resources.getString(id)

fun stringResourceOf(@StringRes id: Int, vararg formatArgs: Any): String =
  mainContext.resources.getString(id, *formatArgs)

fun stringArrayResourceOf(@ArrayRes id: Int): Array<String> =
  mainContext.resources.getStringArray(id)

fun pluralStringResourceOf(@PluralsRes id: Int, count: Int): String =
  mainContext.resources.getQuantityString(id, count)

fun pluralStringResourceOf(@PluralsRes id: Int, count: Int, vararg formatArgs: Any): String =
  mainContext.resources.getQuantityString(id, count, *formatArgs)
//endregion
