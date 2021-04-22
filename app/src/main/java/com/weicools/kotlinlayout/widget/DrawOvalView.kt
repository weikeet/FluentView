package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author Weicools Create on 2018/4/10.
 *
 * desc: 练习内容：使用 canvas.drawOval() 方法画椭圆
 */
class DrawOvalView : View {
  internal var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
  internal var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)

  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    /*
     * drawOval(float left, float top, float right, float bottom, Paint paint)
     * left, top, right, bottom 是这个椭圆的左、上、右、下四个边界点的坐标
     *
     * 还有一个重载方法 drawOval(RectF rect, Paint paint)，让你可以直接填写 RectF 来绘制椭圆
     */
    paint1.style = Paint.Style.FILL
    canvas.drawOval(50f, 50f, 550f, 200f, paint1)

    paint2.style = Paint.Style.STROKE
    canvas.drawOval(100f, 300f, 600f, 500f, paint2)
  }
}
