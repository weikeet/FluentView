package com.weicools.kotlinlayout

import android.content.Context
import android.os.Build
import android.text.InputType
import android.text.TextUtils
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.widget.background_resource
import com.weicools.kotlinlayout.widget.baseline_toBaselineOf
import com.weicools.kotlinlayout.widget.bottom_toBottomOf
import com.weicools.kotlinlayout.widget.bottom_toTopOf
import com.weicools.kotlinlayout.widget.button
import com.weicools.kotlinlayout.widget.center_horizontalOf
import com.weicools.kotlinlayout.widget.center_verticalOf
import com.weicools.kotlinlayout.widget.createRefs
import com.weicools.kotlinlayout.widget.dp
import com.weicools.kotlinlayout.widget.editText
import com.weicools.kotlinlayout.widget.elevation_compat
import com.weicools.kotlinlayout.widget.end_toEndOf
import com.weicools.kotlinlayout.widget.end_toStartOf
import com.weicools.kotlinlayout.widget.horizontal_bias
import com.weicools.kotlinlayout.widget.imageView
import com.weicools.kotlinlayout.widget.image_resource
import com.weicools.kotlinlayout.widget.layout_height
import com.weicools.kotlinlayout.widget.layout_width
import com.weicools.kotlinlayout.widget.margin_Bottom
import com.weicools.kotlinlayout.widget.margin_End
import com.weicools.kotlinlayout.widget.margin_Start
import com.weicools.kotlinlayout.widget.margin_Top
import com.weicools.kotlinlayout.widget.paddings
import com.weicools.kotlinlayout.widget.parentId
import com.weicools.kotlinlayout.widget.scaleCenterCrop
import com.weicools.kotlinlayout.widget.start_toEndOf
import com.weicools.kotlinlayout.widget.start_toStartOf
import com.weicools.kotlinlayout.widget.textView
import com.weicools.kotlinlayout.widget.text_ems
import com.weicools.kotlinlayout.widget.text_resource
import com.weicools.kotlinlayout.widget.text_sizeDp
import com.weicools.kotlinlayout.widget.top_toBottomOf
import com.weicools.kotlinlayout.widget.top_toTopOf
import com.weicools.kotlinlayout.widget.vertical_bias
import com.weicools.kotlinlayout.widget.wrapContent

class MainConstraintLayout : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    createView()
  }

  private fun createView() {
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
      image_resource = R.drawable.singapore
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
      image_resource = R.drawable.ic_star
      background_resource = R.drawable.info_background
    }

    textView(tvTitle) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_Start = 16.dp
      margin_Top = 16.dp
      top_toBottomOf = ivHeader
      text_resource = R.string.singapore
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
      text_resource = R.string.camera_value
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    textView(tvCameraLabel) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_Start = 16.dp
      start_toStartOf = parentId
      baseline_toBaselineOf = etCameraType
      if (Build.VERSION.SDK_INT > 16) {
        labelFor = etCameraType
      }
      text_resource = R.string.camera
    }

    textView(tvSettingLabel) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_Start = 16.dp
      baseline_toBaselineOf = etSettings
      start_toStartOf = parentId
      if (Build.VERSION.SDK_INT > 16) {
        labelFor = etSettings
      }
      text_resource = R.string.settings
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
      text_resource = R.string.camera_settings
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    button(btnUpload) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_End = 16.dp
      margin_Bottom = 16.dp
      bottom_toBottomOf = parentId
      end_toEndOf = parentId
      text_resource = R.string.upload
    }

    button(btnDiscard) {
      layout_width = wrapContent
      layout_height = wrapContent
      margin_End = 8.dp
      baseline_toBaselineOf = btnUpload
      end_toStartOf = btnUpload
      text_resource = R.string.discard
      elevation_compat = 0f
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
      text_resource = R.string.singapore_description
      textSize = 15f
      ellipsize = TextUtils.TruncateAt.END
      isVerticalFadingEdgeEnabled = true
    }
  }
}