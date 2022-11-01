package com.weiwei.fluentview.ui.res

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Point
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.WindowManager
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.weiwei.fluentview.app.mainContext

//region ColorResources
/**
 * @see [ContextCompat.getColor]
 */
@Suppress("DEPRECATION")
fun colorResource(@ColorRes colorId: Int): Int =
  if (Build.VERSION.SDK_INT >= 23) mainContext.getColor(colorId) else mainContext.resources.getColor(colorId)

/**
 * @see [ContextCompat.getColorStateList]
 */
fun colorStateList(@ColorRes colorId: Int): ColorStateList? =
  ResourcesCompat.getColorStateList(mainContext.resources, colorId, mainContext.theme)
//endregion

//region DimenResources
fun dimenResource(@DimenRes dimenId: Int): Float =
  mainContext.resources.getDimension(dimenId)

fun dimenSizeResource(@DimenRes dimenId: Int): Int =
  mainContext.resources.getDimensionPixelSize(dimenId)

fun dimenOffsetResource(@DimenRes dimenId: Int): Int =
  mainContext.resources.getDimensionPixelOffset(dimenId)
//endregion

fun drawableResource(@DrawableRes drawableId: Int): Drawable? =
  ContextCompat.getDrawable(mainContext, drawableId)

fun fontResource(@FontRes fontId: Int): Typeface? =
  ResourcesCompat.getFont(mainContext, fontId)

//region StringResources
fun stringResource(@StringRes id: Int): String =
  mainContext.resources.getString(id)

fun stringResource(@StringRes id: Int, vararg formatArgs: Any): String =
  mainContext.resources.getString(id, *formatArgs)

fun stringArrayResource(@ArrayRes id: Int): Array<String> =
  mainContext.resources.getStringArray(id)

fun pluralStringResource(@PluralsRes id: Int, count: Int): String =
  mainContext.resources.getQuantityString(id, count)

fun pluralStringResource(@PluralsRes id: Int, count: Int, vararg formatArgs: Any): String =
  mainContext.resources.getQuantityString(id, count, *formatArgs)
//endregion

//region ScreenInfo
val screenWidthPixels: Int by lazy(LazyThreadSafetyMode.NONE) {
  Resources.getSystem().displayMetrics.widthPixels
}

// 一般来说是 屏幕真实高度 - 虚拟导航栏/手势导航栏高度, see: juejin.cn/post/6908862707374489607
val screenHeightPixels: Int by lazy(LazyThreadSafetyMode.NONE) {
  Resources.getSystem().displayMetrics.heightPixels
}

// 屏幕真实宽度
val screenWidth: Int by lazy(LazyThreadSafetyMode.NONE) {
  val wm = mainContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    wm.currentWindowMetrics.bounds.width()
  } else {
    @Suppress("DEPRECATION")
    Point().also { wm.defaultDisplay.getRealSize(it) }.x
  }
}

// 屏幕真实高度
val screenHeight: Int by lazy(LazyThreadSafetyMode.NONE) {
  val wm = mainContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    wm.currentWindowMetrics.bounds.height()
  } else {
    @Suppress("DEPRECATION")
    Point().also { wm.defaultDisplay.getRealSize(it) }.y
  }
}
//endregion
