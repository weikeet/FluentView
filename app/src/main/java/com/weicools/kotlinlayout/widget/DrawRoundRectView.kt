package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author Weicools Create on 2018/4/10.
 *
 * desc: 练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
 */
class DrawRoundRectView : View {
  internal var paint = Paint()

  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    /*
     * drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, Paint paint)
     * left, top, right, bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向半径
     *
     * 它还有一个重载方法 drawRoundRect(RectF rect, float rx, float ry, Paint paint)，让你可以直接填写 RectF 来绘制圆角矩形
     */
    canvas.drawRoundRect(100f, 100f, 500f, 300f, 25f, 25f, paint)
  }
}
