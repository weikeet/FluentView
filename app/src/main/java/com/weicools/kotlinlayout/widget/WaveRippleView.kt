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
import android.util.Log
import android.view.View
import androidx.annotation.Keep
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.weicools.kotlinlayout.dsl.dp

/**
 * @author Weicools Create on 2018.12.21
 *
 *
 * desc:
 */
class WaveRippleView : View {
  private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private var centerX: Float = 0.toFloat()
  private var centerY: Float = 0.toFloat()

  private var minRadius: Float = 0.toFloat()
  private var maxRadius: Float = 0.toFloat()

  @get:Keep
  var radius: Float = 0.toFloat()
    @Keep
    set(radius) {
      field = radius
      invalidate()
    }

  @get:Keep
  var strokeWidth: Float = 0.toFloat()
    @Keep
    set(strokeWidth) {
      field = strokeWidth
      invalidate()
    }

  private var isCancel: Boolean = false
  private var animatorSet: AnimatorSet? = null

  constructor(context: Context) : super(context) {
    init(context)
  }

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    init(context)
  }

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    init(context)
  }

  private fun init(context: Context) {
    minRadius = 16.dp.toFloat()
    maxRadius = 68.dp.toFloat()

    paint = Paint()
    paint.isAntiAlias = true
    paint.style = Paint.Style.STROKE
    paint.strokeCap = Paint.Cap.ROUND
    paint.color = Color.WHITE
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    centerX = measuredWidth / 2.0f
    centerY = measuredHeight / 2.0f
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    paint.strokeWidth = this.strokeWidth
    canvas.drawCircle(centerX, centerY, this.radius, paint)
  }

  fun startRipple(duration: Long, intervalTime: Long, delay: Long) {
    val interpolator = FastOutSlowInInterpolator()
    val radiusAnimator = ObjectAnimator.ofFloat(this, "radius", minRadius, maxRadius)
    radiusAnimator.setDuration(duration).interpolator = interpolator

    val strokeAnimator = ObjectAnimator.ofFloat(this, "strokeWidth", 6f, 1f)
    strokeAnimator.setDuration(duration).interpolator = interpolator

    val alphaAnimator = ObjectAnimator.ofFloat(this, "alpha", 0f, 0.4f, 0f)
    alphaAnimator.setDuration(duration).interpolator = interpolator

    animatorSet = AnimatorSet()
    animatorSet!!.playTogether(radiusAnimator, strokeAnimator, alphaAnimator)
    animatorSet!!.startDelay = delay
    animatorSet!!.addListener(object : AnimatorListenerAdapter() {
      override fun onAnimationStart(animation: Animator) {
        super.onAnimationStart(animation)
        Log.e("ZZW", "onAnimationStart: ")
      }

      override fun onAnimationEnd(animation: Animator) {
        Log.e("ZZW", "onAnimationEnd: ")
        if (isCancel) {
          return
        }
        animatorSet!!.startDelay = 2 * duration / 3 + intervalTime
        animatorSet!!.start()
      }

      override fun onAnimationCancel(animation: Animator) {
        super.onAnimationCancel(animation)
        Log.e("ZZW", "onAnimationCancel: ")
      }
    })
    animatorSet!!.start()
  }

  fun stopRipple() {
    if (animatorSet != null) {
      isCancel = true
      animatorSet!!.cancel()
      animatorSet = null
    }
  }
}
