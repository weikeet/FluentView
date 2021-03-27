package com.weicools.kotlinlayout

import android.content.Context
import android.text.InputType
import android.text.TextUtils
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.dsl.*

class MainConstraintLayout : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    val (ivHeader, ivFavorite, tvTitle, etCameraType, tvCameraLabel,
      tvSettingLabel, etSettings, btnUpload, btnDiscard, tvDescription
    ) = createRefs()

    imageView(ivHeader) {
      layout_width = 0
      layout_height = 0
      margin_Bottom = 16.dp
      bottom_toBottomOf = ivFavorite
      top_toTopOf = parentId
      center_horizontalOf = parentId
      horizontal_bias = 1.0f
      vertical_bias = 0.0f
      src_compat = R.drawable.singapore
      scaleType = scaleCenterCrop
    }

    imageView(ivFavorite) {
      layout_width = 36.dp
      layout_height = 36.dp
      margin_End = 16.dp
      margin_Bottom = 16.dp
      center_verticalOf = parentId
      end_toEndOf = parentId
      vertical_bias = 0.19f
      paddings = 5.dp
      src_compat = R.drawable.ic_star
      background_res = R.drawable.info_background
    }

    textView(tvTitle) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_Start = 16.dp
      margin_Top = 16.dp
      top_toBottomOf = ivHeader
      text_res = R.string.singapore
      text_sizeDp = 24f
      start_toStartOf = parentId
    }

    editText(etCameraType) {
      layout_width = 0
      layout_height = wrapContent
      margin_Top = 8.dp
      center_horizontalOf = etSettings
      top_toBottomOf = tvTitle
      text_ems = 10
      text_res = R.string.camera_value
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    textView(tvCameraLabel) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_Start = 16.dp
      start_toStartOf = parentId
      baseline_toBaselineOf = etCameraType
      labelFor = etCameraType
      text_res = R.string.camera
    }

    textView(tvSettingLabel) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_Start = 16.dp
      baseline_toBaselineOf = etSettings
      start_toStartOf = parentId
      labelFor = etSettings
      text_res = R.string.settings
    }

    editText(etSettings) {
      layout_width = 0
      layout_height = wrapContent
      margin_Start = 6.dp
      margin_Top = 8.dp
      start_toEndOf = tvSettingLabel
      end_toEndOf = tvDescription
      top_toBottomOf = etCameraType
      text_ems = 10
      text_res = R.string.camera_settings
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    button(btnUpload) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_End = 16.dp
      margin_Bottom = 16.dp
      bottom_toBottomOf = parentId
      end_toEndOf = parentId
      text_res = R.string.upload
    }

    button(btnDiscard) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_End = 8.dp
      baseline_toBaselineOf = btnUpload
      end_toStartOf = btnUpload
      text_res = R.string.discard
      elevation = 0f
    }

    textView(tvDescription) {
      layout_width = 0
      layout_height = 0
      margin_Start = 16.dp
      margin_Top = 8.dp
      margin_End = 16.dp
      margin_Bottom = 8.dp
      bottom_toTopOf = btnDiscard
      top_toBottomOf = etSettings
      center_horizontalOf = parentId
      text_res = R.string.singapore_description
      textSize = 15f
      ellipsize = TextUtils.TruncateAt.END
      isVerticalFadingEdgeEnabled = true
    }
  }
}