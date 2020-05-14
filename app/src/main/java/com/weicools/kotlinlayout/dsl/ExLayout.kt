@file:Suppress("unused", "FunctionName")

package com.weicools.kotlinlayout.dsl

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.util.TypedValue
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.helper.widget.Layer
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintProperties
import androidx.constraintlayout.widget.Guideline
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.MarginLayoutParamsCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

//<editor-fold desc="ViewGroup widget creation function">
inline fun ViewGroup.View(init: View.() -> Unit) =
  View(context).apply(init).also { addView(it) }

inline fun ViewGroup.TextView(init: AppCompatTextView.() -> Unit) =
  AppCompatTextView(context).apply(init).also { addView(it) }

inline fun ViewGroup.ImageView(init: AppCompatImageView.() -> Unit) =
  AppCompatImageView(context).apply(init).also { addView(it) }

inline fun ViewGroup.Button(init: Button.() -> Unit) =
  AppCompatButton(context).apply(init).also { addView(it) }

inline fun ViewGroup.EditText(init: EditText.() -> Unit) =
  EditText(context).apply(init).also { addView(it) }

inline fun ConstraintLayout.Guideline(init: Guideline.() -> Unit) =
  Guideline(context).apply(init).also { addView(it) }

inline fun ConstraintLayout.Flow(init: Flow.() -> Unit) =
  Flow(context).apply(init).also { addView(it) }

inline fun ConstraintLayout.Layer(init: Layer.() -> Unit) =
  Layer(context).apply(init).also { addView(it) }

inline fun ViewGroup.ConstraintLayout(init: ConstraintLayout.() -> Unit) =
  ConstraintLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.LinearLayout(init: LinearLayout.() -> Unit) =
  LinearLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.FrameLayout(init: FrameLayout.() -> Unit) =
  FrameLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.RelativeLayout(init: RelativeLayout.() -> Unit) =
  RelativeLayout(context).apply(init).also { addView(it) }

inline fun ViewGroup.NestedScrollView(init: NestedScrollView.() -> Unit) =
  NestedScrollView(context).apply(init).also { addView(it) }

inline fun ViewGroup.RecyclerView(init: RecyclerView.() -> Unit) =
  RecyclerView(context).apply(init).also { addView(it) }
//</editor-fold>

//<editor-fold desc="Context widget creation function">
inline fun Context.View(init: View.() -> Unit) =
  View(this).apply(init)

inline fun Context.TextView(init: TextView.() -> Unit) =
  AppCompatTextView(this).apply(init)

inline fun Context.ImageView(init: ImageView.() -> Unit) =
  AppCompatImageView(this).apply(init)

inline fun Context.Button(init: Button.() -> Unit) =
  AppCompatButton(this).apply(init)

inline fun Context.ConstraintLayout(init: ConstraintLayout.() -> Unit) =
  ConstraintLayout(this).apply(init)

inline fun Context.LinearLayout(init: LinearLayout.() -> Unit) =
  LinearLayout(this).apply(init)

inline fun Context.FrameLayout(init: FrameLayout.() -> Unit) =
  FrameLayout(this).apply(init)

inline fun Context.RelativeLayout(init: RelativeLayout.() -> Unit) =
  RelativeLayout(this).apply(init)

inline fun Context.NestedScrollView(init: NestedScrollView.() -> Unit) =
  NestedScrollView(this).apply(init)

inline fun Context.RecyclerView(init: RecyclerView.() -> Unit) =
  RecyclerView(this).apply(init)
//</editor-fold>

//<editor-fold desc="Fragment widget creation function">
inline fun Fragment.View(init: View.() -> Unit) =
  context?.let { View(it).apply(init) }

inline fun Fragment.TextView(init: TextView.() -> Unit) =
  AppCompatTextView(context).apply(init)

inline fun Fragment.ImageView(init: ImageView.() -> Unit) =
  AppCompatImageView(context).apply(init)

inline fun Fragment.Button(init: Button.() -> Unit) =
  AppCompatButton(context).apply(init)

inline fun Fragment.ConstraintLayout(init: ConstraintLayout.() -> Unit) =
  ConstraintLayout(context).apply(init)

inline fun Fragment.LinearLayout(init: LinearLayout.() -> Unit) =
  LinearLayout(context).apply(init)

inline fun Fragment.FrameLayout(init: FrameLayout.() -> Unit) =
  context?.let { FrameLayout(it).apply(init) }

inline fun Fragment.RelativeLayout(init: RelativeLayout.() -> Unit) =
  RelativeLayout(context).apply(init)

inline fun Fragment.NestedScrollView(init: NestedScrollView.() -> Unit) =
  context?.let { NestedScrollView(it).apply(init) }

