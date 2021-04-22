package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

/**
 * @author Weicools Create on 2018.09.05
 *
 * desc: LinearGradient 线性渐变
 * 设置两个点和两种颜色，以这两个点作为端点，使用两种颜色的渐变来绘制颜色
 *
 * LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, Shader.TileMode tile)
 * x0 y0 x1 y1：渐变的两个端点的位置
 * color0 color1 是端点的颜色
 * tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可选： CLAMP, MIRROR 和 REPEAT。
 * CLAMP 会在端点之外延续端点处的颜色；
 * MIRROR 是镜像模式；
 * REPEAT 是重复模式。具体的看一下例子就明白。
 */
class Draw01LinearGradientView : View {
  private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private var shader: Shader = LinearGradient(
    100f, 100f, 500f, 500f, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
    Shader.TileMode.CLAMP
  )

  constructor(context: Context) : super(context)

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    paint.shader = shader
    canvas.drawCircle(500f, 500f, 200f, paint)
  }
}
