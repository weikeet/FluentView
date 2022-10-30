package com.weiwei.fluentlayout

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.fluent.view.appcompat.imageView
import com.fluent.view.appcompat.textView
import com.fluent.view.constraint.centerVerticalOf
import com.fluent.view.constraint.constraintLayout
import com.fluent.view.constraint.constraintParams
import com.fluent.view.constraint.parentId
import com.fluent.view.defaultParams
import com.fluent.view.matchParent
import com.fluent.view.ui.imageResource
import com.fluent.view.ui.res.dimenOffsetResource
import com.fluent.view.ui.unit.dp
import com.fluent.view.wrapContent

val a = dimenOffsetResource(R.dimen.fab_margin)

/**
 * @author weiwei
 * @date 2021.09.19
 */
class FluentLayout @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
  val a = dimenOffsetResource(R.dimen.fab_margin)

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