inline fun Fragment.RecyclerView(init: RecyclerView.() -> Unit) =
  context?.let { RecyclerView(it).apply(init) }
//</editor-fold>

//<editor-fold desc="View extend field">
inline var View.layout_ids: String
  get() {
    return ""
  }
  set(value) {
    id = value.toLayoutId()
    Log.d("View.layout_id", "toLayoutId value=${value}, id=${id}")
  }

inline var View.layout_width: Int
  get() {
    return 0
  }
  set(value) {
    val h = layoutParams?.height ?: 0
    layoutParams = ViewGroup.MarginLayoutParams(value, h)
  }

inline var View.layout_height: Int
  get() {
    return 0
  }
  set(value) {
    val w = layoutParams?.width ?: 0
    layoutParams = ViewGroup.MarginLayoutParams(w, value)
  }

inline var View.padding_top: Int
  get() {
    return 0
  }
  set(value) {
    setPadding(paddingLeft, value, paddingRight, paddingBottom)
  }

inline var View.padding_bottom: Int
  get() {
    return 0
  }
  set(value) {
    setPadding(paddingLeft, paddingTop, paddingRight, value)
  }

inline var View.padding_start: Int
  get() {
    return 0
  }
  set(value) {
    setPadding(value, paddingTop, paddingRight, paddingBottom)
  }

inline var View.padding_end: Int
  get() {
    return 0
  }
  set(value) {
    setPadding(paddingLeft, paddingTop, value, paddingBottom)
  }

inline var View.padding: Int
  get() {
    return 0
  }
  set(value) {
    setPadding(value, value, value, value)
  }

inline var View.margin_top: Int
  get() {
    return -1
  }
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      topMargin = value
    }
  }

inline var View.margin_bottom: Int
  get() {
    return -1
  }
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      bottomMargin = value
    }
  }

inline var View.margin_start: Int
  get() {
    return -1
  }
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      MarginLayoutParamsCompat.setMarginStart(this, value)
    }
  }

inline var View.margin_end: Int
  get() {
    return -1
  }
  set(value) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
      MarginLayoutParamsCompat.setMarginEnd(this, value)
    }
  }

inline var View.background_res: Int
  get() {
    return -1
  }
  set(value) {
    setBackgroundResource(value)
  }

inline var View.background_color: String
  get() {
    return ""
  }
  set(value) {
    setBackgroundColor(Color.parseColor(value))
  }
//</editor-fold>

//<editor-fold desc="TextView extend field">
inline var TextView.textRes: Int
  get() {
    return -1
  }
  set(value) = setText(value)

inline var TextView.textColor: String
  get() {
    return ""
  }
  set(value) {
    setTextColor(Color.parseColor(value))
  }

inline var TextView.textColorRes: Int
  get() {
    return -1
  }
  set(value) {
    setTextColor(ContextCompat.getColor(context, value))
  }

inline var TextView.textSizeDp: Float
  get() {
    return 0f
  }
  set(value) {
    setTextSize(TypedValue.COMPLEX_UNIT_DIP, value)
  }

inline var TextView.textStyle: Int
  get() {
    return -1
  }
  set(value) = setTypeface(typeface, value)

inline var TextView.fontFamily: Int
  get() {
    return 0
  }
  set(value) {
    typeface = ResourcesCompat.getFont(context, value)
  }

inline var TextView.labelForIds: String
  get() {
    return ""
  }
  set(value) {
    labelFor = value.toLayoutId()
  }

inline var TextView.textEms: Int
  get() {
    return -1
  }
  set(value) = setEms(value)
//</editor-fold>

//<editor-fold desc="ImageView extend field">
inline var ImageView.src: Int
  get() {
    return -1
  }
  set(value) {
    setImageResource(value)
  }

inline var ImageView.srcCompat: Int
  get() {
    return -1
  }
  set(value) {
    setImageDrawable(AppCompatResources.getDrawable(context, value))
  }
//</editor-fold>

//<editor-fold desc="ConstrainLayout extend field">
inline var View.top_toTopOfId: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      topToTop = value
      topToBottom = -1
    }
  }

inline var View.top_toTopOfIds: String
  get() {
    return ""
  }
  set(value) {
    layoutParams = layoutParams.append {
      topToTop = value.toLayoutId()
      topToBottom = -1
    }
  }

inline var View.top_toBottomOfId: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      topToBottom = value
      topToTop = -1
    }
  }

inline var View.top_toBottomOfIds: String
  get() {
    return ""
  }
  set(value) {
    layoutParams = layoutParams.append {
      topToBottom = value.toLayoutId()
      topToTop = -1
    }
  }

