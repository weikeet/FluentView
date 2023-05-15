package com.weikeet.ui.view.appcompat

import android.content.Context
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.AppCompatTextView
import com.weikeet.ui.view.wrapContextIfNeeded

//region textView
inline fun ViewGroup.textView(id: Int? = null, style: Int? = null, init: AppCompatTextView.() -> Unit): AppCompatTextView {
  val widget = AppCompatTextView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.textView(id: Int? = null, style: Int? = null, init: AppCompatTextView.() -> Unit): AppCompatTextView {
  val widget = AppCompatTextView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion


//region imageView
inline fun ViewGroup.imageView(id: Int? = null, style: Int? = null, init: AppCompatImageView.() -> Unit): AppCompatImageView {
  val widget = AppCompatImageView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.imageView(id: Int? = null, style: Int? = null, init: AppCompatImageView.() -> Unit): AppCompatImageView {
  val widget = AppCompatImageView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion


//region button
inline fun ViewGroup.button(id: Int? = null, style: Int? = null, init: AppCompatButton.() -> Unit): AppCompatButton {
  val widget = AppCompatButton(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.button(id: Int? = null, style: Int? = null, init: AppCompatButton.() -> Unit): AppCompatButton {
  val widget = AppCompatButton(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion


//region editText
inline fun ViewGroup.editText(id: Int? = null, style: Int? = null, init: AppCompatEditText.() -> Unit): AppCompatEditText {
  val widget = AppCompatEditText(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.editText(id: Int? = null, style: Int? = null, init: AppCompatEditText.() -> Unit): AppCompatEditText {
  val widget = AppCompatEditText(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion


//region spinner
inline fun ViewGroup.spinner(id: Int? = null, style: Int? = null, init: AppCompatSpinner.() -> Unit): AppCompatSpinner {
  val widget = AppCompatSpinner(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.spinner(id: Int? = null, style: Int? = null, init: AppCompatSpinner.() -> Unit): AppCompatSpinner {
  val widget = AppCompatSpinner(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion


//region imageButton
inline fun ViewGroup.imageButton(id: Int? = null, style: Int? = null, init: AppCompatImageButton.() -> Unit): AppCompatImageButton {
  val widget = AppCompatImageButton(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.imageButton(id: Int? = null, style: Int? = null, init: AppCompatImageButton.() -> Unit): AppCompatImageButton {
  val widget = AppCompatImageButton(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion


//region checkBox
inline fun ViewGroup.checkBox(id: Int? = null, style: Int? = null, init: AppCompatCheckBox.() -> Unit): AppCompatCheckBox {
  val widget = AppCompatCheckBox(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.checkBox(id: Int? = null, style: Int? = null, init: AppCompatCheckBox.() -> Unit): AppCompatCheckBox {
  val widget = AppCompatCheckBox(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion


//region radioButton
inline fun ViewGroup.radioButton(id: Int? = null, style: Int? = null, init: AppCompatRadioButton.() -> Unit): AppCompatRadioButton {
  val widget = AppCompatRadioButton(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.radioButton(id: Int? = null, style: Int? = null, init: AppCompatRadioButton.() -> Unit): AppCompatRadioButton {
  val widget = AppCompatRadioButton(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion


//region seekBar
inline fun ViewGroup.seekBar(id: Int? = null, style: Int? = null, init: AppCompatSeekBar.() -> Unit): AppCompatSeekBar {
  val widget = AppCompatSeekBar(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.seekBar(id: Int? = null, style: Int? = null, init: AppCompatSeekBar.() -> Unit): AppCompatSeekBar {
  val widget = AppCompatSeekBar(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion
