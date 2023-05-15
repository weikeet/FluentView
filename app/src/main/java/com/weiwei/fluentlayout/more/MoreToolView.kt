package com.weiwei.fluentlayout.more

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weikeet.ui.view.constraint.constraintVertical
import com.weikeet.ui.view.constraint.guideline
import com.weikeet.ui.widget.backgroundResource
import com.weiwei.fluentlayout.R

/**
 * @author weiwei
 * @date 2021.04.23
 */
class MoreToolView : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    initView()
  }

  private fun initView() {
    guideline(0) {
      orientation = constraintVertical
      guideBegin = 20
    }
    backgroundResource = R.color.white_primary
    inflate(context, R.layout.item_more_tools, this)
  }
}