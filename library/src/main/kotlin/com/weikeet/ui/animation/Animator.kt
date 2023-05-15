package com.weikeet.ui.animation

import android.animation.ValueAnimator

inline fun createIntAnimation(vararg value: Int, action: ValueAnimator.() -> Unit): ValueAnimator {
  return ValueAnimator.ofInt(*value).apply(action)
}

inline fun createFloatAnimation(vararg value: Float, action: ValueAnimator.() -> Unit): ValueAnimator {
  return ValueAnimator.ofFloat(*value).apply(action)
}

inline fun startIntAnimation(vararg value: Int, action: ValueAnimator.() -> Unit): ValueAnimator {
  val animator = ValueAnimator.ofInt(*value).apply(action)
  animator.start()
  return animator
}

inline fun startFloatAnimation(vararg value: Float, action: ValueAnimator.() -> Unit): ValueAnimator {
  val animator = ValueAnimator.ofFloat(*value).apply(action)
  animator.start()
  return animator
}

inline fun ValueAnimator.doOnIntUpdate(
  crossinline action: (animatedValue: Int) -> Unit
) {
  addUpdateListener {
    action(it.animatedValue as Int)
  }
}

inline fun ValueAnimator.doOnFloatUpdate(
  crossinline action: (animatedValue: Float) -> Unit
) {
  addUpdateListener {
    action(it.animatedValue as Float)
  }
}
