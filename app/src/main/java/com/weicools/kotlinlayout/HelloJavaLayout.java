package com.weicools.kotlinlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.weicools.kotlinlayout.widget.WidgetAttrsKt;
import org.jetbrains.annotations.NotNull;

/**
 * @author weicools
 * @date 2021.05.08
 */
@SuppressLint("SetTextI18n")
public class HelloJavaLayout extends ConstraintLayout {
  public HelloJavaLayout(@NonNull @NotNull Context context) {
    super(context);
    init(context);
  }

  public HelloJavaLayout(@NonNull @NotNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public HelloJavaLayout(@NonNull @NotNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  private void init(Context context) {
    int iconId = ViewCompat.generateViewId();
    int textId = ViewCompat.generateViewId();

    ImageView iconView = new AppCompatImageView(context);
    iconView.setId(iconId);
    iconView.setImageResource(R.drawable.ic_android_24dp);
    LayoutParams iconParams = new LayoutParams(WidgetAttrsKt.getDp(40), WidgetAttrsKt.getDp(40));
    iconParams.leftToLeft = LayoutParams.PARENT_ID;
    iconParams.topToTop = LayoutParams.PARENT_ID;
    iconParams.rightToRight = LayoutParams.PARENT_ID;
    iconParams.bottomToTop = textId;
    iconParams.verticalChainStyle = LayoutParams.CHAIN_PACKED;
    addView(iconView, iconParams);

    TextView textView = new AppCompatTextView(context);
    textView.setId(textId);
    textView.setText("Hello Android");
    LayoutParams textParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    textParams.topMargin = WidgetAttrsKt.getDp(8);
    textParams.leftToLeft = LayoutParams.PARENT_ID;
    textParams.topToBottom = iconId;
    textParams.rightToRight = LayoutParams.PARENT_ID;
    textParams.bottomToBottom = LayoutParams.PARENT_ID;
    addView(textView, textParams);
  }
}
