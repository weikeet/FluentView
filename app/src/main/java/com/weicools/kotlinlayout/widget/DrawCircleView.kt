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
 * desc:练习内容：使用 canvas.drawCircle() 方法画圆
 * 一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
 */
class DrawCircleView : View {
  internal var paint1 = Paint()
  internal var paint2 = Paint()
  internal var paint3 = Paint()
  internal var paint4 = Paint()

  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    /*
     * drawCircle(float centerX, float centerY, float radius, Paint paint)
     * 前两个参数 centerX centerY 是圆心的坐标，第三个参数 radius 是圆的半径，单位都是像素
     * 第四个参数 paint 提供基本信息之外的所有风格信息，例如颜色、线条粗细、阴影等
     */
    canvas.drawCircle(300f, 150f, 150f, paint1)

    paint2.isAntiAlias = true
    paint2.style = Paint.Style.STROKE
    canvas.drawCircle(800f, 150f, 150f, paint2)

    paint3.color = Color.BLUE
    canvas.drawCircle(300f, 600f, 150f, paint3)

    paint4.style = Paint.Style.STROKE
    paint4.strokeWidth = 80f
    canvas.drawCircle(800f, 600f, 150f, paint4)
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
  }
}
