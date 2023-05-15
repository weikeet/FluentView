package com.weikeet.ui.graphics.drawable

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.ScaleDrawable
import android.view.Gravity

/**
 * @author weiwei
 *
 * @date 2021.09.21
 */

internal typealias IntPx = Int
internal typealias FloatPx = Float
internal typealias ColorInt = Int

fun Drawable.copy(): Drawable = constantState!!.newDrawable().mutate()

fun layerDrawable(vararg drawables: Drawable): LayerDrawable = LayerDrawable(drawables)

inline fun scaleDrawable(scale: Float, gravity: Int = Gravity.CENTER, block: () -> Drawable): ScaleDrawable =
  ScaleDrawable(block(), gravity, scale, scale).also { it.level = 1 }

fun rippleDrawable(color: ColorInt, content: Drawable?, mask: Drawable?): Drawable =
  RippleDrawable(ColorStateList.valueOf(color), content, mask)
