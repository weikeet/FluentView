@file:Suppress("unused", "FunctionName")

package com.weicools.kotlinlayout.dsl

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.helper.widget.Layer
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.MarginLayoutParamsCompat
import androidx.core.view.ViewCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

/**
 * @author weicools
 * @date 2020.05.14
 */

//region ViewGroup widget creation function
inline fun ViewGroup.View(init: View.() -> Unit) =
  View(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ViewGroup.TextView(init: AppCompatTextView.() -> Unit) =
  AppCompatTextView(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ViewGroup.ImageView(init: AppCompatImageView.() -> Unit) =
  AppCompatImageView(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ViewGroup.Button(init: Button.() -> Unit) =
  AppCompatButton(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ViewGroup.EditText(init: EditText.() -> Unit) =
  EditText(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ConstraintLayout.Guideline(init: Guideline.() -> Unit) =
  Guideline(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ConstraintLayout.Flow(init: Flow.() -> Unit) =
  Flow(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ConstraintLayout.Layer(init: Layer.() -> Unit) =
  Layer(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ViewGroup.ConstraintLayout(init: ConstraintLayout.() -> Unit) =
  ConstraintLayout(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ViewGroup.LinearLayout(init: LinearLayout.() -> Unit) =
  LinearLayout(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ViewGroup.FrameLayout(init: FrameLayout.() -> Unit) =
  FrameLayout(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ViewGroup.RelativeLayout(init: RelativeLayout.() -> Unit) =
  RelativeLayout(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ViewGroup.NestedScrollView(init: NestedScrollView.() -> Unit) =
  NestedScrollView(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }

inline fun ViewGroup.RecyclerView(init: RecyclerView.() -> Unit) =
  RecyclerView(context).apply {
    id = ViewCompat.generateViewId()
    init()
  }.also { addView(it) }
//endregion

//region Context widget creation function
inline fun Context.View(init: View.() -> Unit) = View(this).apply(init)

inline fun Context.TextView(init: TextView.() -> Unit) = AppCompatTextView(this).apply(init)

inline fun Context.ImageView(init: ImageView.() -> Unit) = AppCompatImageView(this).apply(init)

inline fun Context.Button(init: Button.() -> Unit) = AppCompatButton(this).apply(init)

inline fun Context.ConstraintLayout(init: ConstraintLayout.() -> Unit) = ConstraintLayout(this).apply(init)

inline fun Context.LinearLayout(init: LinearLayout.() -> Unit) = LinearLayout(this).apply(init)

inline fun Context.FrameLayout(init: FrameLayout.() -> Unit) = FrameLayout(this).apply(init)

inline fun Context.RelativeLayout(init: RelativeLayout.() -> Unit) = RelativeLayout(this).apply(init)

inline fun Context.NestedScrollView(init: NestedScrollView.() -> Unit) = NestedScrollView(this).apply(init)

inline fun Context.RecyclerView(init: RecyclerView.() -> Unit) = RecyclerView(this).apply(init)
//endregion

//region Fragment widget creation function
inline fun Fragment.View(init: View.() -> Unit) = context?.View(init)

inline fun Fragment.TextView(init: TextView.() -> Unit) = context?.TextView(init)

inline fun Fragment.ImageView(init: ImageView.() -> Unit) = context?.ImageView(init)

inline fun Fragment.Button(init: Button.() -> Unit) = context?.Button(init)

inline fun Fragment.ConstraintLayout(init: ConstraintLayout.() -> Unit) = context?.ConstraintLayout(init)

inline fun Fragment.LinearLayout(init: LinearLayout.() -> Unit) = context?.LinearLayout(init)

inline fun Fragment.FrameLayout(init: FrameLayout.() -> Unit) = context?.FrameLayout(init)

inline fun Fragment.RelativeLayout(init: RelativeLayout.() -> Unit) = context?.RelativeLayout(init)

inline fun Fragment.NestedScrollView(init: NestedScrollView.() -> Unit) = context?.NestedScrollView(init)

inline fun Fragment.RecyclerView(init: RecyclerView.() -> Unit) = context?.RecyclerView(init)
//endregion

//region View extend field
inline var View.ds_layout_width: Int
  get() = 0
  set(value) {
    val h = layoutParams?.height ?: 0
    layoutParams = ViewGroup.MarginLayoutParams(value, h)
  }

inline var View.ds_layout_height: Int
  get() = 0
  set(value) {
    val w = layoutParams?.width ?: 0
    layoutParams = ViewGroup.MarginLayoutParams(w, value)
  }

inline var View.ds_paddingTop: Int
  get() = 0
  set(value) {
    setPadding(paddingLeft, value, paddingRight, paddingBottom)
  }

inline var View.ds_paddingBottom: Int
  get() = 0
  set(value) {
    setPadding(paddingLeft, paddingTop, paddingRight, value)
  }

inline var View.ds_paddingStart: Int
  get() = 0
  set(value) {
    setPadding(value, paddingTop, paddingRight, paddingBottom)
  }

inline var View.ds_paddingEnd: Int
  get() = 0
  set(value) {
    setPadding(paddingLeft, paddingTop, value, paddingBottom)
  }

inline var View.ds_padding: Int
  get() = 0
  set(value) {
    setPadding(value, value, value, value)
  }

inline var View.ds_marginTop: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      topMargin = value
    }
  }

inline var View.ds_marginBottom: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      bottomMargin = value
    }
  }

inline var View.ds_marginStart: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      MarginLayoutParamsCompat.setMarginStart(this, value)
    }
  }

inline var View.ds_marginEnd: Int
  get() = 0
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      MarginLayoutParamsCompat.setMarginEnd(this, value)
    }
  }

inline var View.ds_backgroundRes: Int
  get() = 0
  set(value) {
    setBackgroundResource(value)
  }

inline var View.ds_backgroundColorRes: Int
  get() = 0
  set(value) {
    setBackgroundColor(ContextCompat.getColor(context, value))
  }

inline var View.ds_backgroundColor: String
  get() = ""
  set(value) {
    setBackgroundColor(Color.parseColor(value))
  }
//endregion

//region TextView extend field
inline var TextView.ds_textRes: Int
  get() = -1
  set(value) = setText(value)

inline var TextView.ds_textColorRes: Int
  get() = -1
  set(value) {
    setTextColor(ContextCompat.getColor(context, value))
  }

inline var TextView.ds_textColor: String
  get() = ""
  set(value) {
    setTextColor(Color.parseColor(value))
  }

inline var TextView.ds_textSizeDp: Float
  get() = 0f
  set(value) {
    setTextSize(TypedValue.COMPLEX_UNIT_DIP, value)
  }

inline var TextView.ds_textStyle: Int
  get() = -1
  set(value) = setTypeface(typeface, value)

inline var TextView.ds_textFontFamily: Int
  get() = 0
  set(value) {
    typeface = ResourcesCompat.getFont(context, value)
  }

inline var TextView.ds_textEms: Int
  get() = -1
  set(value) = setEms(value)
//endregion

//region ImageView extend field
inline var ImageView.ds_imageSrc: Int
  get() = 0
  set(value) {
    setImageDrawable(AppCompatResources.getDrawable(context, value))
  }
//endregion

//region ConstrainLayout extend field
inline var View.ds_constraintTop_toTopOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      topToTop = value
      topToBottom = -1
    }
  }

inline var View.ds_constraintTop_toBottomOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      topToBottom = value
      topToTop = -1
    }
  }

