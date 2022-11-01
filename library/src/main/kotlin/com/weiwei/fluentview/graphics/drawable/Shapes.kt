package com.weiwei.fluentview.graphics.drawable

import android.graphics.drawable.GradientDrawable
import com.weiwei.fluentview.annotation.NO_GETTER
import com.weiwei.fluentview.annotation.noGetter

/**
 * @author weiwei
 *
 * @date 2021.09.21
 */

inline val GradientDrawable.shapeRectangle: Int get() = GradientDrawable.RECTANGLE
inline val GradientDrawable.shapeOval: Int get() = GradientDrawable.OVAL
inline val GradientDrawable.shapeLine: Int get() = GradientDrawable.LINE
inline val GradientDrawable.shapeRing: Int get() = GradientDrawable.RING

var GradientDrawable.solidColor: ColorInt
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setColor(value)

var GradientDrawable.size: IntPx
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setSize(value, value)

class Size {
  var width: IntPx = -1
  var height: IntPx = -1
}

inline fun GradientDrawable.size(fill: Size.() -> Unit): Size =
  Size().also {
    it.fill()
    setSize(it.width, it.height)
  }

class Stroke {
  var width: IntPx = -1
  var color: ColorInt = -1
  var dashWidth: FloatPx = 0F
  var dashGap: FloatPx = 0F
}

inline fun GradientDrawable.stroke(fill: Stroke.() -> Unit): Stroke =
  Stroke().also {
    it.fill()
    setStroke(it.width, it.color, it.dashWidth, it.dashGap)
  }

class Corners {
  var radius: FloatPx = 0F

  var topLeft: FloatPx = Float.NaN
  var topRight: FloatPx = Float.NaN
  var bottomLeft: FloatPx = Float.NaN
  var bottomRight: FloatPx = Float.NaN

  internal fun FloatPx.orRadius(): FloatPx = takeIf { it > 0 } ?: radius
}

fun Corners.render(): FloatArray = floatArrayOf(
  topLeft.orRadius(),
  topLeft.orRadius(),

  topRight.orRadius(),
  topRight.orRadius(),

  bottomLeft.orRadius(),
  bottomLeft.orRadius(),

  bottomRight.orRadius(),
  bottomRight.orRadius()
)

inline fun GradientDrawable.corners(fill: Corners.() -> Unit): Corners =
  Corners().also {
    it.fill()
    cornerRadii = it.render()
  }

inline fun shapeDrawable(fill: GradientDrawable.() -> Unit): GradientDrawable =
  GradientDrawable().also {
    it.gradientType = GradientDrawable.LINEAR_GRADIENT
    it.fill()
  }

fun rectangleShape(radius: FloatPx = Float.NaN, color: ColorInt, size: IntPx? = null): GradientDrawable =
  shapeDrawable {
    shape = shapeRectangle

    if (!radius.isNaN()) {
      cornerRadius = radius
    }

    solidColor = color

    size?.let { this.size = it }
  }

fun circleShape(color: ColorInt, size: IntPx? = null): GradientDrawable =
  shapeDrawable {
    shape = shapeOval

    solidColor = color

    size?.let { this.size = it }
  }
