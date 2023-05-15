package com.weikeet.ui.window

import android.app.Activity
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

/**
 * @author weiwei
 * @date 2022.01.12
 */
class WindowInsetsEdgeDelegate(private val activity: Activity) {
  private var everGivenInsetsToDecorView = false

  private var statusBarColor = Color.TRANSPARENT
  private var navigationBarColor: Int = 0x20ffffff

  fun setStatusBarColor(color: Int): WindowInsetsEdgeDelegate {
    statusBarColor = color
    return this
  }

  fun setNavigationBarColor(color: Int): WindowInsetsEdgeDelegate {
    navigationBarColor = color
    return this
  }

  fun start() {
    everGivenInsetsToDecorView = false

    val window = activity.window

    // Without this line of code, DecorView will consume the status and navigation bar
    WindowCompat.setDecorFitsSystemWindows(window, false)

    // Set status bar, navigation bar color
    window.statusBarColor = statusBarColor
    window.navigationBarColor = navigationBarColor

    // Gesture navigation bar height threshold
    val threshold = (20 * Resources.getSystem().displayMetrics.density).toInt()

    // This prevents a translucent white bottom bar from appearing on the MIUI system
    ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { _: View?, windowInsets: WindowInsetsCompat ->
      val navigationBarsInsets = windowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())
      // 44px/72px is the fixed height of the iOS-like navigation bar (Gesture navigation), in pixels!
      val navigationBarsMaxHeight = if (Build.VERSION.SDK_INT < 33) {
        threshold.coerceAtLeast(44)
      } else {
        threshold.coerceAtLeast(72)
      }
      val isGestureNavigation = navigationBarsInsets.bottom <= navigationBarsMaxHeight

      if (!isGestureNavigation) {
        // Let decorView draw the translucent navigationBarColor
        ViewCompat.onApplyWindowInsets(window.decorView, windowInsets)
        everGivenInsetsToDecorView = true

      } else if (everGivenInsetsToDecorView) {
        // Let DecorView remove navigationBarColor once it has bean drawn
        val noBottomInsets = Insets.of(navigationBarsInsets.left, navigationBarsInsets.top, navigationBarsInsets.right, 0)
        val noBottomWindowInsets = WindowInsetsCompat.Builder()
          .setInsets(WindowInsetsCompat.Type.navigationBars(), noBottomInsets)
          .build()
        ViewCompat.onApplyWindowInsets(window.decorView, noBottomWindowInsets)
      }

      windowInsets
    }
  }

}