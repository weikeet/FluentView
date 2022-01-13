package com.weicools.fluentlayout

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.fluent.widget.constraintLayout
import com.weicools.fluent.widget.imageView
import com.weicools.fluent.widget.textView
import com.weicools.fluent.widget.extensions.dp
import com.weicools.fluent.widget.extensions.image_resource
import com.weicools.fluent.widget.params.center_VerticalOf
import com.weicools.fluent.widget.params.constraintParams
import com.weicools.fluent.widget.params.defaultParams
import com.weicools.fluent.widget.params.matchParent
import com.weicools.fluent.widget.params.parentId
import com.weicools.fluent.widget.params.wrapContent

/**
 * @author weicools
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