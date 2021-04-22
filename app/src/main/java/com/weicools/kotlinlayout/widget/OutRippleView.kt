package com.weicools.kotlinlayout.widget

import android.animation.*
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Keep

/**
 * @author Weicools Create on 2018.12.23
 *
 * desc:
 */
class OutRippleView : View {

  private val stopRunnable = Runnable { stopRipple() }

  private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

  private var centerX: Float = 0.toFloat()
  private var centerY: Float = 0.toFloat()

  private var innerStrokeWidth: Float = 0.toFloat()
  private var staticInnerRadius: Float = 0.toFloat()

  @get:Keep
  var dynamicInnerRadius: Float = 0.toFloat()
    set(value) {
      field = value
      invalidate()
    }

  @get:Keep
  @set:Keep
  var dynamicOuterStrokeWidth: Float = 0.toFloat()
  private var staticOuterRadius: Float = 0.toFloat()
  private var staticOuterStrokeWidth: Float = 0.toFloat()

  @get:Keep
  @set:Keep
  var dynamicOuterRadius: Float = 0.toFloat()

  private var animationRunning: Boolean = false

  private var innerRadiusAnimator: ObjectAnimator? = null
  private var outerRadiusAnimator: ObjectAnimator? = null
  private var outerStrokeWidthAnimator: ObjectAnimator? = null
  private var animatorSet: AnimatorSet? = null

  private var isReset: Boolean = false

  constructor(context: Context) : super(context) {
    init()
  }

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    init()
  }

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    init()
  }

  private fun init() {
    paint = Paint(Paint.ANTI_ALIAS_FLAG)
    paint.color = Color.parseColor("#4396f4")
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    centerX = (measuredWidth / 2).toFloat()
    centerY = measuredHeight * CIRCLE_CENTER_Y

    // 默认状态下的圆环环宽度与宽度的比值
    val strokeWidthRatio = 0.083f
    innerStrokeWidth = measuredWidth * strokeWidthRatio
    // 默认状态下的圆环半径与宽度的比值
    val radiusRatio = 0.386f
    staticInnerRadius = measuredWidth * radiusRatio
    dynamicInnerRadius = staticInnerRadius

    staticOuterStrokeWidth = innerStrokeWidth
    dynamicOuterStrokeWidth = staticOuterStrokeWidth
    staticOuterRadius = staticInnerRadius
    dynamicOuterRadius = staticInnerRadius
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    paint.style = Paint.Style.STROKE
    paint.strokeWidth = innerStrokeWidth
    canvas.drawCircle(centerX, centerY, dynamicInnerRadius, paint)

    paint.strokeWidth = dynamicOuterStrokeWidth
    canvas.drawCircle(centerX, centerY, dynamicOuterRadius, paint)
  }

  fun startRipple() {
    isReset = false
    if (animationRunning) {
      return
    }

    val keyframe1 = Keyframe.ofFloat(0f, staticInnerRadius * 1f)
    val keyframe2 = Keyframe.ofFloat(0.167f, staticInnerRadius * 1.079f)
    val keyframe3 = Keyframe.ofFloat(0.667f, staticInnerRadius * 1f)
    val keyframe4 = Keyframe.ofFloat(1f, staticInnerRadius * 1f)

    val holder = PropertyValuesHolder.ofKeyframe("dynamicInnerRadius", keyframe1, keyframe2, keyframe3, keyframe4)
    innerRadiusAnimator = ObjectAnimator.ofPropertyValuesHolder(this, holder)
    innerRadiusAnimator!!.repeatCount = ValueAnimator.INFINITE

    innerRadiusAnimator!!.addListener(object : AnimatorListenerAdapter() {

      override fun onAnimationRepeat(animation: Animator) {
        super.onAnimationRepeat(animation)
        if (isReset) {
          isReset = false
          post(stopRunnable)
        }
      }
    })

    outerRadiusAnimator = ObjectAnimator.ofFloat(this, "dynamicOuterRadius", staticOuterRadius, staticOuterRadius * 1.559f)
    outerRadiusAnimator!!.repeatCount = ValueAnimator.INFINITE

    outerStrokeWidthAnimator = ObjectAnimator.ofFloat(this, "dynamicOuterStrokeWidth", staticOuterStrokeWidth, 0f)
    outerStrokeWidthAnimator!!.repeatCount = ValueAnimator.INFINITE

    animatorSet = AnimatorSet()
    animatorSet!!.playTogether(innerRadiusAnimator, outerRadiusAnimator, outerStrokeWidthAnimator)
    animatorSet!!.duration = 2000L
    animatorSet!!.start()

    animationRunning = true
  }

  fun resetRipple() {
    isReset = true
  }

  fun stopRipple() {
    if (!animationRunning) {
      return
    }

    if (animatorSet != null) {
      animatorSet!!.cancel()
      animatorSet = null
    }

    if (innerRadiusAnimator != null) {
      innerRadiusAnimator!!.cancel()
      innerRadiusAnimator = null
    }

    if (outerRadiusAnimator != null) {
      outerRadiusAnimator!!.cancel()
      outerRadiusAnimator = null
    }

    if (outerStrokeWidthAnimator != null) {
      outerStrokeWidthAnimator!!.cancel()
      outerStrokeWidthAnimator = null
    }

    removeCallbacks(stopRunnable)

    animationRunning = false
  }

  companion object {
    var CIRCLE_CENTER_Y = 0.453f
  }
}
