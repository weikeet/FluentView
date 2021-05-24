package com.weicools.kotlinlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.weicools.kotlinlayout.widget.extensions.ResourceKt;
import org.jetbrains.annotations.NotNull;

/**
 * @author weicools
 * @date 2021.05.08
 */
@SuppressLint("SetTextI18n")
public class HelloJavaLayout extends FrameLayout {
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
    addView(createView(context), new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
  }

  private View createView(Context context) {
    ConstraintLayout container = new ConstraintLayout(context);

    int iconId = ViewCompat.generateViewId();
    int textId = ViewCompat.generateViewId();

    ImageView iconView = new AppCompatImageView(context);
    iconView.setId(iconId);
    iconView.setImageResource(R.drawable.ic_android_24dp);
    ConstraintLayout.LayoutParams iconParams = new ConstraintLayout.LayoutParams(ResourceKt.getDp(40), ResourceKt.getDp(40));
    iconParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
    iconParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
    iconParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
    iconParams.bottomToTop = textId;
    iconParams.verticalChainStyle = ConstraintLayout.LayoutParams.CHAIN_PACKED;
    container.addView(iconView, iconParams);

    TextView textView = new AppCompatTextView(context);
    textView.setId(textId);
    textView.setText("Hello Android");
    ConstraintLayout.LayoutParams textParams = new ConstraintLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    textParams.topMargin = ResourceKt.getDp(8);
    textParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
    textParams.topToBottom = iconId;
    textParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
    textParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
    container.addView(textView, textParams);

    return container;
  }
}
