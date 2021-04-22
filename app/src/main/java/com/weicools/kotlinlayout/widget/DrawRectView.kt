package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author Weicools Create on 2018/4/10.
 *
 * desc: 练习内容：使用 canvas.drawRect() 方法画矩形
 */
class DrawRectView : View {
  internal var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    /*
     * drawRect(float left, float top, float right, float bottom, Paint paint)
     * left, top是左上角点的坐标 right, bottom是右下角点的坐标
     *
     * 它还有两个重载方法 drawRect(RectF rect, Paint paint) 和 drawRect(Rect rect, Paint paint)
     * 让你可以直接填写 RectF 或 Rect 对象来绘制矩形
     */
    mPaint.color = Color.BLACK
    mPaint.style = Paint.Style.FILL
    canvas.drawRect(100f, 100f, 500f, 500f, mPaint)
  }
}
