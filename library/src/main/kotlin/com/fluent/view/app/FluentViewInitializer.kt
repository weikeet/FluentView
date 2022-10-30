package com.fluent.view.app

import android.annotation.SuppressLint
import android.content.Context
import androidx.startup.Initializer

@SuppressLint("StaticFieldLeak")
internal lateinit var mainContext: Context
  private set

class FluentViewInitializer : Initializer<Unit> {
  companion object {
    @JvmStatic
    fun initialize(context: Context) {
      mainContext = context
    }
  }

  override fun create(context: Context) {
    mainContext = context
  }

  override fun dependencies(): MutableList<Class<out Initializer<*>>> = arrayListOf()
}