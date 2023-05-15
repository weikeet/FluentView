#!/usr/bin/env bash

function build_view() {
    fun_name=$1
    view_name=$2

    echo ""
    echo "//region $fun_name"
    echo "inline fun ViewGroup.$fun_name(id: Int? = null, style: Int? = null, init: $view_name.() -> Unit): $view_name {
  val widget = $view_name(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.$fun_name(id: Int? = null, style: Int? = null, init: $view_name.() -> Unit): $view_name {
  val widget = $view_name(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}"
    echo "//endregion"
    echo ""
}

function build_compat_view() {
    echo "package com.weikeet.ui.view.appcompat

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
import com.weikeet.ui.view.wrapContextIfNeeded"

    build_view textView AppCompatTextView
    build_view imageView AppCompatImageView
    build_view button AppCompatButton
    build_view editText AppCompatEditText
    build_view spinner AppCompatSpinner
    build_view imageButton AppCompatImageButton
    build_view checkBox AppCompatCheckBox
    build_view radioButton AppCompatRadioButton
    build_view seekBar AppCompatSeekBar
}

build_view_compat > AppCompatViews.kt