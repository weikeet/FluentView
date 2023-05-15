package com.weikeet.ui.graphics.drawable

import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.util.StateSet
import com.weikeet.ui.annotation.NO_GETTER
import com.weikeet.ui.annotation.noGetter

/**
 * @author weiwei
 *
 * @date 2021.09.21
 */

object ViewStates {
  fun enabled() = intArrayOf(android.R.attr.state_enabled)
  fun disabled() = intArrayOf(-android.R.attr.state_enabled)

  fun selected() = intArrayOf(android.R.attr.state_selected)
  fun unselected() = intArrayOf(-android.R.attr.state_selected)

  fun pressed() = intArrayOf(android.R.attr.state_pressed)
  fun unpressed() = intArrayOf(-android.R.attr.state_pressed)

  fun checked() = intArrayOf(android.R.attr.state_checked)
  fun unchecked() = intArrayOf(-android.R.attr.state_checked)
}

inline fun stateListDrawable(block: StateListDrawable.() -> Unit): StateListDrawable = StateListDrawable().also(block)

inline fun StateListDrawable.state(state: IntArray, block: () -> Drawable): Unit = addState(state, block())

inline fun StateListDrawable.enableState(block: () -> Drawable): Unit = state(ViewStates.enabled(), block)
inline fun StateListDrawable.disableState(block: () -> Drawable): Unit = state(ViewStates.disabled(), block)

inline fun StateListDrawable.selectedState(block: () -> Drawable): Unit = state(ViewStates.selected(), block)
inline fun StateListDrawable.unselectedState(block: () -> Drawable): Unit = state(ViewStates.unselected(), block)

inline fun StateListDrawable.pressedState(block: () -> Drawable): Unit = state(ViewStates.pressed(), block)
inline fun StateListDrawable.unpressedState(block: () -> Drawable): Unit = state(ViewStates.unpressed(), block)

inline fun StateListDrawable.checkedState(block: () -> Drawable): Unit = state(ViewStates.checked(), block)
inline fun StateListDrawable.uncheckedState(block: () -> Drawable): Unit = state(ViewStates.unchecked(), block)

inline fun StateListDrawable.defaultState(block: () -> Drawable): Unit = state(StateSet.WILD_CARD, block)

var StateListDrawable.exitFadeDuration: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(value) = setExitFadeDuration(value)
