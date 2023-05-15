package com.weiwei.fluentlayout

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weiwei.fluentview.ui.imageResource
import com.weiwei.fluentview.ui.unit.dp
import com.weiwei.fluentview.view.appcompat.imageView
import com.weiwei.fluentview.view.appcompat.textView
import com.weiwei.fluentview.view.constraint.centerVerticalOf
import com.weiwei.fluentview.view.constraint.constraintLayout
import com.weiwei.fluentview.view.constraint.constraintParams
import com.weiwei.fluentview.view.constraint.parentId
import com.weiwei.fluentview.view.defaultParams
import com.weiwei.fluentview.view.matchParent
import com.weiwei.fluentview.view.wrapContent

/**
 * @author weiwei
 * @date 2021.09.19
 */
class FluentLayout @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

  val rootView = constraintLayout {
    layoutParams = defaultParams(matchParent, 64.dp)

    imageView(R.id.iconId) {
      layoutParams = constraintParams(40.dp, 40.dp) {
        leftToLeft = parentId
        centerVerticalOf = parentId
        leftMargin = 16.dp
      }
      imageResource = R.mipmap.ic_launcher
    }

    textView(R.id.textId) {
      layoutParams = constraintParams(0, wrapContent) {
        leftToRight = R.id.iconId
        rightToRight = parentId
        centerVerticalOf = parentId
        leftMargin = 8.dp
        rightMargin = 16.dp
      }
      text = "layout title"
    }
  }
}