package com.weicools.fluentlayout

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.fluentlayout.widget.dsl.imageView
import com.weicools.fluentlayout.widget.dsl.textView
import com.weicools.fluentlayout.widget.dsl.view
import com.weicools.fluentlayout.widget.extensions.background_colorString
import com.weicools.fluentlayout.widget.extensions.background_resource
import com.weicools.fluentlayout.widget.extensions.bottom_toBottomOf
import com.weicools.fluentlayout.widget.extensions.center_horizontalOf
import com.weicools.fluentlayout.widget.extensions.center_verticalOf
import com.weicools.fluentlayout.widget.extensions.dp
import com.weicools.fluentlayout.widget.extensions.end_toEndOf
import com.weicools.fluentlayout.widget.extensions.end_toStartOf
import com.weicools.fluentlayout.widget.extensions.gravity_center
import com.weicools.fluentlayout.widget.extensions.horizontal_chainStyle
import com.weicools.fluentlayout.widget.extensions.image_resource
import com.weicools.fluentlayout.widget.extensions.layout_height
import com.weicools.fluentlayout.widget.extensions.layout_width
import com.weicools.fluentlayout.widget.extensions.margin_bottom
import com.weicools.fluentlayout.widget.extensions.margin_end
import com.weicools.fluentlayout.widget.extensions.margin_start
import com.weicools.fluentlayout.widget.extensions.margin_top
import com.weicools.fluentlayout.widget.extensions.padding_bottom
import com.weicools.fluentlayout.widget.extensions.padding_left
import com.weicools.fluentlayout.widget.extensions.padding_right
import com.weicools.fluentlayout.widget.extensions.padding_top
import com.weicools.fluentlayout.widget.extensions.paddings
import com.weicools.fluentlayout.widget.extensions.start_toEndOf
import com.weicools.fluentlayout.widget.extensions.start_toStartOf
import com.weicools.fluentlayout.widget.extensions.text_colorString
import com.weicools.fluentlayout.widget.extensions.text_sizeDp
import com.weicools.fluentlayout.widget.extensions.text_style
import com.weicools.fluentlayout.widget.extensions.top_toBottomOf
import com.weicools.fluentlayout.widget.extensions.top_toTopOf
import com.weicools.fluentlayout.widget.ids.createRefs
import com.weicools.fluentlayout.widget.params.chainPacked
import com.weicools.fluentlayout.widget.params.matchParent
import com.weicools.fluentlayout.widget.params.parentId
import com.weicools.fluentlayout.widget.params.wrapContent

class MainDslView : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    createView()
  }

  @SuppressLint("SetTextI18n")
  private fun createView() {
    val (ivBack, vDivider, layer, ivDiamond, tvTitle, tvContent,
      ivAvatar, tvSub, tvTime, tvCancel, tvOk
    ) = createRefs()

    imageView(ivBack) {
      layout_width = 40.dp
      layout_height = 40.dp
      margin_start = 20.dp
      margin_top = 20.dp
      start_toStartOf = parentId
      top_toTopOf = parentId
      image_resource = R.drawable.ic_back_black
      setOnClickListener {
        Toast.makeText(context, "Click back!", Toast.LENGTH_SHORT).show()
      }
    }

    textView {
      layout_width = wrapContent
      layout_height = wrapContent
      center_verticalOf = ivBack
      center_horizontalOf = parentId
      text_sizeDp = 30f
      text_style = Typeface.BOLD
      text = "commit"
    }

    imageView {
      layout_width = 40.dp
      layout_height = 40.dp
      margin_end = 20.dp
      center_verticalOf = ivBack
      end_toEndOf = parentId
      image_resource = R.drawable.ic_member_more
    }

    view(vDivider) {
      layout_width = matchParent
      layout_height = 1
      margin_top = 10.dp
      top_toBottomOf = ivBack
      background_colorString = "#eeeeee"
    }

    view(layer) {
      layout_width = 0
      layout_height = 0
      margin_start = 16.dp
      margin_end = 16.dp
      bottom_toBottomOf = tvTime
      end_toEndOf = parentId
      start_toStartOf = parentId
      top_toTopOf = ivDiamond
      background_resource = R.drawable.tag_checked_shape
    }

    imageView(ivDiamond) {
      layout_width = 40.dp
      layout_height = 40.dp
      margin_start = 20.dp
      margin_top = 40.dp
      start_toStartOf = ivBack
      top_toBottomOf = vDivider
      image_resource = R.drawable.diamond_tag
    }

    textView(tvTitle) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_start = 5.dp
      center_verticalOf = ivDiamond
      start_toEndOf = ivDiamond
      gravity = gravity_center
      paddings = 10.dp
      text_colorString = "#389793"
      text_sizeDp = 20f
      text_style = Typeface.BOLD
      text = "gold"
    }

    textView(tvContent) {
      layout_width = 0
      layout_height = wrapContent
      end_toStartOf = ivAvatar
      start_toStartOf = ivDiamond
      top_toBottomOf = ivDiamond
      margin_top = 5.dp
      text_sizeDp = 23f
      text = "The changes were merged into release with so many bugs"
    }

    imageView(ivAvatar) {
      layout_width = 100.dp
      layout_height = 100.dp
      margin_end = 20.dp
      end_toEndOf = parentId
      start_toEndOf = tvContent
      top_toTopOf = tvContent
      image_resource = R.drawable.user_portrait_gender_female
    }

    textView(tvSub) {
      layout_width = wrapContent
      layout_height = wrapContent
      start_toStartOf = ivDiamond
      top_toBottomOf = tvContent
      text_colorString = "#c4747E8B"
      text_sizeDp = 18f
      text = "merge it with mercy"
    }

    textView(tvTime) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_top = 20.dp
      margin_end = 16.dp
      end_toEndOf = ivAvatar
      top_toBottomOf = ivAvatar
      text = "2020.04.30"
    }

    textView(tvCancel) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_end = 30.dp
      margin_bottom = 20.dp
      end_toStartOf = tvOk
      start_toStartOf = parentId
      bottom_toBottomOf = parentId
      horizontal_chainStyle = chainPacked
      background_resource = R.drawable.bg_orange_btn
      padding_left = 30.dp
      padding_top = 10.dp
      padding_right = 30.dp
      padding_bottom = 10.dp
      text_sizeDp = 20f
      text_style = gravity_center
      text = "cancel"
    }

    textView(tvOk) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_bottom = 20.dp
      end_toEndOf = parentId
      bottom_toBottomOf = parentId
      horizontal_chainStyle = chainPacked
      background_resource = R.drawable.bg_orange_btn
      padding_left = 30.dp
      padding_top = 10.dp
      padding_right = 30.dp
      padding_bottom = 10.dp
      textSize = 20f
      text_style = Typeface.BOLD
      start_toEndOf = tvCancel
      text = "Ok"
    }
  }
}