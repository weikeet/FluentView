package com.weikeet.ui.res

import android.content.Context
import android.view.View
import androidx.annotation.DimenRes
import androidx.fragment.app.Fragment

//region DimenResources with context
fun Context.dimenResources(@DimenRes dimenId: Int): Float =
  this.resources.getDimension(dimenId)

fun Context.dimenSizeResources(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelSize(dimenId)

fun Context.dimenOffsetResources(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelOffset(dimenId)
//endregion

//region DimenResources with fragment
fun Fragment.dimenResources(@DimenRes dimenId: Int): Float =
  this.resources.getDimension(dimenId)

fun Fragment.dimenSizeResources(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelSize(dimenId)

fun Fragment.dimenOffsetResources(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelOffset(dimenId)
//endregion

//region DimenResources with view
fun View.dimenResources(@DimenRes dimenId: Int): Float =
  this.resources.getDimension(dimenId)

fun View.dimenSizeResources(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelSize(dimenId)

fun View.dimenOffsetResources(@DimenRes dimenId: Int): Int =
  this.resources.getDimensionPixelOffset(dimenId)
//endregion
