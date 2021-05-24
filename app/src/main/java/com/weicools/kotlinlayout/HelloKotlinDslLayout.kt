package com.weicools.kotlinlayout

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.widget.dsl.constraintLayout
import com.weicools.kotlinlayout.widget.dsl.imageView
import com.weicools.kotlinlayout.widget.dsl.textView
import com.weicools.kotlinlayout.widget.extensions.dp
import com.weicools.kotlinlayout.widget.extensions.image_resource
import com.weicools.kotlinlayout.widget.ids.createRefs
import com.weicools.kotlinlayout.widget.params.chainPacked
import com.weicools.kotlinlayout.widget.params.constraintParams
import com.weicools.kotlinlayout.widget.params.matchParent
import com.weicools.kotlinlayout.widget.params.parentId

/**
 * @author weicools
 * @date 2021.05.08
 */
@SuppressLint("SetTextI18n")
class HelloKotlinDslLayout : FrameLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  val v = constraintLayout {
    layoutParams = constraintParams(matchParent, matchParent) { }

    val (iconId, textId) = createRefs()

    imageView(iconId) {
      layoutParams = constraintParams(40.dp, 40.dp) {
        leftToLeft = parentId
        topToTop = parentId
        rightToRight = parentId
        bottomToTop = textId
        verticalChainStyle = chainPacked
      }
      image_resource = R.drawable.ic_android_24dp
    }

    textView(textId) {
      layoutParams = constraintParams {
        topMargin = 8.dp
        leftToLeft = parentId
        topToBottom = iconId
        rightToRight = parentId
        bottomToBottom = parentId
      }
      text = "Hello Android"
    }
  }

  init {
    createView()
  }

  private fun createView() {
    // materialButton(style = R.style.AppWidget_MaterialButton) {
    //   layoutParams = constraintParams {
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