inline var View.ds_constraintBottom_toBottomOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      bottomToBottom = value
      bottomToTop = -1
    }
  }

inline var View.ds_constraintBottom_toTopOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      bottomToTop = value
      bottomToBottom = -1
    }
  }

inline var View.ds_constraintStart_toStartOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      startToStart = value
      startToEnd = -1
    }
  }

inline var View.ds_constraintStart_toEndOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      startToEnd = value
      startToStart = -1
    }
  }

inline var View.ds_constraintEnd_toEndOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      endToEnd = value
      endToStart = -1
    }
  }

inline var View.ds_constraintEnd_toStartOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      endToStart = value
      endToEnd = -1
    }
  }

inline var View.ds_constraintBaseline_toBaselineOf: Int
  get() = -1
  set(value) {
    layoutParams = layoutParams.append {
      baselineToBaseline = value
    }
  }

inline var View.ds_constraintCenter_alignOf: Int
  get() = -1
  set(value) {
    ds_constraintStart_toStartOf = value
    ds_constraintEnd_toEndOf = value
    ds_constraintTop_toTopOf = value
    ds_constraintBottom_toBottomOf = value
  }

inline var View.ds_constraintHorizontal_alignOf: Int
  get() = -1
  set(value) {
    ds_constraintStart_toStartOf = value
    ds_constraintEnd_toEndOf = value
  }

inline var View.ds_constraintVertical_alignOf: Int
  get() = -1
  set(value) {
    ds_constraintTop_toTopOf = value
    ds_constraintBottom_toBottomOf = value
  }

inline var View.ds_constraintHorizontal_bias: Float
  get() = 0f
  set(value) {
    layoutParams = layoutParams.append {
      horizontalBias = value
    }
  }

inline var View.ds_constraintVertical_bias: Float
  get() = 0f
  set(value) {
    layoutParams = layoutParams.append {
      verticalBias = value
    }
  }

inline var View.ds_constraintHorizontal_chainStyle: Int
  get() = 0
  set(value) {
    layoutParams = layoutParams.append {
      horizontalChainStyle = value
    }
  }

inline var View.ds_constraintVertical_chainStyle: Int
  get() = 0
  set(value) {
    layoutParams = layoutParams.append {
      verticalChainStyle = value
    }
  }

inline var Flow.ds_flow_horizontalGap: Int
  get() = 0
  set(value) {
    setHorizontalGap(value)
  }