inline var View.bottom_toBottomOfId: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      bottomToBottom = value
      bottomToTop = -1
    }
  }

inline var View.bottom_toBottomOfIds: String
  get() {
    return ""
  }
  set(value) {
    layoutParams = layoutParams.append {
      bottomToBottom = value.toLayoutId()
      bottomToTop = -1
    }
  }

inline var View.bottom_toTopOfId: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      bottomToTop = value
      bottomToBottom = -1
    }
  }

inline var View.bottom_toTopOfIds: String
  get() {
    return ""
  }
  set(value) {
    layoutParams = layoutParams.append {
      bottomToTop = value.toLayoutId()
      bottomToBottom = -1
    }
  }

inline var View.start_toStartOfId: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      startToStart = value
      startToEnd = -1
    }
  }

inline var View.start_toStartOfIds: String
  get() {
    return ""
  }
  set(value) {
    layoutParams = layoutParams.append {
      startToStart = value.toLayoutId()
      startToEnd = -1
    }
  }

inline var View.start_toEndOfId: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      startToEnd = value
      startToStart = -1
    }
  }

inline var View.start_toEndOfIds: String
  get() {
    return ""
  }
  set(value) {
    layoutParams = layoutParams.append {
      startToEnd = value.toLayoutId()
      startToStart = -1
    }
  }

inline var View.end_toEndOfId: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      endToEnd = value
      endToStart = -1
    }
  }

inline var View.end_toEndOfIds: String
  get() {
    return ""
  }
  set(value) {
    layoutParams = layoutParams.append {
      endToEnd = value.toLayoutId()
      endToStart = -1
    }
  }

inline var View.end_toStartOfId: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      endToStart = value
      endToEnd = -1
    }
  }

inline var View.end_toStartOfIds: String
  get() {
    return ""
  }
  set(value) {
    layoutParams = layoutParams.append {
      endToStart = value.toLayoutId()
      endToEnd = -1
    }
  }

inline var View.baseline_toBaselineOfId: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = layoutParams.append {
      baselineToBaseline = value
    }
  }

inline var View.baseline_toBaselineOfIds: String
  get() {
    return ""
  }
  set(value) {
    layoutParams = layoutParams.append {
      baselineToBaseline = value.toLayoutId()
    }
  }

inline var View.align_horizontal_toId: Int
  get() {
    return -1
  }
  set(value) {
    start_toStartOfId = value
    end_toEndOfId = value
  }

inline var View.align_horizontal_toIds: String
  get() {
    return ""
  }
  set(value) {
    start_toStartOfIds = value
    end_toEndOfIds = value
  }

inline var View.align_vertical_toId: Int
  get() {
    return -1
  }
  set(value) {
    top_toTopOfId = value
    bottom_toBottomOfId = value
  }

inline var View.align_vertical_toIds: String
  get() {
    return ""
  }
  set(value) {
    top_toTopOfIds = value
    bottom_toBottomOfIds = value
  }

inline var View.constraint_centerInParent: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    start_toStartOfIds = parent_ids
    end_toEndOfIds = parent_ids
    top_toTopOfIds = parent_ids
    bottom_toBottomOfIds = parent_ids
  }

inline var View.constraint_centerHorizontal: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    start_toStartOfIds = parent_ids
    end_toEndOfIds = parent_ids
  }

inline var View.constraint_centerVertical: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    top_toTopOfIds = parent_ids
    bottom_toBottomOfIds = parent_ids
  }

inline var View.horizontal_bias: Float
  get() {
    return 0f
  }
  set(value) {
    layoutParams = layoutParams.append {
      horizontalBias = value
    }
  }

inline var View.vertical_bias: Float
  get() {
    return 0f
  }
  set(value) {
    layoutParams = layoutParams.append {
      verticalBias = value
    }
  }

inline var View.horizontal_chain_style: Int
  get() {
    return 0
  }
  set(value) {
    layoutParams = layoutParams.append {
      horizontalChainStyle = value
    }
  }

inline var View.vertical_chain_style: Int
  get() {
    return 0
  }
  set(value) {
    layoutParams = layoutParams.append {
      verticalChainStyle = value
    }
  }

inline var ConstraintHelper.referencedIdStr: String
  get() {
    return ""
  }
  set(value) {
    referencedIds = value.split(",").map { it.toLayoutId() }.toIntArray()
  }

inline var Flow.flow_horizontalGap: Int
  get() {
    return 0
  }
  set(value) {
    setHorizontalGap(value)
  }

inline var Flow.flow_verticalGap: Int
  get() {
    return 0
  }
  set(value) {
    setVerticalGap(value)
  }

