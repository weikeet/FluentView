package com.weiwei.fluentlayout

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weiwei.fluent.widget.constraintLayout
import com.weiwei.fluent.widget.imageView
import com.weiwei.fluent.widget.textView
import com.weiwei.fluent.widget.extensions.dp
import com.weiwei.fluent.widget.extensions.image_resource
import com.weiwei.fluent.widget.params.center_VerticalOf
import com.weiwei.fluent.widget.params.constraintParams
import com.weiwei.fluent.widget.params.defaultParams
import com.weiwei.fluent.widget.params.matchParent
import com.weiwei.fluent.widget.params.parentId
import com.weiwei.fluent.widget.params.wrapContent

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
      center_VerticalOf = parentId
      leftMargin = 16.dp
    }
    image_resource = R.mipmap.ic_launcher
  }

  textView(R.id.textId) {
    layoutParams = constraintParams(0, wrapContent) {
      leftToRight = R.id.iconId
      rightToRight = parentId
      center_VerticalOf = parentId
      leftMargin = 8.dp
      rightMargin = 16.dp
    }
    text = "layout title"
  }
}
}