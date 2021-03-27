@file:Suppress("unused", "FunctionName")

package com.weicools.kotlinlayout.dsl

// //<editor-fold desc="View extend field">
// inline var View.layout_ids: String
//   get() {
//     return ""
//   }
//   set(value) {
//     id = value.toLayoutId()
//     Log.d("View.layout_id", "toLayoutId value=${value}, id=${id}")
//   }
//
// inline var View.layout_width: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     val h = layoutParams?.height ?: 0
//     layoutParams = ViewGroup.MarginLayoutParams(value, h)
//   }
//
// inline var View.layout_height: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     val w = layoutParams?.width ?: 0
//     layoutParams = ViewGroup.MarginLayoutParams(w, value)
//   }
//
// inline var View.padding_top: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     setPadding(paddingLeft, value, paddingRight, paddingBottom)
//   }
//
// inline var View.padding_bottom: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     setPadding(paddingLeft, paddingTop, paddingRight, value)
//   }
//
// inline var View.padding_start: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     setPadding(value, paddingTop, paddingRight, paddingBottom)
//   }
//
// inline var View.padding_end: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     setPadding(paddingLeft, paddingTop, value, paddingBottom)
//   }
//
// inline var View.padding: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     setPadding(value, value, value, value)
//   }
//
// inline var View.margin_top: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
//       topMargin = value
//     }
//   }
//
// inline var View.margin_bottom: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
//       bottomMargin = value
//     }
//   }
//
// inline var View.margin_start: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
//       MarginLayoutParamsCompat.setMarginStart(this, value)
//     }
//   }
//
// inline var View.margin_end: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
//       MarginLayoutParamsCompat.setMarginEnd(this, value)
//     }
//   }
//
// inline var View.background_res: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     setBackgroundResource(value)
//   }
//
// inline var View.background_colorRes: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     setBackgroundColor(ContextCompat.getColor(context, value))
//   }
//
// inline var View.background_color: String
//   get() {
//     return ""
//   }
//   set(value) {
//     setBackgroundColor(Color.parseColor(value))
//   }
// //</editor-fold>
//
// //<editor-fold desc="TextView extend field">
// inline var TextView.textRes: Int
//   get() {
//     return -1
//   }
//   set(value) = setText(value)
//
// inline var TextView.textColorRes: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     setTextColor(ContextCompat.getColor(context, value))
//   }
//
// inline var TextView.textColor: String
//   get() {
//     return ""
//   }
//   set(value) {
//     setTextColor(Color.parseColor(value))
//   }
//
// inline var TextView.textSizeDp: Float
//   get() {
//     return 0f
//   }
//   set(value) {
//     setTextSize(TypedValue.COMPLEX_UNIT_DIP, value)
//   }
//
// inline var TextView.textStyle: Int
//   get() {
//     return -1
//   }
//   set(value) = setTypeface(typeface, value)
//
// inline var TextView.fontFamily: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     typeface = ResourcesCompat.getFont(context, value)
//   }
//
// inline var TextView.labelForIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     labelFor = value.toLayoutId()
//   }
//
// inline var TextView.textEms: Int
//   get() {
//     return -1
//   }
//   set(value) = setEms(value)
// //</editor-fold>
//
// //<editor-fold desc="ImageView extend field">
// inline var ImageView.srcCompat: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     setImageDrawable(AppCompatResources.getDrawable(context, value))
//   }
// //</editor-fold>
//
// //<editor-fold desc="ConstrainLayout extend field">
// inline var View.top_toTopOfId: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       topToTop = value
//       topToBottom = -1
//     }
//   }
//
// inline var View.top_toTopOfIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       topToTop = value.toLayoutId()
//       topToBottom = -1
//     }
//   }
//
// inline var View.top_toBottomOfId: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       topToBottom = value
//       topToTop = -1
//     }
//   }
//
// inline var View.top_toBottomOfIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       topToBottom = value.toLayoutId()
//       topToTop = -1
//     }
//   }
//
// inline var View.bottom_toBottomOfId: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       bottomToBottom = value
//       bottomToTop = -1
//     }
//   }
//
// inline var View.bottom_toBottomOfIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       bottomToBottom = value.toLayoutId()
//       bottomToTop = -1
//     }
//   }
//
// inline var View.bottom_toTopOfId: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       bottomToTop = value
//       bottomToBottom = -1
//     }
//   }
//
// inline var View.bottom_toTopOfIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       bottomToTop = value.toLayoutId()
//       bottomToBottom = -1
//     }
//   }
//
// inline var View.start_toStartOfId: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       startToStart = value
//       startToEnd = -1
//     }
//   }
//
// inline var View.start_toStartOfIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       startToStart = value.toLayoutId()
//       startToEnd = -1
//     }
//   }
//
// inline var View.start_toEndOfId: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       startToEnd = value
//       startToStart = -1
//     }
//   }
//
// inline var View.start_toEndOfIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       startToEnd = value.toLayoutId()
//       startToStart = -1
//     }
//   }
//
// inline var View.end_toEndOfId: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       endToEnd = value
//       endToStart = -1
//     }
//   }
//
// inline var View.end_toEndOfIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       endToEnd = value.toLayoutId()
//       endToStart = -1
//     }
//   }
//
// inline var View.end_toStartOfId: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       endToStart = value
//       endToEnd = -1
//     }
//   }
//
// inline var View.end_toStartOfIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       endToStart = value.toLayoutId()
//       endToEnd = -1
//     }
//   }
//
// inline var View.baseline_toBaselineOfId: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       baselineToBaseline = value
//     }
//   }
//
// inline var View.baseline_toBaselineOfIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       baselineToBaseline = value.toLayoutId()
//     }
//   }
//
// inline var View.align_horizontal_toId: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     start_toStartOfId = value
//     end_toEndOfId = value
//   }
//
// inline var View.align_horizontal_toIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     start_toStartOfIds = value
//     end_toEndOfIds = value
//   }
//
// inline var View.align_vertical_toId: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     top_toTopOfId = value
//     bottom_toBottomOfId = value
//   }
//
// inline var View.align_vertical_toIds: String
//   get() {
//     return ""
//   }
//   set(value) {
//     top_toTopOfIds = value
//     bottom_toBottomOfIds = value
//   }
//
// inline var View.constraint_centerInParent: Boolean
//   get() {
//     return false
//   }
//   set(value) {
//     if (!value) return
//     start_toStartOfIds = parent_ids
//     end_toEndOfIds = parent_ids
//     top_toTopOfIds = parent_ids
//     bottom_toBottomOfIds = parent_ids
//   }
//
// inline var View.constraint_centerHorizontal: Boolean
//   get() {
//     return false
//   }
//   set(value) {
//     if (!value) return
//     start_toStartOfIds = parent_ids
//     end_toEndOfIds = parent_ids
//   }
//
// inline var View.constraint_centerVertical: Boolean
//   get() {
//     return false
//   }
//   set(value) {
//     if (!value) return
//     top_toTopOfIds = parent_ids
//     bottom_toBottomOfIds = parent_ids
//   }
//
// inline var View.horizontal_bias: Float
//   get() {
//     return 0f
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       horizontalBias = value
//     }
//   }
//
// inline var View.vertical_bias: Float
//   get() {
//     return 0f
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       verticalBias = value
//     }
//   }
//
// inline var View.horizontal_chain_style: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       horizontalChainStyle = value
//     }
//   }
//
// inline var View.vertical_chain_style: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     layoutParams = layoutParams.append {
//       verticalChainStyle = value
//     }
//   }
//
// inline var ConstraintHelper.referencedIdStr: String
//   get() {
//     return ""
//   }
//   set(value) {
//     referencedIds = value.split(",").map { it.toLayoutId() }.toIntArray()
//   }
//
// inline var Flow.flow_horizontalGap: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     setHorizontalGap(value)
//   }
//
// inline var Flow.flow_verticalGap: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     setVerticalGap(value)
//   }
//
// inline var Flow.flow_wrapMode: Int
//   get() {
//     return 0
//   }
//   set(value) {
//     setWrapMode(value)
//   }
// //</editor-fold>
//
// //<editor-fold desc="LinearLayout extend field">
// inline var View.weight: Float
//   get() {
//     return 0f
//   }
//   set(value) {
//     layoutParams = LinearLayout.LayoutParams(layoutParams.width, layoutParams.height).also {
//       it.gravity = (layoutParams as? LinearLayout.LayoutParams)?.gravity ?: -1
//       it.weight = value
//     }
//   }
//
// inline var View.linear_layout_gravity: Int
//   get() {
//     return -1
//   }
//   set(value) {
//     layoutParams = LinearLayout.LayoutParams(layoutParams.width, layoutParams.height).also {
//       it.weight = (layoutParams as? LinearLayout.LayoutParams)?.weight ?: 0f
//       it.gravity = value
//     }
//   }
// //</editor-fold>
//
// //<editor-fold desc="RelativeLayout extend field">
// inline var View.alignParentStart: Boolean
//   get() {
//     return false
//   }
//   set(value) {
//     if (!value) return
//     layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
//       (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
//         addRule(index, i)
//       }
//       addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE)
//     }
//   }
//
// inline var View.alignParentEnd: Boolean
//   get() {
//     return false
//   }
//   set(value) {
//     if (!value) return
//     layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
//       (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
//         addRule(index, i)
//       }
//       addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE)
//     }
//   }
//
// inline var View.relative_centerInParent: Boolean
//   get() {
//     return false
//   }
//   set(value) {
//     if (!value) return
//     layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
//       (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
//         addRule(index, i)
//       }
//       addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
//     }
//   }
//
// inline var View.relative_centerHorizontal: Boolean
//   get() {
//     return false
//   }
//   set(value) {
//     if (!value) return
//     layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
//       (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
//         addRule(index, i)
//       }
//       addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
//     }
//   }
//
// inline var View.relative_centerVertical: Boolean
//   get() {
//     return false
//   }
//   set(value) {
//     if (!value) return
//     layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
//       (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
//         addRule(index, i)
//       }
//       addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
//     }
//   }
// //</editor-fold>