package com.weikeet.ui.res

import android.content.Context
import android.graphics.Typeface
import android.view.View
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment

fun Context.fontResources(@FontRes fontId: Int): Typeface? =
  ResourcesCompat.getFont(this, fontId)

fun Fragment.fontResources(@FontRes fontId: Int): Typeface? =
  ResourcesCompat.getFont(this.requireContext(), fontId)

fun View.fontResources(@FontRes fontId: Int): Typeface? =
  ResourcesCompat.getFont(this.context, fontId)
