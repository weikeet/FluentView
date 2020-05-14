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
    // setContentView(buildViewByDsl())

    // setContentView(R.layout.activity_traditional_layout)

    // setContentView(R.layout.activity_constraint_layout)
    setContentView(buildConstraintLayout())

    val testView = findView<View>(2)
    Log.d("findViewById", "View = $testView, View = ${testView?.let { it::class.simpleName }}")
    val testView2 = findView<View>(200)
    Log.d("findViewById", "View2 = $testView2, View = ${testView2?.let { it::class.simpleName }}")
  }

  private fun buildConstraintLayout(): View =
    ConstraintLayout {
      ds_layout_width = match_parent
      ds_layout_height = match_parent

      val header = 1
      val cameraType = 2
      val favoriteId = 3
      val cameraLabelId = 4
      val titleId = 5
      val settingLabelId = 6
      val settingsId = 7
      val discardId = 8
      val descriptionId = 9
      val uploadId = 10

      ImageView {
        id = header
        ds_layout_width = 0
        ds_layout_height = 0
        ds_marginBottom = 16.dp()
        ds_imageSrc = R.drawable.singapore
        ds_constraintBottom_toBottomOf = favoriteId
        ds_constraintTop_toTopOf = parent_id
        ds_constraintHorizontal_alignOf = parent_id
        ds_constraintHorizontal_bias = 1.0f
        ds_constraintVertical_bias = 0.0f
        scaleType = scale_center_crop
      }

      ImageView {
        id = favoriteId
        ds_layout_width = 36.dp()
        ds_layout_height = 36.dp()
        ds_marginEnd = 16.dp()
        ds_marginBottom = 16.dp()
        ds_backgroundRes = R.drawable.info_background
        ds_padding = 5.dp()
        ds_imageSrc = R.drawable.ic_star
        ds_constraintVertical_alignOf = parent_id
        ds_constraintEnd_toEndOf = parent_id
        ds_constraintVertical_bias = 0.19f
      }

      TextView {
        id = titleId
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_marginStart = 16.dp()
        ds_marginTop = 16.dp()
        ds_textRes = R.string.singapore
        ds_textSizeDp = 24f
        ds_constraintStart_toStartOf = parent_id
        ds_constraintTop_toBottomOf = header
      }

      EditText {
        id = cameraType
        ds_layout_width = 0
        ds_layout_height = wrap_content
        ds_marginTop = 8.dp()
        ds_textEms = 10
        ds_textRes = R.string.camera_value
        ds_constraintHorizontal_alignOf = settingsId
        ds_constraintTop_toBottomOf = titleId
        inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
      }

      TextView {
        id = cameraLabelId
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_marginStart = 16.dp()
        ds_textRes = R.string.camera
        ds_constraintBaseline_toBaselineOf = cameraType
        ds_constraintStart_toStartOf = parent_id
        labelFor = cameraType
      }

      TextView {
        id = settingLabelId
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_marginStart = 16.dp()
        ds_textRes = R.string.settings
        ds_constraintBaseline_toBaselineOf = settingsId
        ds_constraintStart_toStartOf = parent_id
        labelFor = settingsId
      }

      EditText {
        id = settingsId
        ds_layout_width = 0
        ds_layout_height = wrap_content
        ds_marginStart = 6.dp()
        ds_marginTop = 8.dp()
        ds_textEms = 10
        ds_textRes = R.string.camera_settings
        ds_constraintStart_toEndOf = settingLabelId
        ds_constraintEnd_toEndOf = descriptionId
        ds_constraintTop_toBottomOf = cameraType
        inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
      }

      Button {
        id = uploadId
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_marginEnd = 16.dp()
        ds_marginBottom = 16.dp()
        ds_textRes = R.string.upload
        ds_constraintBottom_toBottomOf = parent_id
        ds_constraintEnd_toEndOf = parent_id
      }

      Button {
        id = discardId
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_marginEnd = 8.dp()
        ds_textRes = R.string.discard
        ds_constraintBaseline_toBaselineOf = uploadId
        ds_constraintEnd_toStartOf = uploadId
        elevation = 0f
      }

      TextView {
        id = descriptionId
        ds_layout_width = 0
        ds_layout_height = 0
        ds_marginStart = 16.dp()
        ds_marginTop = 8.dp()
        ds_marginEnd = 16.dp()
        ds_marginBottom = 8.dp()
        ds_textRes = R.string.singapore_description
        ds_textSizeDp = 15f
        ds_constraintBottom_toTopOf = discardId
        ds_constraintTop_toBottomOf = settingsId
        ds_constraintHorizontal_alignOf = parent_id
        ellipsize = TextUtils.TruncateAt.END
        isVerticalFadingEdgeEnabled = true
      }
    }

  @SuppressLint("SetTextI18n")
  private fun buildViewByDsl(): View =
    ConstraintLayout {
      ds_layout_width = match_parent
      ds_layout_height = match_parent

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
        ds_layout_width = 40.dp()
        ds_layout_height = 40.dp()
        ds_marginStart = 20.dp()
        ds_marginTop = 20.dp()
        ds_imageSrc = R.drawable.ic_back_black
        ds_constraintStart_toStartOf = parent_id
        ds_constraintTop_toTopOf = parent_id
        onClick = { finish() }
      }

      TextView {
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_textSizeDp = 30f
        ds_textStyle = bold
        ds_constraintVertical_alignOf = ivBackId
        ds_constraintHorizontal_alignOf = parent_id
        text = "commit"
      }

      ImageView {
        ds_layout_width = 40.dp()
        ds_layout_height = 40.dp()
        ds_imageSrc = R.drawable.ic_member_more
        ds_constraintVertical_alignOf = ivBackId
        ds_constraintEnd_toEndOf = parent_id
        ds_marginEnd = 20.dp()
      }

      View {
        id = vDividerId
        ds_layout_width = match_parent
        ds_layout_height = 1
        ds_marginTop = 10.dp()
        ds_backgroundColor = "#eeeeee"
        ds_constraintTop_toBottomOf = ivBackId
      }

      Layer {
        id = layerId
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_backgroundRes = R.drawable.tag_checked_shape
        ds_constraintStart_toStartOf = ivDiamondId
        ds_constraintTop_toTopOf = ivDiamondId
        ds_constraintBottom_toBottomOf = tvTimeId
        ds_constraintEnd_toEndOf = tvTimeId
        referencedIds = intArrayOf(ivDiamondId, tvTitleId, tvContentId, ivAvatarId, tvTimeId, tvSubId)
      }

      ImageView {
        id = ivDiamondId
        ds_layout_width = 40.dp()
        ds_layout_height = 40.dp()
        ds_marginStart = 20.dp()
        ds_marginTop = 40.dp()
        ds_imageSrc = R.drawable.diamond_tag
        ds_constraintStart_toStartOf = ivBackId
        ds_constraintTop_toBottomOf = vDividerId
      }

      TextView {
        id = tvTitleId
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_marginStart = 5.dp()
        ds_padding = 10.dp()
        ds_textColor = "#389793"
        ds_textSizeDp = 20f
        ds_textStyle = bold
        ds_constraintVertical_alignOf = ivDiamondId
        ds_constraintStart_toEndOf = ivDiamondId
        gravity = gravity_center
        text = "gole"
      }

      TextView {
        id = tvContentId
        ds_layout_width = 0
        ds_layout_height = wrap_content
        ds_marginTop = 5.dp()
        ds_textSizeDp = 23f
        ds_constraintStart_toStartOf = ivDiamondId
        ds_constraintTop_toBottomOf = ivDiamondId
        ds_constraintEnd_toStartOf = ivAvatarId
        text = "The changes were merged into release with so many bugs"
      }

      ImageView {
        id = ivAvatarId
        ds_layout_width = 100.dp()
        ds_layout_height = 100.dp()
        ds_marginEnd = 20.dp()
        ds_imageSrc = R.drawable.user_portrait_gender_female
        ds_constraintEnd_toEndOf = parent_id
        ds_constraintStart_toEndOf = tvContentId
        ds_constraintTop_toTopOf = tvContentId
      }

      TextView {
        id = tvSubId
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_textColor = "#c4747E8B"
        ds_textSizeDp = 18f
        ds_constraintStart_toStartOf = ivDiamondId
        ds_constraintTop_toBottomOf = tvContentId
        text = "merge it with mercy"
      }

      TextView {
        id = tvTimeId
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_marginTop = 20.dp()
        ds_constraintEnd_toEndOf = ivAvatarId
        ds_constraintTop_toBottomOf = ivAvatarId
        text = "2020.04.30"
      }

      TextView {
        id = tvCancelId
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_marginEnd = 30.dp()
        ds_backgroundRes = R.drawable.bg_orange_btn
        ds_paddingStart = 30.dp()
        ds_paddingTop = 10.dp()
        ds_paddingEnd = 30.dp()
        ds_paddingBottom = 10.dp()
        ds_marginBottom = 20.dp()
        ds_textSizeDp = 20f
        ds_textStyle = bold
        ds_constraintBottom_toBottomOf = parent_id
        ds_constraintEnd_toStartOf = tvOkId
        ds_constraintStart_toStartOf = parent_id
        ds_constraintHorizontal_chainStyle = packed
        text = "cancel"
      }

      TextView {
        id = tvOkId
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_backgroundRes = R.drawable.bg_orange_btn
        ds_paddingStart = 30.dp()
        ds_paddingTop = 10.dp()
        ds_marginBottom = 20.dp()
        ds_paddingEnd = 30.dp()
        ds_paddingBottom = 10.dp()
        ds_textSizeDp = 20f
        ds_textStyle = bold
        ds_constraintBottom_toBottomOf = parent_id
        ds_constraintEnd_toEndOf = parent_id
        ds_constraintHorizontal_chainStyle = packed
        ds_constraintStart_toEndOf = tvCancelId
        text = "Ok"
      }
    }
}
