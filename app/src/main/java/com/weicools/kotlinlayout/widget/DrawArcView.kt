package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author Weicools Create on 2018/4/10.
 *
 * desc: 练习内容：使用 canvas.drawArc() 方法画弧形和扇形
 */
class DrawArcView : View {
  internal var mPaint1 = Paint()
  internal var mPaint2 = Paint()

  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    /*
     * drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
     * left, top, right, bottom 描述的是这个弧形所在的椭圆；
     * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度）；
     * sweepAngle 是弧形划过的角度；
     * useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
     */
    mPaint1.style = Paint.Style.STROKE
    // 绘制不封口的弧形
    canvas.drawArc(200f, 100f, 500f, 300f, 180f, 60f, false, mPaint1)
    // 绘制扇形
    canvas.drawArc(200f, 100f, 500f, 300f, -110f, 100f, true, mPaint2)
    // 绘制弧形
    canvas.drawArc(200f, 100f, 500f, 300f, 20f, 140f, false, mPaint2)
  }
}
