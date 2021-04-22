package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * @author Weicools Create on 2018/4/10.
 *
 * desc: 练习内容：使用 canvas.drawPath() 方法画心形
 */
class DrawPathView : View {

  internal var paint = Paint()
  internal var path = Path()

  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    /*
     * drawPath(Path path, Paint paint)
     * Path 可以描述直线、二次曲线、三次曲线、圆、椭圆、弧形、矩形、圆角矩形。
     * 把这些图形结合起来，就可以描述出很多复杂的图形
     *
     * Path 方法第一类：直接描述路径, 可以细分为两组：添加子图形和画线（直线或曲线）
     * 第一组： addXxx() ——添加子图形
     * addCircle(float x, float y, float radius, Direction dir) 添加圆
     * x, y, radius 这三个参数是圆的基本信息，最后一个参数 dir 是画圆的路径的方向。
     *
     * 其他的Path.addXxx() 方法和这类似，例如：
     * addOval(float left, float top, float right, float bottom, Direction dir) / addOval(RectF oval, Direction dir) 添加椭圆
     * addRect(float left, float top, float right, float bottom, Direction dir) / addRect(RectF rect, Direction dir) 添加矩形
     * addRoundRect(RectF rect, float rx, float ry, Direction dir) / addRoundRect(float left, float top, float right, float bottom, float rx, float ry, Direction dir) / addRoundRect(RectF rect, float[] radii, Direction dir) / addRoundRect(float left, float top, float right, float bottom, float[] radii, Direction dir) 添加圆角矩形
     * addPath(Path path) 添加另一个 Path
     *
     *
     * 第二组：xxxTo() ——画线（直线或曲线）
     * lineTo(float x, float y) / rLineTo(float x, float y) 画直线
     * 从当前位置向目标位置画一条直线， x 和 y 是目标位置的坐标
     * 当前位置：所谓当前位置，即最后一次调用画 Path 的方法的终点位置。初始值为原点 (0, 0)
     * 这两个方法的区别是，lineTo(x, y) 的参数是绝对坐标，而 rLineTo(x, y) 的参数是相对当前位置的相对坐标
     *
     * quadTo(float x1, float y1, float x2, float y2) / rQuadTo(float dx1, float dy1, float dx2, float dy2) 画二次贝塞尔曲线
     * 这条二次贝塞尔曲线的起点就是当前位置，而参数中的 x1, y1 和 x2, y2 则分别是控制点和终点的坐标
     * cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) / rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) 画三次贝塞尔曲线
     *
     * moveTo(float x, float y) / rMoveTo(float x, float y) 移动到目标位置
     *
     * 另外，第二组还有两个特殊的方法： arcTo() 和 addArc()。它们也是用来画线的，但并不使用当前位置作为弧线的起点
     * arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) / arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo) / arcTo(RectF oval, float startAngle, float sweepAngle) 画弧形
     * 这个方法和 Canvas.drawArc() 比起来，少了一个参数 useCenter，而多了一个参数 forceMoveTo 。
     */

    /*
     * Direction dir
     * 路径方向有两种：顺时针 (CW clockwise) 和逆时针 (CCW counter-clockwise)
     * 对于普通情况，这个参数填 CW 还是填 CCW 没有影响
     * 它只是在需要填充图形 (Paint.Style 为 FILL 或  FILL_AND_STROKE) ，并且图形出现自相交时，用于判断填充范围的
     */

    // 使用 path 对图形进行描述
    path.addArc(300f, 100f, 400f, 200f, -225f, 225f)
    path.arcTo(400f, 100f, 500f, 200f, -180f, 225f, false)
    path.lineTo(400f, 282f)
    canvas.drawPath(path, paint)
  }
}
