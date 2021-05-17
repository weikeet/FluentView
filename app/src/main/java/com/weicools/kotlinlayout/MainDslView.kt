package com.weicools.kotlinlayout

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.widget.*

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
      src_compat = R.drawable.ic_back_black
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
      src_compat = R.drawable.ic_member_more
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
      background_res = R.drawable.tag_checked_shape
    }

    imageView(ivDiamond) {
      layout_width = 40.dp
      layout_height = 40.dp
      margin_Start = 20.dp
      margin_Top = 40.dp
      start_toStartOf = ivBack
      top_toBottomOf = vDivider
      src_compat = R.drawable.diamond_tag
    }

    textView(tvTitle) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_Start = 5.dp
      center_verticalOf = ivDiamond
      start_toEndOf = ivDiamond
      gravity = Gravity.CENTER
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
      src_compat = R.drawable.user_portrait_gender_female
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
      background_res = R.drawable.bg_orange_btn
      padding_Left = 30.dp
      padding_Top = 10.dp
      padding_Right = 30.dp
      padding_Bottom = 10.dp
      text_sizeDp = 20f
      text_style = Gravity.CENTER
      text = "cancel"
    }

    textView(tvOk) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_Bottom = 20.dp
      end_toEndOf = parentId
      bottom_toBottomOf = parentId
      horizontal_chainStyle = chainPacked
      background_res = R.drawable.bg_orange_btn
      padding_Left = 30.dp
      padding_Top = 10.dp
      padding_Right = 30.dp
      padding_Bottom = 10.dp
      textSize = 20f
      text_style = Typeface.BOLD
      start_toEndOf = tvCancel
      text = "Ok"
    }
  }
}