package com.weicools.kotlinlayout.more

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.R
import com.weicools.kotlinlayout.widget.background_colorRes

/**
 * @author weicools
 * @date 2021.04.23
 */
class MoreToolView : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    background_colorRes = R.color.white_primary
    inflate(context, R.layout.item_more_tools, this)
  }
}