package com.weiwei.fluentlayout.more

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.fluent.view.appcompat.imageView
import com.fluent.view.appcompat.textView
import com.fluent.view.constraint.chainPacked
import com.fluent.view.constraint.constraintParams
import com.fluent.view.constraint.parentId
import com.fluent.view.createRefs
import com.fluent.view.material.materialButton
import com.fluent.view.ui.backgroundResource
import com.fluent.view.ui.imageResource
import com.fluent.view.ui.textColorResource
import com.fluent.view.ui.textResource
import com.fluent.view.ui.unit.dp
import com.fluent.view.view
import com.fluent.view.wrapContent
import com.weiwei.fluentlayout.R

/**
 * @author weiwei
 * @date 2021.04.23
 */
class MoreToolKtView : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    initView()
  }

  private fun initView() {
    backgroundResource = R.color.white_primary

    val (icon, title, subtitle, action) = createRefs()

    imageView(icon) {
      layoutParams = constraintParams(44.dp, 44.dp) {
        leftMargin = 32.dp
        leftToLeft = parentId
        topToTop = parentId
        bottomToBottom = parentId
      }
      imageResource = R.drawable.ic_android_24dp
    }

    materialButton(action, R.style.MaterialTheme_MaterialButton) {
      layoutParams = constraintParams(0, 36.dp) {
        rightMargin = 32.dp
        rightToRight = parentId
        topToTop = parentId
        bottomToBottom = parentId
        matchConstraintPercentWidth = 0.2444f
      }
      textSize = 14f
      textColorResource = R.color.white_primary
      textResource = R.string.tool_action_button
    }

    textView(title) {
      layoutParams = constraintParams(0, wrapContent) {
        leftMargin = 14.dp
        rightMargin = 14.dp
        leftToRight = icon
        topToTop = parentId
        rightToLeft = action
        bottomToTop = subtitle
        verticalChainStyle = chainPacked
      }
      textColorResource = R.color.black_87_transparent
      textResource = R.string.tool_title
      textSize = 16f
    }

    textView(subtitle) {
      layoutParams = constraintParams(0, wrapContent) {
        leftMargin = 14.dp
        rightMargin = 14.dp
        topMargin = 4.dp
        leftToRight = icon
        topToBottom = title
        rightToLeft = action
        bottomToBottom = parentId
        verticalChainStyle = chainPacked
      }
      textColorResource = R.color.black_54_transparent
      textResource = R.string.tool_subtitle
      textSize = 12f
    }

    view {
      layoutParams = constraintParams(0, 1.dp) {
        leftMargin = 32.dp
        rightMargin = 32.dp
        leftToLeft = parentId
        rightToRight = parentId
        bottomToBottom = parentId
      }
      backgroundResource = R.color.colorAccent
    }
  }
}