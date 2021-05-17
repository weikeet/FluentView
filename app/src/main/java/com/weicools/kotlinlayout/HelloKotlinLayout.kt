package com.weicools.kotlinlayout

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import com.weicools.kotlinlayout.widget.dp

/**
 * @author weicools
 * @date 2021.05.08
 */
@SuppressLint("SetTextI18n")
class HelloKotlinLayout : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    createView()
  }

  private fun createView() {
    val iconId = ViewCompat.generateViewId()
    val textId = ViewCompat.generateViewId()

    AppCompatImageView(context).apply {
      id = iconId
      layoutParams = LayoutParams(40.dp, 40.dp).apply {
        leftToLeft = LayoutParams.PARENT_ID
        topToTop = LayoutParams.PARENT_ID
        rightToRight = LayoutParams.PARENT_ID
        bottomToTop = textId
        verticalChainStyle = LayoutParams.CHAIN_PACKED
      }
      setImageResource(R.drawable.ic_android_24dp)
    }.also { addView(it) }

    AppCompatTextView(context).apply {
      id = textId
      layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
        topMargin = 8.dp
        leftToLeft = LayoutParams.PARENT_ID
        topToBottom = iconId
        rightToRight = LayoutParams.PARENT_ID
        bottomToBottom = LayoutParams.PARENT_ID
      }
      text = "Hello Android"
    }.also { addView(it) }
  }
}