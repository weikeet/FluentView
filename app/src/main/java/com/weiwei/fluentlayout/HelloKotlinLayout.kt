package com.weiwei.fluentlayout

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import com.weiwei.fluent.widget.extensions.dp

/**
 * @author weiwei
 * @date 2021.05.08
 */
@SuppressLint("SetTextI18n")
class HelloKotlinLayout : FrameLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  val v = ConstraintLayout(context).apply {
    val iconId = ViewCompat.generateViewId()
    val textId = ViewCompat.generateViewId()

    AppCompatImageView(context).apply {
      id = iconId
      layoutParams = ConstraintLayout.LayoutParams(40.dp, 40.dp).apply {
        leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        bottomToTop = textId
        verticalChainStyle = ConstraintLayout.LayoutParams.CHAIN_PACKED
      }
      setImageResource(R.drawable.ic_android_24dp)
    }.also { addView(it) }

    AppCompatTextView(context).apply {
      id = textId
      layoutParams = ConstraintLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
        topMargin = 8.dp
        leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        topToBottom = iconId
        rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
      }
      text = "Hello Android"
    }.also { addView(it) }
  }.also { addView(it, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT) }
}