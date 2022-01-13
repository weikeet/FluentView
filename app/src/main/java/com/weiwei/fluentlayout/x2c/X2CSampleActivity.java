package com.weiwei.fluentlayout.x2c;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.weiwei.fluentlayout.R;
import com.zhangyue.we.x2c.X2C;
import com.zhangyue.we.x2c.ano.Xml;

/**
 * @author weiwei
 * @date 2021.05.13
 */
@Xml(layouts = "activity_main")
public class X2CSampleActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    X2C.setContentView(this, R.layout.activity_main);
  }
}
