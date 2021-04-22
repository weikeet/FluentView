package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View

/**
 * @author Weicools Create on 2018/4/10.
 *
 * desc: 练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色
 * 黄色： Color.YELLOW
 */
class DrawColorView : View {
  constructor(context: Context) : super(context) {}

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    /*
     * Canvas.drawColor(@ColorInt int color) 颜色填充, 例如:
     * drawColor(Color.BLACK) 会把整个区域染成纯黑色，覆盖掉原有内容；
     * drawColor(Color.parse("#88880000") 会在原有的绘制效果上加一层半透明的红色遮罩。
     *
     * 类似的方法还有 drawRGB(int r, int g, int b) 和 drawARGB(int a, int r, int g, int b) ，
     * 它们和 drawColor(color) 只是使用方式不同，作用都是一样的。
     * 这类颜色填充方法一般用于在绘制之前设置底色，或者在绘制之后为界面设置半透明蒙版。
     */
    canvas.drawColor(Color.YELLOW)
  }
}
