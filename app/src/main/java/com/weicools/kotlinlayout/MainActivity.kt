package com.weicools.kotlinlayout

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.LayoutInflaterCompat
import com.weicools.kotlinlayout.dsl.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

class MainActivity : AppCompatActivity() {
  companion object {
    private const val TEST_TAG = "TEST_TAG"
  }

  override fun onWindowFocusChanged(hasFocus: Boolean) {
    super.onWindowFocusChanged(hasFocus)
    if (hasFocus) {
      TimeRecorder.recordStopTime()
    }
  }

  @ExperimentalTime
  override fun onCreate(savedInstanceState: Bundle?) {
    LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), object : LayoutInflater.Factory2 {
      private var sumMs: Double = 0.0
      override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {
        val (view, cost) = measureTimedValue { delegate.createView(parent, name, context, attrs) }
        sumMs += cost.inMilliseconds
        Log.d(TEST_TAG, "view=${view?.let { it::class.simpleName }} cost=${cost}  sumMs=${sumMs}")
        return view
      }

      // private var sumUs: Float = 0f
      // override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {
      //   val startNs = System.nanoTime()
      //   val view = delegate.createView(parent, name, context, attrs)
      //   val costUs = (System.nanoTime() - startNs) / 1000f
      //   sumUs += costUs
      //
      //   Log.d(TEST_TAG, "view=${view?.let { it::class.simpleName }} costUs=${costUs}  sumMs=${sumUs / 1000f}")
      //   return view
      // }

      override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return null
      }
    })
    super.onCreate(savedInstanceState)

    // setContentView(R.layout.activity_traditional_layout)
    // setContentView(R.layout.activity_constraint_layout)
    setContentView(MainConstraintLayout(this))

    val testView = findView<View>(2)
    Log.d("findViewById", "View = $testView, View = ${testView?.let { it::class.simpleName }}")
    val testView2 = findView<View>(200)
    Log.d("findViewById", "View2 = $testView2, View = ${testView2?.let { it::class.simpleName }}")
  }

  private fun buildConstraintLayout(): View =
    ConstraintLayout {
      ds_layout_width = match_parent
      ds_layout_height = match_parent

      ImageView {
        id = R.id.ivHeader
        ds_layout_width = 0
        ds_layout_height = 0
        ds_marginBottom = 16.dp
        ds_imageSrc = R.drawable.singapore
        ds_constraintBottom_toBottomOf = R.id.ivFavorite
        ds_constraintTop_toTopOf = parent_id
        ds_constraintHorizontal_alignOf = parent_id
        ds_constraintHorizontal_bias = 1.0f
        ds_constraintVertical_bias = 0.0f
        scaleType = scale_centerCrop
      }

      ImageView {
        id = R.id.ivFavorite
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
        id = R.id.tvTitle
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_marginStart = 16.dp
        ds_marginTop = 16.dp
        ds_textRes = R.string.singapore
        ds_textSizeDp = 24f
        ds_constraintStart_toStartOf = parent_id
        ds_constraintTop_toBottomOf = R.id.ivHeader
      }

      EditText {
        id = R.id.etCameraType
        ds_layout_width = 0
        ds_layout_height = wrap_content
        ds_marginTop = 8.dp
        ds_textEms = 10
        ds_textRes = R.string.camera_value
        ds_constraintHorizontal_alignOf = R.id.etSettings
        ds_constraintTop_toBottomOf = R.id.tvTitle
        inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
      }

      TextView {
        id = R.id.tvCameraLabel
        ds_layout_width = wrap_content
        ds_layout_height = wrap_content
        ds_marginStart = 16.dp
        ds_textRes = R.string.camera
        ds_constraintBaseline_toBaselineOf = R.id.etCameraType
        ds_constraintStart_toStartOf = parent_id
        labelFor = R.id.etCameraType
      }

      TextView {
        id = R.id.tvSettingLabel
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
        ds_constraintStart_toEndOf = R.id.tvSettingLabel
        ds_constraintEnd_toEndOf = R.id.tvDescription
        ds_constraintTop_toBottomOf = R.id.etCameraType
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
        id = R.id.tvDescription
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