inline var Flow.ds_flow_verticalGap: Int
  get() = 0
  set(value) {
    setVerticalGap(value)
  }

inline var Flow.ds_flow_wrapMode: Int
  get() = 0
  set(value) {
    setWrapMode(value)
  }
//endregion

//region LinearLayout extend field
inline var View.ds_linear_weight: Float
  get() = 0f
  set(value) {
    layoutParams = LinearLayout.LayoutParams(layoutParams.width, layoutParams.height).also {
      it.gravity = (layoutParams as? LinearLayout.LayoutParams)?.gravity ?: -1
      it.weight = value
    }
  }

inline var View.ds_linear_layout_gravity: Int
  get() = -1
  set(value) {
    layoutParams = LinearLayout.LayoutParams(layoutParams.width, layoutParams.height).also {
      it.weight = (layoutParams as? LinearLayout.LayoutParams)?.weight ?: 0f
      it.gravity = value
    }
  }
//endregion

//region RelativeLayout extend field
inline var View.ds_relative_alignParentStart: Boolean
  get() = false
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE)
    }
  }

inline var View.ds_relative_alignParentEnd: Boolean
  get() = false
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE)
    }
  }

inline var View.ds_relative_centerInParent: Boolean
  get() = false
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
    }
  }

inline var View.ds_relative_centerHorizontal: Boolean
  get() = false
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
    }
  }

inline var View.ds_relative_centerVertical: Boolean
  get() = false
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
    }
  }
//endregion

//region NestedScrollView extend field
@Suppress("UNUSED_PARAMETER")
inline var NestedScrollView.fadeScrollBar: Boolean
  get() = false
  set(value) {
    isScrollbarFadingEnabled = true
  }
//endregion

//region View layout constant
const val match_parent = ViewGroup.LayoutParams.MATCH_PARENT
const val wrap_content = ViewGroup.LayoutParams.WRAP_CONTENT

const val parent_id = ConstraintLayout.LayoutParams.PARENT_ID

const val chain_spread = ConstraintLayout.LayoutParams.CHAIN_SPREAD
const val chain_packed = ConstraintLayout.LayoutParams.CHAIN_PACKED
const val chain_spreadInside = ConstraintLayout.LayoutParams.CHAIN_SPREAD_INSIDE

val scale_fixXy = ImageView.ScaleType.FIT_XY
val scale_centerCrop = ImageView.ScaleType.CENTER_CROP
val scale_center = ImageView.ScaleType.CENTER
val scale_centerInside = ImageView.ScaleType.CENTER_INSIDE
val scale_fitCenter = ImageView.ScaleType.FIT_CENTER
val scale_fitEnd = ImageView.ScaleType.FIT_END
val scale_matrix = ImageView.ScaleType.MATRIX
val scale_fitStart = ImageView.ScaleType.FIT_START
//endregion

//region layout helper attribute
val Int.dp
  get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, this.toFloat(),
    Resources.getSystem().displayMetrics
  ).toInt()

val Float.dp
  get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, this,
    Resources.getSystem().displayMetrics
  )
//endregion

//region layout helper function
fun ViewGroup.MarginLayoutParams.toConstraintLayoutParam() =
  ConstraintLayout.LayoutParams(width, height).also {
    it.topMargin = this.topMargin
    it.bottomMargin = this.bottomMargin
    it.marginStart = this.marginStart
    it.marginEnd = this.marginEnd
  }

fun ViewGroup.LayoutParams.append(set: ConstraintLayout.LayoutParams.() -> Unit) =
  (this as? ConstraintLayout.LayoutParams)?.apply(set) ?: (this as? ViewGroup.MarginLayoutParams)?.toConstraintLayoutParam()?.apply(set)

fun String.toLayoutId(): Int {
  var id = java.lang.String(this).bytes.sum()
  if (id == 48) id = 0
  return id
}

fun <T : View> View.findView(id: Int): T? = findViewById(id)
fun <T : View> AppCompatActivity.findView(id: Int): T? = findViewById(id)

fun <T : View> View.find(id: String): T = findViewById(id.toLayoutId())

fun <T : View> AppCompatActivity.find(id: String): T = findViewById(id.toLayoutId())

fun RecyclerView.setOnItemClickListener(listener: (View, Int) -> Unit) {
  addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
    val gestureDetector = GestureDetector(context, object : GestureDetector.OnGestureListener {
      override fun onShowPress(e: MotionEvent?) {}

      override fun onSingleTapUp(e: MotionEvent?): Boolean {
        e?.let {
          findChildViewUnder(it.x, it.y)?.let { child ->
            listener(child, getChildAdapterPosition(child))
          }
        }
        return false
      }

      override fun onDown(e: MotionEvent?): Boolean {
        return false
      }

      override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        return false
      }

      override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        return false
      }

      override fun onLongPress(e: MotionEvent?) {}
    })

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
      gestureDetector.onTouchEvent(e)
      return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
  })
}
//endregion