package com.weikeet.ui.res

import android.content.Context
import android.view.View
import androidx.annotation.ArrayRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

//region StringResources with context
fun Context.stringResources(@StringRes id: Int): String =
  this.resources.getString(id)

fun Context.stringResources(@StringRes id: Int, vararg formatArgs: Any): String =
  this.resources.getString(id, *formatArgs)

fun Context.stringArrayResources(@ArrayRes id: Int): Array<String> =
  this.resources.getStringArray(id)

fun Context.pluralStringResources(@PluralsRes id: Int, count: Int): String =
  this.resources.getQuantityString(id, count)

fun Context.pluralStringResources(@PluralsRes id: Int, count: Int, vararg formatArgs: Any): String =
  this.resources.getQuantityString(id, count, *formatArgs)
//endregion

//region StringResources with fragment
fun Fragment.stringResources(@StringRes id: Int): String =
  this.resources.getString(id)

fun Fragment.stringResources(@StringRes id: Int, vararg formatArgs: Any): String =
  this.resources.getString(id, *formatArgs)

fun Fragment.stringArrayResources(@ArrayRes id: Int): Array<String> =
  this.resources.getStringArray(id)

fun Fragment.pluralStringResources(@PluralsRes id: Int, count: Int): String =
  this.resources.getQuantityString(id, count)

fun Fragment.pluralStringResources(@PluralsRes id: Int, count: Int, vararg formatArgs: Any): String =
  this.resources.getQuantityString(id, count, *formatArgs)
//endregion

//region StringResources with view
fun View.stringResources(@StringRes id: Int): String =
  this.resources.getString(id)

fun View.stringResources(@StringRes id: Int, vararg formatArgs: Any): String =
  this.resources.getString(id, *formatArgs)

fun View.stringArrayResources(@ArrayRes id: Int): Array<String> =
  this.resources.getStringArray(id)

fun View.pluralStringResources(@PluralsRes id: Int, count: Int): String =
  this.resources.getQuantityString(id, count)

fun View.pluralStringResources(@PluralsRes id: Int, count: Int, vararg formatArgs: Any): String =
  this.resources.getQuantityString(id, count, *formatArgs)
//endregion
