package com.weiwei.fluentlayout

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.startup.AppInitializer
import com.weiwei.fluentview.app.FluentViewInitializer
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

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
      if (getProcessName().endsWith("remote")) {
        AppInitializer.getInstance(this).initializeComponent(FluentViewInitializer::class.java)
      }
    }

    AppStartMonitor.recordTime("AppCreate")
  }
}