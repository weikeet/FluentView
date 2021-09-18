package com.weicools.fluentlayout

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import com.weicools.fluentlayout.widget.extensions.dp
import org.jetbrains.anko.imageView
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * @author weicools
 * @date 2021.05.14
 */
class HelloAnkoLayout : FrameLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    createView()
  }

  private fun createView() {
    verticalLayout {
      gravity = Gravity.CENTER

      imageView(R.drawable.ic_android_24dp).lparams(40.dp, 40.dp)

      textView("Hello Android").lparams { topMargin = 8.dp }
    }
  }
}