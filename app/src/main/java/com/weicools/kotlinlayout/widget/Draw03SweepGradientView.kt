package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Shader
import android.graphics.SweepGradient
import android.util.AttributeSet
import android.view.View

/**
 * @author Weicools Create on 2018.09.05
 *
 * desc: SweepGradient 扫描渐变
 * SweepGradient(float cx, float cy, int color0, int color1)
 *
 * 参数：
 * cx cy ：扫描的中心
 * color0：扫描的起始颜色
 * color1：扫描的终止颜色
 */
class Draw03SweepGradientView : View {
  private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private var shader: Shader = SweepGradient(300f, 300f, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"))

  constructor(context: Context) : super(context)

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    paint.shader = shader
    canvas.drawCircle(300f, 300f, 200f, paint)
  }
}
