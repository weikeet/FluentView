package com.weicools.kotlinlayout.dsl

import androidx.core.view.ViewCompat
import java.util.HashMap

/**
 * @author weicools
 * @date 2021.03.24
 */
class ViewIdMap : HashMap<String, Int>() {
  fun getViewId(id: String): Int {
    var value: Int? = get(id)
    if (value == null) {
      value = ViewCompat.generateViewId();
    }
    return value
  }
}