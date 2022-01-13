package com.weiwei.fluentlayout

import android.app.Application
import android.content.Context
import com.weiwei.fluentlayout.performance.AppStartMonitor

/**
 * @author weiwei
 * @date 2020.05.16
 * @implNote
 */
class KotlinLayoutApp : Application() {

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