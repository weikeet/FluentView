package com.weiwei.fluentlayout

import android.graphics.Color
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.weiwei.fluentlayout.async.AsyncViewDelegate

/**
 * @author weiwei
 * @date 2022.05.30
 */
class MainViewDelegate(activity: AppCompatActivity) : AsyncViewDelegate(activity) {
  override fun onCreateView(activity: AppCompatActivity): View {
    return MainConstraintMultiLayout2(activity)
  }

  override fun onViewCreated(rootView: View) {
    rootView.setBackgroundColor(Color.WHITE)
  }
}