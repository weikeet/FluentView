package com.weicools.kotlinlayout

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.dsl.*

class MainDslView @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
  init {
    ImageView {
      id = R.id.ivBack
      ds_layout_width = 40.dp
      ds_layout_height = 40.dp
      ds_marginStart = 20.dp
      ds_marginTop = 20.dp
      ds_imageSrc = R.drawable.ic_back_black
      ds_constraintStart_toStartOf = parent_id
      ds_constraintTop_toTopOf = parent_id
      setOnClickListener {
        //finish()
      }
    }

    TextView {
      ds_layout_width = wrap_content
      ds_layout_height = wrap_content
      ds_textSizeDp = 30f
      ds_textStyle = Typeface.BOLD
      ds_constraintVertical_alignOf = R.id.ivBack
      ds_constraintHorizontal_alignOf = parent_id
      text = "commit"
    }

    ImageView {
      ds_layout_width = 40.dp
      ds_layout_height = 40.dp
      ds_marginEnd = 20.dp
      ds_imageSrc = R.drawable.ic_member_more
      ds_constraintVertical_alignOf = R.id.ivBack
      ds_constraintEnd_toEndOf = parent_id
    }

    View {
      id = R.id.vDivider
      ds_layout_width = match_parent
      ds_layout_height = 1
      ds_marginTop = 10.dp
      ds_backgroundColor = "#eeeeee"
      ds_constraintTop_toBottomOf = R.id.ivBack
    }

    View {
      id = R.id.layer
      ds_layout_width = 0
      ds_layout_height = 0
      ds_backgroundRes = R.drawable.tag_checked_shape
      ds_constraintBottom_toBottomOf = R.id.tvTime
      ds_constraintEnd_toEndOf = R.id.ivAvatar
      ds_constraintStart_toStartOf = R.id.ivDiamond
      ds_constraintTop_toTopOf = R.id.ivDiamond
    }

    ImageView {
      id = R.id.ivDiamond
      ds_layout_width = 40.dp
      ds_layout_height = 40.dp
      ds_marginStart = 20.dp
      ds_marginTop = 40.dp
      ds_imageSrc = R.drawable.diamond_tag
      ds_constraintStart_toStartOf = R.id.ivBack
      ds_constraintTop_toBottomOf = R.id.vDivider
    }

    TextView {
      id = R.id.tvTitle
      ds_layout_width = wrap_content
      ds_layout_height = wrap_content
      ds_marginStart = 5.dp
      ds_padding = 10.dp
      ds_textColor = "#389793"
      ds_textSizeDp = 20f
      ds_textStyle = Typeface.BOLD
      ds_constraintVertical_alignOf = R.id.ivDiamond
      ds_constraintStart_toEndOf = R.id.ivDiamond
      gravity = Gravity.CENTER
      text = "gold"
    }

    TextView {
      id = R.id.tvContent
      ds_layout_width = 0
      ds_layout_height = wrap_content
      ds_marginTop = 5.dp
      ds_textSizeDp = 23f
      ds_constraintEnd_toStartOf = R.id.ivAvatar
      ds_constraintStart_toStartOf = R.id.ivDiamond
      ds_constraintTop_toBottomOf = R.id.ivDiamond
      text = "The changes were merged into release with so many bugs"
    }

    ImageView {
      id = R.id.ivAvatar
      ds_layout_width = 100.dp
      ds_layout_height = 100.dp
      ds_marginEnd = 20.dp
      ds_imageSrc = R.drawable.user_portrait_gender_female
      ds_constraintEnd_toEndOf = parent_id
      ds_constraintStart_toEndOf = R.id.tvContent
      ds_constraintTop_toTopOf = R.id.tvContent
    }

    TextView {
      id = R.id.tvSub
      ds_layout_width = wrap_content
      ds_layout_height = wrap_content
      ds_textColor = "#c4747E8B"
      ds_textSizeDp = 18f
      ds_constraintStart_toStartOf = R.id.ivDiamond
      ds_constraintTop_toBottomOf = R.id.tvContent
      text = "merge it with mercy"
    }

    TextView {
      id = R.id.tvTime
      ds_layout_width = wrap_content
      ds_layout_height = wrap_content
      ds_marginTop = 20.dp
      ds_constraintEnd_toEndOf = R.id.ivAvatar
      ds_constraintTop_toBottomOf = R.id.ivAvatar
      text = "2020.04.30"
    }

    TextView {
      id = R.id.tvCancel
      ds_layout_width = wrap_content
      ds_layout_height = wrap_content
      ds_marginEnd = 30.dp
      ds_backgroundRes = R.drawable.bg_orange_btn
      ds_paddingStart = 30.dp
      ds_paddingTop = 10.dp
      ds_paddingEnd = 30.dp
      ds_paddingBottom = 10.dp
      ds_marginBottom = 20.dp
      ds_textSizeDp = 20f
      ds_textStyle = Gravity.CENTER
      ds_constraintBottom_toBottomOf = parent_id
      ds_constraintEnd_toStartOf = R.id.tvOk
      ds_constraintStart_toStartOf = parent_id
      ds_constraintHorizontal_chainStyle = chain_packed
      text = "cancel"
    }

    TextView {
      id = R.id.tvOk
      ds_layout_width = wrap_content
      ds_layout_height = wrap_content
      ds_backgroundRes = R.drawable.bg_orange_btn
      ds_paddingStart = 30.dp
      ds_paddingTop = 10.dp
      ds_marginBottom = 20.dp
      ds_paddingEnd = 30.dp
      ds_paddingBottom = 10.dp
      ds_textSizeDp = 20f
      ds_textStyle = Typeface.BOLD
      ds_constraintBottom_toBottomOf = parent_id
      ds_constraintEnd_toEndOf = parent_id
      ds_constraintHorizontal_chainStyle = chain_packed
      ds_constraintStart_toEndOf = R.id.tvCancel
      text = "Ok"
    }
  }
}