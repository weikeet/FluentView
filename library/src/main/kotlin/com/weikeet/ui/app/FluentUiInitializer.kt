package com.weikeet.ui.app

import android.annotation.SuppressLint
import android.content.Context
import androidx.startup.Initializer

@SuppressLint("StaticFieldLeak")
internal lateinit var mainContext: Context
  private set

/**
 * The main process is automatically initialized by default
 * Multiple processes need to be initialized manually: [FluentUiInitializer.initialize]
 */
class FluentUiInitializer : Initializer<FluentUiInitializer> {
  companion object {
    /**
     * Manual initialization in Application#onCreate
     */
    fun initialize(context: Context) {
      mainContext = context
    }
  }

  override fun create(context: Context): FluentUiInitializer {
    mainContext = context
    return this
  }

  override fun dependencies() = emptyList<Nothing>()
}