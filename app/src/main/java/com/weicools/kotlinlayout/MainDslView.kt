package com.weicools.kotlinlayout

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.widget.background_colorString
import com.weicools.kotlinlayout.widget.background_resource
import com.weicools.kotlinlayout.widget.bottom_toBottomOf
import com.weicools.kotlinlayout.widget.center_horizontalOf
import com.weicools.kotlinlayout.widget.center_verticalOf
import com.weicools.kotlinlayout.widget.chainPacked
import com.weicools.kotlinlayout.widget.createRefs
import com.weicools.kotlinlayout.widget.dp
import com.weicools.kotlinlayout.widget.end_toEndOf
import com.weicools.kotlinlayout.widget.end_toStartOf
import com.weicools.kotlinlayout.widget.gravity_center
import com.weicools.kotlinlayout.widget.horizontal_chainStyle
import com.weicools.kotlinlayout.widget.imageView
import com.weicools.kotlinlayout.widget.image_resource
import com.weicools.kotlinlayout.widget.layout_height
import com.weicools.kotlinlayout.widget.layout_width
import com.weicools.kotlinlayout.widget.margin_Bottom
import com.weicools.kotlinlayout.widget.margin_End
import com.weicools.kotlinlayout.widget.margin_Start
import com.weicools.kotlinlayout.widget.margin_Top
import com.weicools.kotlinlayout.widget.matchParent
import com.weicools.kotlinlayout.widget.padding_bottom
import com.weicools.kotlinlayout.widget.padding_left
import com.weicools.kotlinlayout.widget.padding_right
import com.weicools.kotlinlayout.widget.padding_top
import com.weicools.kotlinlayout.widget.paddings
import com.weicools.kotlinlayout.widget.parentId
import com.weicools.kotlinlayout.widget.start_toEndOf
import com.weicools.kotlinlayout.widget.start_toStartOf
import com.weicools.kotlinlayout.widget.textView
import com.weicools.kotlinlayout.widget.text_colorString
import com.weicools.kotlinlayout.widget.text_sizeDp
import com.weicools.kotlinlayout.widget.text_style
import com.weicools.kotlinlayout.widget.top_toBottomOf
import com.weicools.kotlinlayout.widget.top_toTopOf
import com.weicools.kotlinlayout.widget.view
import com.weicools.kotlinlayout.widget.wrapContent

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
      margin_Start = 20.dp
      margin_Top = 20.dp
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
      margin_End = 20.dp
      center_verticalOf = ivBack
      end_toEndOf = parentId
      image_resource = R.drawable.ic_member_more
    }

    view(vDivider) {
      layout_width = matchParent
      layout_height = 1
      margin_Top = 10.dp
      top_toBottomOf = ivBack
      background_colorString = "#eeeeee"
    }

    view(layer) {
      layout_width = 0
      layout_height = 0
      margin_Start = 16.dp
      margin_End = 16.dp
      bottom_toBottomOf = tvTime
      end_toEndOf = parentId
      start_toStartOf = parentId
      top_toTopOf = ivDiamond
      background_resource = R.drawable.tag_checked_shape
    }

    imageView(ivDiamond) {
      layout_width = 40.dp
      layout_height = 40.dp
      margin_Start = 20.dp
      margin_Top = 40.dp
      start_toStartOf = ivBack
      top_toBottomOf = vDivider
      image_resource = R.drawable.diamond_tag
    }

    textView(tvTitle) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_Start = 5.dp
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
      margin_Top = 5.dp
      text_sizeDp = 23f
      text = "The changes were merged into release with so many bugs"
    }

    imageView(ivAvatar) {
      layout_width = 100.dp
      layout_height = 100.dp
      margin_End = 20.dp
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
      margin_Top = 20.dp
      margin_End = 16.dp
      end_toEndOf = ivAvatar
      top_toBottomOf = ivAvatar
      text = "2020.04.30"
    }

    textView(tvCancel) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_End = 30.dp
      margin_Bottom = 20.dp
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
      margin_Bottom = 20.dp
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