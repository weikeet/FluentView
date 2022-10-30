@file:Suppress("unused")

package com.fluent.view.ui

import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import com.fluent.annotation.NO_GETTER
import com.fluent.annotation.noGetter

//region ImageView extension field
/**
 * Sets a drawable resource as the content of this ImageView.
 * Allows the use of vector drawables when running on older versions of the platform.
 *
 * **This does Bitmap reading and decoding on the UI thread, which can cause a latency hiccup.**
 * If that's a concern, consider using [imageDrawableCompatResource] or [imageBitmap] and [BitmapFactory] instead.
 */
inline var ImageView.imageResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@DrawableRes drawableId) = setImageResource(drawableId)

/**
 * Sets a drawable resource as the content of this ImageView.
 * Not allowed the use of vector drawables when running on older versions of the platform.
 */
inline var ImageView.imageDrawableResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@DrawableRes drawableId) = setImageDrawable(ContextCompat.getDrawable(context, drawableId))

/**
 * Sets a drawable resource as the content of this ImageView.
 * Allows the use of vector drawables when running on older versions of the platform.
 */
inline var ImageView.imageDrawableCompatResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@DrawableRes drawableId) = setImageDrawable(AppCompatResources.getDrawable(context, drawableId))

/**
 * Sets a drawable as the content of this ImageView.
 * A null value will clear the content.
 */
inline var ImageView.imageDrawable: Drawable?
  get() = drawable
  set(value) = setImageDrawable(value)

/**
 * Sets a Bitmap as the content of this ImageView.
 */
inline var ImageView.imageBitmap: Bitmap?
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(bitmap) = setImageBitmap(bitmap)

/**
 * Applies a tint to the image drawable. Does not modify the current tintMode, which is [PorterDuff.Mode.SRC_IN] by default.
 */
inline var ImageView.imageTintColorResource: Int
  @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
  set(@ColorRes colorId) {
    if (Build.VERSION.SDK_INT >= 22) {
      imageTintList = ContextCompat.getColorStateList(context, colorId)
    } else {
      ImageViewCompat.setImageTintList(this, ContextCompat.getColorStateList(context, colorId))
    }
  }

inline var ImageView.imageTintColorList: ColorStateList?
  get() = imageTintList
  set(tintList) {
    if (Build.VERSION.SDK_INT >= 22) {
      imageTintList = tintList
    } else {
      ImageViewCompat.setImageTintList(this, tintList)
    }
  }

inline var ImageView.imageTintModeCompat: PorterDuff.Mode?
  get() = imageTintMode
  set(mode) {
    if (Build.VERSION.SDK_INT >= 22) {
      imageTintMode = mode
    } else {
      ImageViewCompat.setImageTintMode(this, mode)
    }
  }

inline val ImageView.scaleCenter get() = ImageView.ScaleType.CENTER
inline val ImageView.scaleCenterCrop get() = ImageView.ScaleType.CENTER_CROP
inline val ImageView.scaleCenterInside get() = ImageView.ScaleType.CENTER_INSIDE
inline val ImageView.scaleFitCenter get() = ImageView.ScaleType.FIT_CENTER
inline val ImageView.scaleFitStart get() = ImageView.ScaleType.FIT_START
inline val ImageView.scaleFitEnd get() = ImageView.ScaleType.FIT_END
inline val ImageView.scaleFixXy get() = ImageView.ScaleType.FIT_XY
inline val ImageView.scaleMatrix get() = ImageView.ScaleType.MATRIX
//endregion
