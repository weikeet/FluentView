package com.weiwei.fluentlayout.app

import android.app.Application
import android.content.Context
import com.weiwei.fluentlayout.AppGlobal
import com.weiwei.fluentlayout.performance.AppStartMonitor

/**
 * @author weiwei
 * @date 2020.05.16
 * @implNote
 */
class UiApp : Application() {

  override fun attachBaseContext(base: Context) {
    super.attachBaseContext(base)
    AppGlobal.appContext = base

    AppStartMonitor.startMonitor()
    AppStartMonitor.recordTime("AppAttach")
  }

  override fun onCreate() {
    super.onCreate()

    AppStartMonitor.recordTime("AppCreate")
  }
}