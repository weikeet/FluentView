package com.weiwei.fluent.widget.extensions

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * @author weiwei
 * @date 2021.07.27
 */

val View.attachActivity: Activity
  get() = context.let {
    var ctx: Context = it
    if (ctx is Activity) {
      ctx
    } else {
      while (ctx is ContextWrapper) {
        ctx = ctx.baseContext
      }
      if (ctx is Activity) {
        ctx
      } else {
        throw UnsupportedOperationException("View#getContext don't get Activity, $ctx")
      }
    }
  }

val View.compatActivity: AppCompatActivity
  get() = context.let {
    var ctx: Context = it
    if (ctx is AppCompatActivity) {
      ctx
    } else {
      while (ctx is ContextWrapper) {
        ctx = ctx.baseContext
      }
      if (ctx is AppCompatActivity) {
        ctx
      } else {
        throw UnsupportedOperationException("View#getContext don't get AppCompatActivity, $ctx")
      }
    }
  }
