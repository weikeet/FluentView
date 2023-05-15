package com.weikeet.ui.res

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Context.drawableResources(@DrawableRes drawableId: Int): Drawable? =
  ContextCompat.getDrawable(this, drawableId)

fun Fragment.drawableResources(@DrawableRes drawableId: Int): Drawable? =
  ContextCompat.getDrawable(this.requireContext(), drawableId)

fun View.drawableResources(@DrawableRes drawableId: Int): Drawable? =
  ContextCompat.getDrawable(this.context, drawableId)
