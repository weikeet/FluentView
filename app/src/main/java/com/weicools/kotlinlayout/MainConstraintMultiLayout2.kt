package com.weicools.kotlinlayout

import android.content.Context
import android.text.InputType
import android.text.TextUtils
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.dsl.*
import com.weicools.kotlinlayout.widget.*

class MainConstraintMultiLayout2 : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    val (ivHeader, ivFavorite, tvTitle, etCameraType, tvCameraLabel,
      tvSettingLabel, etSettings, btnUpload, btnDiscard, tvDescription
    ) = createRefs()

    imageView(ivHeader) {
      layoutParams = constraintLayoutParams(0, 0) {
        bottomMargin = 16.dp
        topToTop = parentId
        bottomToBottom = ivFavorite
        center_HorizontalOf = parentId
        horizontalBias = 1f
      }
      src_compat = R.drawable.singapore
      scaleType = scaleCenterCrop
    }

    imageView(ivFavorite) {
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

    textView(tvTitle) {
      layoutParams = constraintLayoutParams {
        leftMargin = 16.dp
        rightMargin = 16.dp
        leftToLeft = parentId
        topToBottom = ivHeader
      }
      text_res = R.string.singapore
      text_sizeDp = 24f
      start_toStartOf = parentId
    }

    editText(etCameraType) {
      layoutParams = constraintLayoutParams(0, wrapContent) {
        topMargin = 8.dp
        center_HorizontalOf = etSettings
        topToBottom = tvTitle
      }
      text_ems = 10
      text_res = R.string.camera_value
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    textView(tvCameraLabel) {
      layoutParams = constraintLayoutParams {
        leftMargin = 16.dp
        leftToLeft = parentId
        baselineToBaseline = etCameraType
        labelFor = etCameraType
      }
      text_res = R.string.camera
    }

    textView(tvSettingLabel) {
      layoutParams = constraintLayoutParams {
        leftMargin = 16.dp
        baselineToBaseline = etSettings
        leftToLeft = parentId
        labelFor = etSettings
      }
      text_res = R.string.settings
    }

    editText(etSettings) {
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

    button(btnUpload) {
      layoutParams = constraintLayoutParams {
        rightMargin = 16.dp
        bottomMargin = 16.dp
        bottomToBottom = parentId
        rightToRight = parentId
      }
      text_res = R.string.upload
    }

    button(btnDiscard) {
      layoutParams = constraintLayoutParams {
        rightMargin = 8.dp
        baselineToBaseline = btnUpload
        rightToLeft = btnUpload
      }
      text_res = R.string.discard
      elevation = 0f
    }

    textView(tvDescription) {
      layoutParams = constraintLayoutParams(0, 0) {
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

    Draw01LinearGradientView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    Draw02RadialGradientView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 24.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    Draw03SweepGradientView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 48.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    Draw04BitmapShaderView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 72.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    Draw01LinearGradientView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 96.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    DrawArcView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 120.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    DrawCircleView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 144.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    DrawColorView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 168.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    DrawLineView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 192.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    DrawOvalView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 216.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    DrawPathView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 240.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    DrawPointView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 264.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    DrawRectView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 288.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    DrawRoundRectView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 312.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    OutRippleView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 336.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    RippleView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        bottomMargin = 40.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }

    WaveRippleView(context).apply {
      layoutParams = constraintLayoutParams(20.dp, 20.dp) {
        leftMargin = 24.dp
        bottomMargin = 40.dp
        bottomToBottom = parentId
        leftToLeft = parentId
      }
    }.also { addView(it) }
  }
}