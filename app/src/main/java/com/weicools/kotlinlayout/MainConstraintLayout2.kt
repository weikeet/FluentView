package com.weicools.kotlinlayout

import android.content.Context
import android.os.Build
import android.text.InputType
import android.text.TextUtils
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.widget.dsl.button
import com.weicools.kotlinlayout.widget.dsl.editText
import com.weicools.kotlinlayout.widget.dsl.imageView
import com.weicools.kotlinlayout.widget.dsl.textView
import com.weicools.kotlinlayout.widget.extensions.background_resource
import com.weicools.kotlinlayout.widget.extensions.dp
import com.weicools.kotlinlayout.widget.extensions.elevation_compat
import com.weicools.kotlinlayout.widget.extensions.image_resource
import com.weicools.kotlinlayout.widget.extensions.paddings
import com.weicools.kotlinlayout.widget.extensions.scaleCenterCrop
import com.weicools.kotlinlayout.widget.extensions.text_ems
import com.weicools.kotlinlayout.widget.extensions.text_resource
import com.weicools.kotlinlayout.widget.extensions.text_sizeDp
import com.weicools.kotlinlayout.widget.ids.createRefs
import com.weicools.kotlinlayout.widget.params.center_HorizontalOf
import com.weicools.kotlinlayout.widget.params.constraintParams
import com.weicools.kotlinlayout.widget.params.parentId
import com.weicools.kotlinlayout.widget.params.wrapContent

class MainConstraintLayout2 : ConstraintLayout {
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
      layoutParams = constraintParams(0, 0) {
        bottomMargin = 16.dp
        topToTop = parentId
        bottomToBottom = ivFavorite
        center_HorizontalOf = parentId
        horizontalBias = 1f
      }
      image_resource = R.drawable.singapore
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
      paddings = 5.dp
      image_resource = R.drawable.ic_star
      background_resource = R.drawable.info_background
    }

    textView(tvTitle) {
      layoutParams = constraintParams {
        leftMargin = 16.dp
        rightMargin = 16.dp
        leftToLeft = parentId
        topToBottom = ivHeader
      }
      text_resource = R.string.singapore
      text_sizeDp = 24f
    }

    editText(etCameraType) {
      layoutParams = constraintParams(0, wrapContent) {
        topMargin = 8.dp
        center_HorizontalOf = etSettings
        topToBottom = tvTitle
      }
      text_ems = 10
      text_resource = R.string.camera_value
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    textView(tvCameraLabel) {
      layoutParams = constraintParams {
        leftMargin = 16.dp
        leftToLeft = parentId
        baselineToBaseline = etCameraType
        if (Build.VERSION.SDK_INT >= 21) {
          labelFor = etCameraType
        }
      }
      text_resource = R.string.camera
    }

    textView(tvSettingLabel) {
      layoutParams = constraintParams {
        leftMargin = 16.dp
        baselineToBaseline = etSettings
        leftToLeft = parentId
        if (Build.VERSION.SDK_INT >= 21) {
          labelFor = etSettings
        }
      }
      text_resource = R.string.settings
    }

    editText(etSettings) {
      layoutParams = constraintParams(0, wrapContent) {
        leftMargin = 6.dp
        topMargin = 6.dp
        leftToRight = tvSettingLabel
        rightToRight = tvDescription
        topToBottom = etCameraType
      }
      text_ems = 10
      text_resource = R.string.camera_settings
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    button(btnUpload) {
      layoutParams = constraintParams {
        rightMargin = 16.dp
        bottomMargin = 16.dp
        bottomToBottom = parentId
        rightToRight = parentId
      }
      text_resource = R.string.upload
    }

    button(btnDiscard) {
      layoutParams = constraintParams {
        rightMargin = 8.dp
        baselineToBaseline = btnUpload
        rightToLeft = btnUpload
      }
      text_resource = R.string.discard
      elevation_compat = 0f
    }

    textView(tvDescription) {
      layoutParams = constraintParams(0, 0) {
        leftMargin = 16.dp
        topMargin = 8.dp
        rightMargin = 16.dp
        bottomMargin = 8.dp
        bottomToTop = btnDiscard
        topToBottom = etSettings
        center_HorizontalOf = parentId
      }
      text_resource = R.string.singapore_description
      textSize = 15f
      ellipsize = TextUtils.TruncateAt.END
      isVerticalFadingEdgeEnabled = true
    }
  }
}