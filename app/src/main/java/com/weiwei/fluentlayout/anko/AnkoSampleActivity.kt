package com.weiwei.fluentlayout.anko

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.weiwei.fluentlayout.R
import com.weiwei.fluent.widget.extensions.dp
import org.jetbrains.anko.imageView
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * @author weiwei
 * @date 2021.05.14
 */
class AnkoSampleActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    verticalLayout {
      gravity = Gravity.CENTER

      imageView(R.drawable.ic_android_24dp).lparams(40.dp, 40.dp)

      textView("Hello Android").lparams { topMargin = 8.dp }
    }
  }
}