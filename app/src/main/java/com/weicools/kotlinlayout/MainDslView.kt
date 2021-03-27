package com.weicools.kotlinlayout

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.dsl.*

@SuppressLint("SetTextI18n")
class MainDslView : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    ImageView {
      id = R.id.ivBack
      Layout_width = 40.dp
      Layout_height = 40.dp
      MarginStart = 20.dp
      MarginTop = 20.dp
      Src = R.drawable.ic_back_black
      StartToStart = parentId
      TopToTop = parentId
      setOnClickListener {
        //finish()
      }
    }

    TextView {
      Layout_width = wrapContent
      Layout_height = wrapContent
      textSizeDp = 30f
      textStyle = Typeface.BOLD
      AlignVerticalOf = R.id.ivBack
      AlignHorizontalOf = parentId
      text = "commit"
    }

    ImageView {
      Layout_width = 40.dp
      Layout_height = 40.dp
      MarginEnd = 20.dp
      Src = R.drawable.ic_member_more
      AlignVerticalOf = R.id.ivBack
      EndToEnd = parentId
    }

    View {
      id = R.id.vDivider
      Layout_width = matchParent
      Layout_height = 1
      MarginTop = 10.dp
      BackgroundColorString = "#eeeeee"
      TopToBottom = R.id.ivBack
    }

    View {
      id = R.id.layer
      Layout_width = 0
      Layout_height = 0
      Background = R.drawable.tag_checked_shape
      BottomToBottom = R.id.tvTime
      EndToEnd = R.id.ivAvatar
      StartToStart = R.id.ivDiamond
      TopToTop = R.id.ivDiamond
    }

    ImageView {
      id = R.id.ivDiamond
      Layout_width = 40.dp
      Layout_height = 40.dp
      MarginStart = 20.dp
      MarginTop = 40.dp
      Src = R.drawable.diamond_tag
      StartToStart = R.id.ivBack
      TopToBottom = R.id.vDivider
    }

    TextView {
      id = R.id.tvTitle
      Layout_width = wrapContent
      Layout_height = wrapContent
      MarginStart = 5.dp
      Padding = 10.dp
      textColorString = "#389793"
      textSizeDp = 20f
      textStyle = Typeface.BOLD
      AlignVerticalOf = R.id.ivDiamond
      StartToEnd = R.id.ivDiamond
      gravity = Gravity.CENTER
      text = "gold"
    }

    TextView {
      id = R.id.tvContent
      Layout_width = 0
      Layout_height = wrapContent
      MarginTop = 5.dp
      textSizeDp = 23f
      EndToStart = R.id.ivAvatar
      StartToStart = R.id.ivDiamond
      TopToBottom = R.id.ivDiamond
      text = "The changes were merged into release with so many bugs"
    }

    ImageView {
      id = R.id.ivAvatar
      Layout_width = 100.dp
      Layout_height = 100.dp
      MarginEnd = 20.dp
      Src = R.drawable.user_portrait_gender_female
      EndToEnd = parentId
      StartToEnd = R.id.tvContent
      TopToTop = R.id.tvContent
    }

    TextView {
      id = R.id.tvSub
      Layout_width = wrapContent
      Layout_height = wrapContent
      textColorString = "#c4747E8B"
      textSizeDp = 18f
      StartToStart = R.id.ivDiamond
      TopToBottom = R.id.tvContent
      text = "merge it with mercy"
    }

    TextView {
      id = R.id.tvTime
      Layout_width = wrapContent
      Layout_height = wrapContent
      MarginTop = 20.dp
      EndToEnd = R.id.ivAvatar
      TopToBottom = R.id.ivAvatar
      text = "2020.04.30"
    }

    TextView {
      id = R.id.tvCancel
      Layout_width = wrapContent
      Layout_height = wrapContent
      MarginEnd = 30.dp
      Background = R.drawable.bg_orange_btn
      PaddingLeft = 30.dp
      PaddingTop = 10.dp
      PaddingRight = 30.dp
      PaddingBottom = 10.dp
      MarginBottom = 20.dp
      textSizeDp = 20f
      textStyle = Gravity.CENTER
      BottomToBottom = parentId
      EndToStart = R.id.tvOk
      StartToStart = parentId
      HorizontalChainStyle = chainPacked
      text = "cancel"
    }

    TextView {
      id = R.id.tvOk
      Layout_width = wrapContent
      Layout_height = wrapContent
      Background = R.drawable.bg_orange_btn
      PaddingLeft = 30.dp
      PaddingTop = 10.dp
      MarginBottom = 20.dp
      PaddingRight = 30.dp
      PaddingBottom = 10.dp
      textSizeDp = 20f
      textStyle = Typeface.BOLD
      BottomToBottom = parentId
      EndToEnd = parentId
      HorizontalChainStyle = chainPacked
      StartToEnd = R.id.tvCancel
      text = "Ok"
    }
  }
}