inline var Flow.flow_wrapMode: Int
  get() {
    return 0
  }
  set(value) {
    setWrapMode(value)
  }
//</editor-fold>

//<editor-fold desc="LinearLayout extend field">
inline var View.weight: Float
  get() {
    return 0f
  }
  set(value) {
    layoutParams = LinearLayout.LayoutParams(layoutParams.width, layoutParams.height).also {
      it.gravity = (layoutParams as? LinearLayout.LayoutParams)?.gravity ?: -1
      it.weight = value
    }
  }

inline var View.layout_gravity: Int
  get() {
    return -1
  }
  set(value) {
    layoutParams = LinearLayout.LayoutParams(layoutParams.width, layoutParams.height).also {
      it.weight = (layoutParams as? LinearLayout.LayoutParams)?.weight ?: 0f
      it.gravity = value
    }
  }
//</editor-fold>

//<editor-fold desc="RelativeLayout extend field">
inline var View.alignParentStart: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE)
    }
  }

inline var View.alignParentEnd: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE)
    }
  }

inline var View.relative_centerInParent: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
    }
  }

inline var View.relative_centerHorizontal: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
    }
  }

inline var View.relative_centerVertical: Boolean
  get() {
    return false
  }
  set(value) {
    if (!value) return
    layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
      (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
        addRule(index, i)
      }
      addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
    }
  }
//</editor-fold>

//<editor-fold desc="NestedScrollView extend field">
@Suppress("UNUSED_PARAMETER")
inline var NestedScrollView.fadeScrollBar: Boolean
  get() {
    return false
  }
  set(value) {
    isScrollbarFadingEnabled = true
  }
//</editor-fold>

//<editor-fold desc="Click extend field">
var View.onClick: (View) -> Unit
  get() {
    return {}
  }
  set(value) {
    setOnClickListener { v -> value(v) }
  }

var RecyclerView.onItemClick: (View, Int) -> Unit
  get() {
    return { _, _ -> }
  }
  set(value) {
    setOnItemClickListener(value)
  }
//</editor-fold>

//<editor-fold desc="View layout constant">
const val match_parent = ViewGroup.LayoutParams.MATCH_PARENT
const val wrap_content = ViewGroup.LayoutParams.WRAP_CONTENT

const val horizontal = LinearLayout.HORIZONTAL
const val vertical = LinearLayout.VERTICAL

const val bold = Typeface.BOLD
const val normal = Typeface.NORMAL
const val italic = Typeface.ITALIC
const val bold_italic = Typeface.BOLD_ITALIC

const val gravity_start = Gravity.START
const val gravity_end = Gravity.END
const val gravity_top = Gravity.TOP
const val gravity_bottom = Gravity.BOTTOM
const val gravity_center = Gravity.CENTER
const val gravity_center_horizontal = Gravity.CENTER_HORIZONTAL
const val gravity_center_vertical = Gravity.CENTER_VERTICAL

val scale_fix_xy = ImageView.ScaleType.FIT_XY
val scale_center_crop = ImageView.ScaleType.CENTER_CROP
val scale_center = ImageView.ScaleType.CENTER
val scale_center_inside = ImageView.ScaleType.CENTER_INSIDE
val scale_fit_center = ImageView.ScaleType.FIT_CENTER
val scale_fit_end = ImageView.ScaleType.FIT_END
val scale_matrix = ImageView.ScaleType.MATRIX
val scale_fit_start = ImageView.ScaleType.FIT_START

const val constraint_start = ConstraintProperties.START
const val constraint_end = ConstraintProperties.END
const val constraint_top = ConstraintProperties.TOP
const val constraint_bottom = ConstraintProperties.BOTTOM
const val constraint_baseline = ConstraintProperties.BASELINE
const val constraint_parent = ConstraintProperties.PARENT_ID

const val spread = ConstraintLayout.LayoutParams.CHAIN_SPREAD
const val packed = ConstraintLayout.LayoutParams.CHAIN_PACKED
const val spread_inside = ConstraintLayout.LayoutParams.CHAIN_SPREAD_INSIDE

const val wrap_none = Flow.WRAP_NONE
const val wrap_chain = Flow.WRAP_CHAIN
const val wrap_aligned = Flow.WRAP_ALIGNED

const val parent_id = ConstraintLayout.LayoutParams.PARENT_ID
const val parent_ids = "0"
//</editor-fold>

//<editor-fold desc="layout helper function">
fun Int.dp(): Int =
  TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, this.toFloat(),
    Resources.getSystem().displayMetrics
  ).toInt()

fun Float.dp(): Float =
  TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, this,
    Resources.getSystem().displayMetrics
  )

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
//</editor-fold>