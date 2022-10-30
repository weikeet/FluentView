package com.weiwei.fluentlayout.anko

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import com.weiwei.fluentlayout.R
import org.jetbrains.anko.dip
import org.jetbrains.anko.imageView
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * @author weiwei
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

      imageView(R.drawable.ic_android_24dp).lparams(dip(40), dip(40))

      textView("Hello Android").lparams { topMargin = dip(8) }
    }
  }
}