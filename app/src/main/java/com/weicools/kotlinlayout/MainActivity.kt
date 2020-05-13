package com.weicools.kotlinlayout

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.LayoutInflaterCompat
import com.weicools.kotlinlayout.dsl.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

/**
 * 1s = 1000ms
 * 1ms = 1000us
 * 1us = 1000ns
 * 1ns = 1000ps
 */
class MainActivity : AppCompatActivity() {
  companion object {
    private const val TEST_TAG = "TEST_TAG"
  }

  @ExperimentalTime
  override fun onCreate(savedInstanceState: Bundle?) {
    LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), object : LayoutInflater.Factory2 {
      private var sum: Double = 0.0
      override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {
        //测量构建单个View耗时
        val (view, duration) = measureTimedValue { delegate.createView(parent, name, context, attrs) }
        //累加构建视图耗时
        sum += duration.inMilliseconds
        Log.d(TEST_TAG, "view=${view?.let { it::class.simpleName }} duration=${duration}  sum=${sum}")
        return view
      }

      override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return null
      }
    })
    super.onCreate(savedInstanceState)
    // setContentView(R.layout.activity_main)
    setContentView(R.layout.activity_traditional)
    // setContentView(R.layout.activity_constraintlayout)
    // setContentView(R.layout.activity_static_layout)
    // setContentView(buildViewByDsl())
  }

  @SuppressLint("SetTextI18n")
  private fun buildViewByDsl(): View =
    ConstraintLayout {
      layout_width = match_parent
      layout_height = match_parent

      ImageView {
        layout_id = "ivBack"
        layout_width = 40
        layout_height = 40
        margin_start = 20
        margin_top = 20
        src = R.drawable.ic_back_black
        start_toStartOf = parent_id
        top_toTopOf = parent_id
        onClick = { finish() }
      }

      TextView {
        layout_width = wrap_content
        layout_height = wrap_content
        text = "commit"
        textSize = 30f
        textStyle = bold
        align_vertical_to = "ivBack"
        center_horizontal = true
      }

      ImageView {
        layout_width = 40
        layout_height = 40
        src = R.drawable.ic_member_more
        align_vertical_to = "ivBack"
        end_toEndOf = parent_id
        margin_end = 20
      }

      View {
        layout_id = "vDivider"
        layout_width = match_parent
        layout_height = 1
        margin_top = 10
        background_color = "#eeeeee"
        top_toBottomOf = "ivBack"
      }

      Layer {
        layout_id = "layer"
        layout_width = wrap_content
        layout_height = wrap_content
        referenceIds = "ivDiamond,tvTitle,tvContent,ivAvatar,tvTime,tvSub"
        background_res = R.drawable.tag_checked_shape
        start_toStartOf = "ivDiamond"
        top_toTopOf = "ivDiamond"
        bottom_toBottomOf = "tvTime"
        end_toEndOf = "tvTime"
      }

      ImageView {
        layout_id = "ivDiamond"
        layout_width = 40
        layout_height = 40
        margin_start = 20
        margin_top = 40
        src = R.drawable.diamond_tag
        start_toStartOf = "ivBack"
        top_toBottomOf = "vDivider"
      }

      TextView {
        layout_id = "tvTitle"
        layout_width = wrap_content
        layout_height = wrap_content
        margin_start = 5
        exGravity = gravity_center
        text = "gole"
        padding = 10
        textColor = "#389793"
        textSize = 20f
        textStyle = bold
        align_vertical_to = "ivDiamond"
        start_toEndOf = "ivDiamond"
      }

      TextView {
        layout_id = "tvContent"
        layout_width = 0
        layout_height = wrap_content
        margin_top = 5
        text = "The changes were merged into release with so many bugs"
        textSize = 23f
        start_toStartOf = "ivDiamond"
        top_toBottomOf = "ivDiamond"
        end_toStartOf = "ivAvatar"
      }

      ImageView {
        layout_id = "ivAvatar"
        layout_width = 100
        layout_height = 100
        margin_end = 20
        src = R.drawable.user_portrait_gender_female
        end_toEndOf = parent_id
        start_toEndOf = "tvContent"
        top_toTopOf = "tvContent"
      }

      TextView {
        layout_id = "tvSub"
        layout_width = wrap_content
        layout_height = wrap_content
        text = "merge it with mercy"
        textColor = "#c4747E8B"
        textSize = 18f
        start_toStartOf = "ivDiamond"
        top_toBottomOf = "tvContent"
      }

      TextView {
        layout_id = "tvTime"
        layout_width = wrap_content
        layout_height = wrap_content
        margin_top = 20
        text = "2020.04.30"
        end_toEndOf = "ivAvatar"
        top_toBottomOf = "ivAvatar"
      }

      TextView {
        layout_id = "tvCancel"
        layout_width = wrap_content
        layout_height = wrap_content
        margin_end = 30
        background_res = R.drawable.bg_orange_btn
        padding_start = 30
        padding_top = 10
        padding_end = 30
        padding_bottom = 10
        text = "cancel"
        margin_bottom = 20
        textSize = 20f
        textStyle = bold
        bottom_toBottomOf = parent_id
        end_toStartOf = "tvOk"
        start_toStartOf = parent_id
        horizontal_chain_style = packed
      }

      TextView {
        layout_id = "tvOk"
        layout_width = wrap_content
        layout_height = wrap_content
        background_res = R.drawable.bg_orange_btn
        padding_start = 30
        padding_top = 10
        margin_bottom = 20
        padding_end = 30
        padding_bottom = 10
        text = "Ok"
        textSize = 20f
        textStyle = bold
        bottom_toBottomOf = parent_id
        end_toEndOf = parent_id
        horizontal_chain_style = packed
        start_toEndOf = "tvCancel"
      }
    }
}
