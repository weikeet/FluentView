package com.weiwei.fluentlayout

import android.content.Context
import android.text.InputType
import android.text.TextUtils
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weikeet.ui.unit.dp
import com.weikeet.ui.view.appcompat.button
import com.weikeet.ui.view.appcompat.editText
import com.weikeet.ui.view.appcompat.imageView
import com.weikeet.ui.view.appcompat.textView
import com.weikeet.ui.view.constraint.centerHorizontalOf
import com.weikeet.ui.view.constraint.constraintParams
import com.weikeet.ui.view.constraint.parentId
import com.weikeet.ui.view.createRefs
import com.weikeet.ui.view.wrapContent
import com.weikeet.ui.widget.allPadding
import com.weikeet.ui.widget.backgroundResource
import com.weikeet.ui.widget.ems
import com.weikeet.ui.widget.imageResource
import com.weikeet.ui.widget.scaleCenterCrop
import com.weikeet.ui.widget.textResource
import com.weikeet.ui.widget.textSizeDp

class MainConstraintLayout2 : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

  init {
    createView()
  }

  private fun createView() {
    val (ivHeader, ivFavorite, tvTitle, etCameraType, tvCameraLabel,
      tvSettingLabel, etSettings, btnUpload, btnDiscard, tvDescription
    ) = createRefs()

    imageView(ivHeader) {
      layoutParams = constraintParams(0, 0) {
        bottomMargin = 16.dp
        topToTop = parentId
        bottomToBottom = ivFavorite
        centerHorizontalOf = parentId
        horizontalBias = 1f
      }
      imageResource = R.drawable.singapore
      scaleType = scaleCenterCrop
    }

    imageView(ivFavorite) {
      layoutParams = constraintParams(36.dp, 36.dp) {
        rightMargin = 16.dp
        bottomMargin = 16.dp
        topToTop = parentId
        bottomToBottom = parentId
        rightToRight = parentId
        verticalBias = 0.19f
      }
      allPadding = 5.dp
      imageResource = R.drawable.ic_star
      backgroundResource = R.drawable.info_background
    }

    textView(tvTitle) {
      layoutParams = constraintParams {
        leftMargin = 16.dp
        rightMargin = 16.dp
        leftToLeft = parentId
        topToBottom = ivHeader
      }
      textResource = R.string.singapore
      textSizeDp = 24f
    }

    editText(etCameraType) {
      layoutParams = constraintParams(0, wrapContent) {
        topMargin = 8.dp
        centerHorizontalOf = etSettings
        topToBottom = tvTitle
      }
      ems = 10
      textResource = R.string.camera_value
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    textView(tvCameraLabel) {
      layoutParams = constraintParams {
        leftMargin = 16.dp
        leftToLeft = parentId
        baselineToBaseline = etCameraType
        labelFor = etCameraType
      }
      textResource = R.string.camera
    }

    textView(tvSettingLabel) {
      layoutParams = constraintParams {
        leftMargin = 16.dp
        baselineToBaseline = etSettings
        leftToLeft = parentId
        labelFor = etSettings
      }
      textResource = R.string.settings
    }

    editText(etSettings) {
      layoutParams = constraintParams(0, wrapContent) {
        leftMargin = 6.dp
        topMargin = 6.dp
        leftToRight = tvSettingLabel
        rightToRight = tvDescription
        topToBottom = etCameraType
      }
      ems = 10
      textResource = R.string.camera_settings
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    button(btnUpload) {
      layoutParams = constraintParams {
        rightMargin = 16.dp
        bottomMargin = 16.dp
        bottomToBottom = parentId
        rightToRight = parentId
      }
      textResource = R.string.upload
    }

    button(btnDiscard) {
      layoutParams = constraintParams {
        rightMargin = 8.dp
        baselineToBaseline = btnUpload
        rightToLeft = btnUpload
      }
      textResource = R.string.discard
      elevation = 0f
    }

    textView(tvDescription) {
      layoutParams = constraintParams(0, 0) {
        leftMargin = 16.dp
        topMargin = 8.dp
        rightMargin = 16.dp
        bottomMargin = 8.dp
        bottomToTop = btnDiscard
        topToBottom = etSettings
        centerHorizontalOf = parentId
      }
      textResource = R.string.singapore_description
      textSize = 15f
      ellipsize = TextUtils.TruncateAt.END
      isVerticalFadingEdgeEnabled = true
    }
  }
}