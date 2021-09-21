package com.weicools.fluent.drawable

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.ScaleDrawable
import android.os.Build
import android.view.Gravity

/**
 * @author Weicools
 *
 * @date 2021.09.21
 */

internal typealias ColorInt = Int
internal typealias Px = Int
internal typealias FloatPx = Float
internal typealias Milliseconds = Int
internal typealias GravityInt = Int

fun layerDrawable(vararg drawables: Drawable): LayerDrawable = LayerDrawable(drawables)

inline fun scaleDrawable(scale: Float, gravity: GravityInt = Gravity.CENTER, block: () -> Drawable): ScaleDrawable =
    ScaleDrawable(block(), gravity, scale, scale).also { it.level = 1 }

fun Drawable.copy(): Drawable = constantState!!.newDrawable().mutate()

fun rippleCompat(color: ColorInt, content: Drawable, mask: Drawable?): Drawable =
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> RippleDrawable(ColorStateList.valueOf(color), content, mask)
        else -> stateListDrawable {
            exitFadeDuration = 100

            pressedState {
                content.copy().apply {
                    setColorFilter(color, PorterDuff.Mode.SRC_IN)
                }
            }

            defaultState {
                content
            }
        }
    }