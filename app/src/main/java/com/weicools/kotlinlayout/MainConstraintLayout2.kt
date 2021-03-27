package com.weicools.kotlinlayout

import android.content.Context
import android.text.InputType
import android.text.TextUtils
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.dsl.*

class MainConstraintLayout2 : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    val (ivHeader, ivFavorite, tvTitle, etCameraType, tvCameraLabel,
      tvSettingLabel, etSettings, btnUpload, btnDiscard, tvDescription
    ) = createRefs()

    imageView {
      id = ivHeader
      layoutParams = constraintLayoutParams {
        bottomMargin = 16.dp
        topToTop = parentId
        bottomToBottom = ivFavorite
        center_HorizontalOf = parentId
        horizontalBias = 1f
      }
      src_compat = R.drawable.singapore
      scaleType = scaleCenterCrop
    }

    imageView {
      id = ivFavorite
      layoutParams = constraintLayoutParams(36.dp, 36.dp) {
        rightMargin = 16.dp
        bottomMargin = 16.dp
        topToTop = parentId
        bottomToBottom = parentId
        rightToRight = parentId
        verticalBias = 0.19f
      }
      paddings = 5.dp
      src_compat = R.drawable.ic_star
      background_res = R.drawable.info_background
    }

    textView {
      id = tvTitle
      layoutParams = constraintLayoutParams(wrapContent, wrapContent) {
        leftMargin = 16.dp
        rightMargin = 16.dp
        leftToLeft = parentId
        topToBottom = ivHeader
      }
      text_res = R.string.singapore
      text_sizeDp = 24f
      start_toStartOf = parentId
    }

    editText {
      id = etCameraType
      layoutParams = constraintLayoutParams(0, wrapContent) {
        topMargin = 8.dp
        center_HorizontalOf = etSettings
        topToBottom = tvTitle
      }
      text_ems = 10
      text_res = R.string.camera_value
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    textView {
      id = tvCameraLabel
      layoutParams = constraintLayoutParams(wrapContent, wrapContent) {
        leftMargin = 16.dp
        leftToLeft = parentId
        baselineToBaseline = etCameraType
        labelFor = etCameraType
      }
      text_res = R.string.camera
    }

    textView {
      id = tvSettingLabel
      layoutParams = constraintLayoutParams(wrapContent, wrapContent) {
        leftMargin = 16.dp
        baselineToBaseline = etSettings
        leftToLeft = parentId
        labelFor = etSettings
      }
      text_res = R.string.settings
    }

    editText {
      id = etSettings
      layoutParams = constraintLayoutParams(0, wrapContent) {
        leftMargin = 6.dp
        topMargin = 6.dp
        leftToRight = tvSettingLabel
        rightToRight = tvDescription
        topToBottom = etCameraType
      }
      text_ems = 10
      text_res = R.string.camera_settings
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    button {
      id = btnUpload
      layoutParams = constraintLayoutParams(wrapContent, wrapContent) {
        rightMargin = 16.dp
        bottomMargin = 16.dp
        bottomToBottom = parentId
        rightToRight = parentId
      }
      text_res = R.string.upload
    }

    button {
      id = btnDiscard
      layoutParams = constraintLayoutParams(wrapContent, wrapContent) {
        rightMargin = 8.dp
        baselineToBaseline = btnUpload
        rightToLeft = btnUpload
      }
      text_res = R.string.discard
      elevation = 0f
    }

    textView {
      id = tvDescription
      layoutParams = constraintLayoutParams {
        leftMargin = 16.dp
        topMargin = 8.dp
        rightMargin = 16.dp
        bottomMargin = 8.dp
        bottomToTop = btnDiscard
        topToBottom = etSettings
        center_HorizontalOf = parentId
      }
      text_res = R.string.singapore_description
      textSize = 15f
      ellipsize = TextUtils.TruncateAt.END
      isVerticalFadingEdgeEnabled = true
    }
  }
}