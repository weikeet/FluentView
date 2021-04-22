package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author Weicools Create on 2018/4/10.
 *
 * desc: 练习内容：使用 canvas.drawPoint() 方法画点
 * 一个圆点，一个方点
 */
class DrawPointView : View {
  internal var roundPaint = Paint(Paint.ANTI_ALIAS_FLAG)
  internal var buttPaint = Paint(Paint.ANTI_ALIAS_FLAG)
  internal var roundPaints = Paint(Paint.ANTI_ALIAS_FLAG)

  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    /*
     * drawPoint(float x, float y, Paint paint)
     * x 和 y 是点的坐标
     * 点的大小可以通过 paint.setStrokeWidth(width) 来设置
     * 点的形状可以通过 paint.setStrokeCap(cap) 来设置：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
     *
     * drawPoints(float[] pts, int offset, int count, Paint paint) / drawPoints(float[] pts, Paint paint)
     * pts 这个数组是点的坐标，每两个成一对；offset 表示跳过数组的前几个数再开始记坐标；count 表示一共要绘制几个点
     */
    roundPaint.strokeWidth = 50f
    roundPaint.strokeCap = Paint.Cap.ROUND
    canvas.drawPoint(300f, 300f, roundPaint)

    buttPaint.strokeWidth = 50f
    buttPaint.strokeCap = Paint.Cap.BUTT
    canvas.drawPoint(600f, 300f, buttPaint)

    roundPaints.strokeWidth = 50f
    roundPaints.strokeCap = Paint.Cap.ROUND
    // 绘制四个点：(100, 150) (200, 250) (300, 350) (400, 450) (500, 550)
    val points = floatArrayOf(50f, 50f, 100f, 150f, 200f, 250f, 300f, 350f, 400f, 450f, 500f, 550f)
    canvas.drawPoints(points, 2, 8, roundPaints)
  }
}
