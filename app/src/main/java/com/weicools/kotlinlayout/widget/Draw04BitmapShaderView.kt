package com.weicools.kotlinlayout.widget

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View
import com.weicools.kotlinlayout.R

/**
 * @author Weicools Create on 2018.09.05
 *
 * desc: BitmapShader
 * BitmapShader(Bitmap bitmap, Shader.TileMode tileX, Shader.TileMode tileY)
 *
 * 参数：
 * bitmap：用来做模板的 Bitmap 对象
 * tileX：横向的 TileMode
 * tileY：纵向的 TileMode
 */
class Draw04BitmapShaderView : View {
  private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private var bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher)
  private var mShader: Shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

  constructor(context: Context) : super(context)

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    paint.shader = mShader
    canvas.drawCircle(300f, 300f, 200f, paint)
  }
}
