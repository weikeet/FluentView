package com.weicools.kotlinlayout

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.widget.chainPacked
import com.weicools.kotlinlayout.widget.constraintLayoutParams
import com.weicools.kotlinlayout.widget.createRefs
import com.weicools.kotlinlayout.widget.dp
import com.weicools.kotlinlayout.widget.imageView
import com.weicools.kotlinlayout.widget.image_resource
import com.weicools.kotlinlayout.widget.parentId
import com.weicools.kotlinlayout.widget.textView

/**
 * @author weicools
 * @date 2021.05.08
 */
@SuppressLint("SetTextI18n")
class HelloKotlinDslLayout : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    createView()
  }

  private fun createView() {
    val (iconId, textId) = createRefs()

    imageView(iconId) {
      layoutParams = constraintLayoutParams(40.dp, 40.dp) {
        leftToLeft = parentId
        topToTop = parentId
        rightToRight = parentId
        bottomToTop = textId
        verticalChainStyle = chainPacked
      }
      image_resource = R.drawable.ic_android_24dp
    }

    textView(textId) {
      layoutParams = constraintLayoutParams {
        topMargin = 8.dp
        leftToLeft = parentId
        topToBottom = iconId
        rightToRight = parentId
        bottomToBottom = parentId
      }
      text = "Hello Android"
    }

    // materialButton(style = R.style.AppWidget_MaterialButton) {
    //   layoutParams = constraintLayoutParams {
    //     topMargin = 48.dp
    //     leftToLeft = parentId
    //     topToBottom = iconId
    //     rightToRight = parentId
    //     bottomToBottom = parentId
    //   }
    //   text = "Hello Android"
    // }
  }
}