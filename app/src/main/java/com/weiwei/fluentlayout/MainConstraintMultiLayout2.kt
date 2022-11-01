package com.weiwei.fluentlayout

import android.content.Context
import android.text.InputType
import android.text.TextUtils
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weiwei.fluentview.view.appcompat.button
import com.weiwei.fluentview.view.appcompat.editText
import com.weiwei.fluentview.view.appcompat.imageView
import com.weiwei.fluentview.view.appcompat.textView
import com.weiwei.fluentview.view.constraint.centerHorizontalOf
import com.weiwei.fluentview.view.constraint.constraintParams
import com.weiwei.fluentview.view.constraint.parentId
import com.weiwei.fluentview.view.createRefs
import com.weiwei.fluentview.ui.allPadding
import com.weiwei.fluentview.ui.backgroundResource
import com.weiwei.fluentview.ui.ems
import com.weiwei.fluentview.ui.imageResource
import com.weiwei.fluentview.ui.scaleCenterCrop
import com.weiwei.fluentview.ui.textResource
import com.weiwei.fluentview.ui.textSizeDp
import com.weiwei.fluentview.ui.unit.dp
import com.weiwei.fluentview.view.wrapContent
import com.weiwei.fluentlayout.more.MoreToolKtView

class MainConstraintMultiLayout2 : ConstraintLayout {
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

    val (tool1) = createRefs()
    MoreToolKtView(context).apply {
      layoutParams = constraintParams(0, 72.dp) {
        bottomMargin = 64.dp
        leftToLeft = parentId
        rightToRight = parentId
        bottomToBottom = parentId
      }
      id = tool1
    }.also { addView(it) }

    MoreToolKtView(context).apply {
      layoutParams = constraintParams(0, 72.dp) {
        leftToLeft = parentId
        rightToRight = parentId
        bottomToTop = tool1
      }
    }.also { addView(it) }
  }
}