package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RadialGradient
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

/**
 * @author Weicools Create on 2018.09.05
 *
 * desc: RadialGradient 辐射渐变
 * RadialGradient(float centerX, float centerY, float radius, int centerColor, int edgeColor, TileMode tileMode)
 * 参数：
 * centerX centerY：辐射中心的坐标
 * radius：辐射半径
 * centerColor：辐射中心的颜色
 * edgeColor：辐射边缘的颜色
 * tileMode：辐射范围之外的着色模式
 */
class Draw02RadialGradientView : View {
  private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private var mShader: Shader = RadialGradient(300f, 300f, 200f, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP)

  constructor(context: Context) : super(context)

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    paint.shader = mShader
    canvas.drawCircle(300f, 300f, 200f, paint)
  }
}
