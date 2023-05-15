package com.weikeet.ui.view.constraint

import android.view.View
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.helper.widget.Layer
import androidx.constraintlayout.widget.Barrier
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import androidx.constraintlayout.widget.Guideline
import com.weikeet.ui.view.wrapContent

inline fun ConstraintLayout.guideline(id: Int, init: ConstraintLayout.LayoutParams.() -> Unit): Guideline {
  val guideline = Guideline(context)
  guideline.id = id
  guideline.layoutParams = ConstraintLayout.LayoutParams(wrapContent, wrapContent).apply(init)
  return guideline.also { addView(it) }
}

inline fun ConstraintLayout.flow(id: Int? = null, init: Flow.() -> Unit): Flow {
  val widget = Flow(context)
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it, wrapContent, wrapContent) }
}

inline fun ConstraintLayout.layer(id: Int? = null, init: Layer.() -> Unit): Layer {
  val widget = Layer(context)
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it, wrapContent, wrapContent) }
}

fun ConstraintLayout.group(ids: IntArray): Group {
  val widget = Group(context)
  widget.referencedIds = ids
  return widget.also { addView(it, wrapContent, wrapContent) }
}

fun ConstraintLayout.group(views: List<View>): Group {
  val widget = Group(context)
  widget.referencedIds = IntArray(views.size) { views[it].id }
  return widget.also { addView(it, wrapContent, wrapContent) }
}

fun ConstraintLayout.barrier(type: BarrierType, ids: IntArray): Barrier {
  val widget = Barrier(context)
  widget.type = type.intValue
  widget.referencedIds = ids
  return widget.also { addView(it, wrapContent, wrapContent) }
}

fun ConstraintLayout.barrier(type: BarrierType, views: List<View>): Barrier {
  val widget = Barrier(context)
  widget.type = type.intValue
  widget.referencedIds = IntArray(views.size) { views[it].id }
  return widget.also { addView(it, wrapContent, wrapContent) }
}

@JvmInline
value class BarrierType @PublishedApi internal constructor(internal val intValue: Int) {
  companion object {
    inline val START get() = BarrierType(Barrier.START)
    inline val LEFT get() = BarrierType(Barrier.LEFT)
    inline val TOP get() = BarrierType(Barrier.TOP)
    inline val END get() = BarrierType(Barrier.END)
    inline val RIGHT get() = BarrierType(Barrier.RIGHT)
    inline val BOTTOM get() = BarrierType(Barrier.BOTTOM)
  }
}
