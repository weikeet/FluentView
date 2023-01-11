package com.weiwei.fluentview.view.material

import android.content.Context
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.weiwei.fluentview.view.wrapContextIfNeeded

//region materialButton
inline fun ViewGroup.materialButton(id: Int? = null, style: Int? = null, init: MaterialButton.() -> Unit): MaterialButton {
  val widget = MaterialButton(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.materialButton(id: Int? = null, style: Int? = null, init: MaterialButton.() -> Unit): MaterialButton {
  val widget = MaterialButton(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region materialCheckBox
inline fun ViewGroup.materialCheckBox(id: Int? = null, style: Int? = null, init: MaterialCheckBox.() -> Unit): MaterialCheckBox {
  val widget = MaterialCheckBox(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.materialCheckBox(id: Int? = null, style: Int? = null, init: MaterialCheckBox.() -> Unit): MaterialCheckBox {
  val widget = MaterialCheckBox(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region shapeableImageView
inline fun ViewGroup.shapeableImageView(id: Int? = null, style: Int? = null, init: ShapeableImageView.() -> Unit): ShapeableImageView {
  val widget = ShapeableImageView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.shapeableImageView(id: Int? = null, style: Int? = null, init: ShapeableImageView.() -> Unit): ShapeableImageView {
  val widget = ShapeableImageView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region textInputEditText
inline fun ViewGroup.textInputEditText(id: Int? = null, style: Int? = null, init: TextInputEditText.() -> Unit): TextInputEditText {
  val widget = TextInputEditText(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.textInputEditText(id: Int? = null, style: Int? = null, init: TextInputEditText.() -> Unit): TextInputEditText {
  val widget = TextInputEditText(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region materialTextView
inline fun ViewGroup.materialTextView(id: Int? = null, style: Int? = null, init: MaterialTextView.() -> Unit): MaterialTextView {
  val widget = MaterialTextView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.materialTextView(id: Int? = null, style: Int? = null, init: MaterialTextView.() -> Unit): MaterialTextView {
  val widget = MaterialTextView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion
