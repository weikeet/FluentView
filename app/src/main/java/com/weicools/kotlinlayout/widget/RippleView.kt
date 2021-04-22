package com.weicools.kotlinlayout.widget

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Keep
import androidx.interpolator.view.animation.FastOutSlowInInterpolator

/**
 * @author Weicools Create on 2018.12.23
 */
@Suppress("unused")
class RippleView @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

  private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private var centerX: Float = 0f
  private var centerY: Float = 0f

  private var dRadius: Float = 0f

  @get:Keep
  var startRadius: Float = 0f
    @Keep
    set(value) {
      field = value
      invalidate()
    }

  @get:Keep
  var startStrokeWidth = 6.0f
    @Keep
    set(value) {
      field = value
      invalidate()
    }

  private val speed = 0.8f
  private var distance: Int = 0

  private lateinit var animatorSet: AnimatorSet

  private var isCancel: Boolean = false

  init {
    distance = 72
    startRadius = 48f
    dRadius = startRadius

    paint.alpha = 0
    paint.style = Paint.Style.STROKE
    paint.strokeCap = Paint.Cap.ROUND
    paint.color = Color.parseColor("#ffffff")
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    centerX = measuredWidth / 2.0f
    centerY = measuredHeight / 2.0f
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    paint.strokeWidth = this.startStrokeWidth
    canvas.drawCircle(centerX, centerY, startRadius, paint)
  }

  fun startRipple(duration: Long, delay: Long) {
    val interpolator = FastOutSlowInInterpolator()
    val radiusAnimator = ObjectAnimator.ofFloat(this, "startRadius", 50f, 200f)
    radiusAnimator.setDuration(duration).interpolator = interpolator

    val strokeAnimator = ObjectAnimator.ofFloat(this, "startStrokeWidth", 6f, 1f)
    strokeAnimator.setDuration(duration).interpolator = interpolator

    val alphaAnimator = ObjectAnimator.ofFloat(this, "alpha", 0f, 0.4f, 0f)
    alphaAnimator.setDuration(duration).interpolator = interpolator

    animatorSet = AnimatorSet()
    animatorSet.playTogether(radiusAnimator, strokeAnimator, alphaAnimator)
    animatorSet.startDelay = delay
    animatorSet.addListener(object : AnimatorListenerAdapter() {
      override fun onAnimationEnd(animation: Animator) {
        if (isCancel) {
          return
        }
        animatorSet.startDelay = duration
        animatorSet.start()
      }
    })
    animatorSet.start()
  }

  fun stopRipple() {
    isCancel = true
    animatorSet.cancel()
  }
}
