package com.weicools.kotlinlayout

import android.content.Context
import android.text.InputType
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.dsl.*

class MainConstraintLayout @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
  private val map = ViewIdMap()
  private fun toId(id: String) = map.getViewId(id)

  init {
    ImageView {
      id = toId("ivHeader")
      ds_layout_width = 0
      ds_layout_height = 0
      ds_marginBottom = 16.dp
      ds_imageSrc = R.drawable.singapore
      ds_constraintBottom_toBottomOf = toId("ivFavorite")
      ds_constraintTop_toTopOf = parent_id
      ds_constraintHorizontal_alignOf = parent_id
      ds_constraintHorizontal_bias = 1.0f
      ds_constraintVertical_bias = 0.0f
      scaleType = scale_centerCrop
    }

    ImageView {
      id = toId("ivFavorite")
      ds_layout_width = 36.dp
      ds_layout_height = 36.dp
      ds_marginEnd = 16.dp
      ds_marginBottom = 16.dp
      ds_backgroundRes = R.drawable.info_background
      ds_padding = 5.dp
      ds_imageSrc = R.drawable.ic_star
      ds_constraintVertical_alignOf = parent_id
      ds_constraintEnd_toEndOf = parent_id
      ds_constraintVertical_bias = 0.19f
    }

    TextView {
      id = toId("tvTitle")
      ds_layout_width = wrap_content
      ds_layout_height = wrap_content
      ds_marginStart = 16.dp
      ds_marginTop = 16.dp
      ds_textRes = R.string.singapore
      ds_textSizeDp = 24f
      ds_constraintStart_toStartOf = parent_id
      ds_constraintTop_toBottomOf = toId("ivHeader")
    }

    EditText {
      id = toId("etCameraType")
      ds_layout_width = 0
      ds_layout_height = wrap_content
      ds_marginTop = 8.dp
      ds_textEms = 10
      ds_textRes = R.string.camera_value
      ds_constraintHorizontal_alignOf = R.id.etSettings
      ds_constraintTop_toBottomOf = toId("tvTitle")
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    TextView {
      id = toId("tvCameraLabel")
      ds_layout_width = wrap_content
      ds_layout_height = wrap_content
      ds_marginStart = 16.dp
      ds_textRes = R.string.camera
      ds_constraintBaseline_toBaselineOf = toId("etCameraType")
      ds_constraintStart_toStartOf = parent_id
      labelFor = toId("etCameraType")
    }

    TextView {
      id = toId("tvSettingLabel")
      ds_layout_width = wrap_content
      ds_layout_height = wrap_content
      ds_marginStart = 16.dp
      ds_textRes = R.string.settings
      ds_constraintBaseline_toBaselineOf = R.id.etSettings
      ds_constraintStart_toStartOf = parent_id
      labelFor = R.id.etSettings
    }

    EditText {
      id = R.id.etSettings
      ds_layout_width = 0
      ds_layout_height = wrap_content
      ds_marginStart = 6.dp
      ds_marginTop = 8.dp
      ds_textEms = 10
      ds_textRes = R.string.camera_settings
      ds_constraintStart_toEndOf = toId("tvSettingLabel")
      ds_constraintEnd_toEndOf = toId("tvDescription")
      ds_constraintTop_toBottomOf = toId("etCameraType")
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    Button {
      id = R.id.btnUpload
      ds_layout_width = wrap_content
      ds_layout_height = wrap_content
      ds_marginEnd = 16.dp
      ds_marginBottom = 16.dp
      ds_textRes = R.string.upload
      ds_constraintBottom_toBottomOf = parent_id
      ds_constraintEnd_toEndOf = parent_id
    }

    Button {
      id = R.id.btnDiscard
      ds_layout_width = wrap_content
      ds_layout_height = wrap_content
      ds_marginEnd = 8.dp
      ds_textRes = R.string.discard
      ds_constraintBaseline_toBaselineOf = R.id.btnUpload
      ds_constraintEnd_toStartOf = R.id.btnUpload
      elevation = 0f
    }

    TextView {
      id = toId("tvDescription")
      ds_layout_width = 0
      ds_layout_height = 0
      ds_marginStart = 16.dp
      ds_marginTop = 8.dp
      ds_marginEnd = 16.dp
      ds_marginBottom = 8.dp
      ds_textRes = R.string.singapore_description
      ds_textSizeDp = 15f
      ds_constraintBottom_toTopOf = R.id.btnDiscard
      ds_constraintTop_toBottomOf = R.id.etSettings
      ds_constraintHorizontal_alignOf = parent_id
      ellipsize = TextUtils.TruncateAt.END
      isVerticalFadingEdgeEnabled = true
    }
  }
}