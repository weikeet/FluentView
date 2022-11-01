package com.weiwei.fluentlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.weiwei.fluentview.ui.res.stringResource

/**
 * @author weiwei
 * @date 2022.10.26
 */
class SecondActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    stringResource(R.string.app_name)
  }
}