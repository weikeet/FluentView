package com.weicools.kotlinlayout

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
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

    // setContentView(R.layout.activity_static_layout)
    setContentView(buildViewByDsl())

    // setContentView(R.layout.activity_traditional)

    // setContentView(R.layout.activity_constraintlayout)
    // setContentView(buildConstraintLayout())
  }

  private fun buildConstraintLayout(): View =
    ConstraintLayout {
      layout_width = match_parent
      layout_height = match_parent

      ImageView {
        layout_ids = "header"
        layout_width = 0
        layout_height = 0
        margin_bottom = 16.dp()
        scaleType = scale_center_crop
        srcCompat = R.drawable.singapore
        bottom_toBottomOfIds = "favorite"
        top_toTopOfIds = parent_ids
        align_horizontal_toIds = parent_ids
        horizontal_bias = 1.0f
        vertical_bias = 0.0f
      }

      ImageView {
        layout_ids = "favorite"
        layout_width = 36.dp()
        layout_height = 36.dp()
        margin_end = 16.dp()
        margin_bottom = 16.dp()
        background_res = R.drawable.info_background
        padding = 5.dp()
        src = R.drawable.ic_star
        align_vertical_toIds = parent_ids
        end_toEndOfIds = parent_ids
        vertical_bias = 0.19f
      }

      TextView {
        layout_ids = "title"
        layout_width = wrap_content
        layout_height -= wrap_content
        margin_start = 16.dp()
        margin_top = 16.dp()
        text = getString(R.string.singapore)
        textSize = 24f
        start_toStartOfIds = parent_ids
        top_toBottomOfIds = "header"
      }

      EditText {
        layout_ids = "cameraType"
        layout_width = 0
        layout_height = wrap_content
        margin_top = 8.dp()
        inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
        textEms = 10
        textRes = R.string.camera_value
        align_horizontal_toIds = "settings"
        top_toBottomOfIds = "title"
      }

      TextView {
        layout_ids = "cameraLabel"
        layout_width = wrap_content
        layout_height = wrap_content
        margin_start = 16.dp()
        labelForIds = "cameraType"
        textRes = R.string.camera
        baseline_toBaselineOfIds = "cameraType"
        start_toStartOfIds = parent_ids
      }

      TextView {
        layout_ids = "settingLabel"
        layout_width = wrap_content
        layout_height = wrap_content
        margin_start = 16.dp()
        labelForIds = "settings"
        textRes = R.string.settings
        baseline_toBaselineOfIds = "settings"
        start_toStartOfIds = parent_ids
      }

      EditText {
        layout_ids = "settings"
        layout_width = 0
        layout_height = wrap_content
        margin_start = 6.dp()
        margin_top = 8.dp()
        textEms = 10
        inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
        textRes = R.string.camera_settings
        start_toEndOfIds = "settingsLabel"
        end_toEndOfIds = "description"
        top_toBottomOfIds = "cameraType"
      }

      Button {
        layout_ids = "upload"
        layout_width = wrap_content
        layout_height = wrap_content
        margin_end = 16.dp()
        margin_bottom = 16.dp()
        textRes = R.string.upload
        bottom_toBottomOfIds = parent_ids
        end_toEndOfIds = parent_ids
      }

      Button {
        layout_ids = "discard"
        layout_width = wrap_content
        layout_height = wrap_content
        margin_end = 8.dp()
        elevation = 0f
        textRes = R.string.discard
        baseline_toBaselineOfIds = "upload"
        end_toStartOfIds = "upload"
      }

      TextView {
        layout_ids = "description"
        layout_width = 0
        layout_height = 0
        margin_start = 16.dp()
        margin_top = 8.dp()
        margin_end = 16.dp()
        margin_bottom = 8.dp()
        ellipsize = TextUtils.TruncateAt.END
        isVerticalFadingEdgeEnabled = true
        textRes = R.string.singapore_description
        textSize = 15f
        bottom_toTopOfIds = "discard"
        top_toBottomOfIds = "settings"
        align_horizontal_toIds = parent_ids
      }
    }

  @SuppressLint("SetTextI18n")
  private fun buildViewByDsl(): View =
    ConstraintLayout {
      layout_width = match_parent
      layout_height = match_parent

      val ivBackId = 1
      val vDividerId = 2
      val ivDiamondId = 3
      val tvTimeId = 4
      val tvCancelId = 5
      val tvOkId = 6
      val tvContentId = 7
      val ivAvatarId = 8
      val tvSubId = 9
      val tvTitleId = 10
      val layerId = 11

      ImageView {
        id = ivBackId
        layout_width = 40.dp()
        layout_height = 40.dp()
        margin_start = 20.dp()
        margin_top = 20.dp()
        src = R.drawable.ic_back_black
        start_toStartOfIds = parent_ids
        top_toTopOfIds = parent_ids
        onClick = { finish() }
      }

      TextView {
        layout_width = wrap_content
        layout_height = wrap_content
        text = "commit"
        textSize = 30f
        textStyle = bold
        align_vertical_toId = ivBackId
        constraint_centerHorizontal = true
      }

      ImageView {
        layout_width = 40.dp()
        layout_height = 40.dp()
        src = R.drawable.ic_member_more
        align_vertical_toId = ivBackId
        end_toEndOfIds = parent_ids
        margin_end = 20.dp()
      }

      View {
        id = vDividerId
        layout_width = match_parent
        layout_height = 1
        margin_top = 10.dp()
        background_color = "#eeeeee"
        top_toBottomOfId = ivBackId
      }

      Layer {
        id = layerId
        layout_width = wrap_content
        layout_height = wrap_content
        referencedIds = intArrayOf(ivDiamondId, tvTitleId, tvContentId, ivAvatarId, tvTimeId, tvSubId)
        background_res = R.drawable.tag_checked_shape
        start_toStartOfId = ivDiamondId
        top_toTopOfId = ivDiamondId
        bottom_toBottomOfId = tvTimeId
        end_toEndOfId = tvTimeId
      }

      ImageView {
        id = ivDiamondId
        layout_width = 40.dp()
        layout_height = 40.dp()
        margin_start = 20.dp()
        margin_top = 40.dp()
        src = R.drawable.diamond_tag
        start_toStartOfId = ivBackId
        top_toBottomOfId = vDividerId
      }

      TextView {
        id = tvTitleId
        layout_width = wrap_content
        layout_height = wrap_content
        margin_start = 5.dp()
        gravity = gravity_center
        text = "gole"
        padding = 10.dp()
        textColor = "#389793"
        textSize = 20f
        textStyle = bold
        align_vertical_toId = ivDiamondId
        start_toEndOfId = ivDiamondId
      }

      TextView {
        id = tvContentId
        layout_width = 0
        layout_height = wrap_content
        margin_top = 5.dp()
        text = "The changes were merged into release with so many bugs"
        textSize = 23f
        start_toStartOfId = ivDiamondId
        top_toBottomOfId = ivDiamondId
        end_toStartOfId = ivAvatarId
      }

      ImageView {
        id = ivAvatarId
        layout_width = 100.dp()
        layout_height = 100.dp()
        margin_end = 20.dp()
        src = R.drawable.user_portrait_gender_female
        end_toEndOfIds = parent_ids
        start_toEndOfId = tvContentId
        top_toTopOfId = tvContentId
      }

      TextView {
        id = tvSubId
        layout_width = wrap_content
        layout_height = wrap_content
        text = "merge it with mercy"
        textColor = "#c4747E8B"
        textSize = 18f
        start_toStartOfId = ivDiamondId
        top_toBottomOfId = tvContentId
      }

      TextView {
        id = tvTimeId
        layout_width = wrap_content
        layout_height = wrap_content
        margin_top = 20.dp()
        text = "2020.04.30"
        end_toEndOfId = ivAvatarId
        top_toBottomOfId = ivAvatarId
      }

      TextView {
        id = tvCancelId
        layout_width = wrap_content
        layout_height = wrap_content
        margin_end = 30.dp()
        background_res = R.drawable.bg_orange_btn
        padding_start = 30.dp()
        padding_top = 10.dp()
        padding_end = 30.dp()
        padding_bottom = 10.dp()
        text = "cancel"
        margin_bottom = 20.dp()
        textSize = 20f
        textStyle = bold
        bottom_toBottomOfIds = parent_ids
        end_toStartOfId = tvOkId
        start_toStartOfIds = parent_ids
        horizontal_chain_style = packed
      }

      TextView {
        id = tvOkId
        layout_width = wrap_content
        layout_height = wrap_content
        background_res = R.drawable.bg_orange_btn
        padding_start = 30.dp()
        padding_top = 10.dp()
        margin_bottom = 20.dp()
        padding_end = 30.dp()
        padding_bottom = 10.dp()
        text = "Ok"
        textSize = 20f
        textStyle = bold
        bottom_toBottomOfIds = parent_ids
        end_toEndOfIds = parent_ids
        horizontal_chain_style = packed
        start_toEndOfId = tvCancelId
      }
    }
}
