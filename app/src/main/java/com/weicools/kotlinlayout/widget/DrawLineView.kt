package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author Weicools Create on 2018/4/10.
 *
 * desc:练习内容：使用 canvas.drawLine() 方法画直线
 */
class DrawLineView : View {
  internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)

  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    /*
     * drawLine(float startX, float startY, float stopX, float stopY, Paint paint)
     * startX, startY, stopX, stopY 分别是线的起点和终点坐标
     * 由于直线不是封闭图形，所以 setStyle(style) 对直线没有影响
     *
     * drawLines(float[] pts, int offset, int count, Paint paint) / drawLines(float[] pts, Paint paint) 批量画线
     */
    canvas.drawLine(50f, 400f, 500f, 400f, paint)

    val points = floatArrayOf(20f, 20f, 120f, 20f, 70f, 20f, 70f, 120f, 20f, 120f, 120f, 120f, 150f, 20f, 250f, 20f, 150f, 20f, 150f, 120f, 250f, 20f, 250f, 120f, 150f, 120f, 250f, 120f)
    canvas.drawLines(points, paint)
  }
}
