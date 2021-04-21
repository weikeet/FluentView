package com.weicools.kotlinlayout.performance;

/**
 * @author weicools
 * @date 2021.03.23
 */
final class TimeTag {
  String tag;
  long time;

  public TimeTag(String tag, long time) {
    this.tag = tag;
    this.time = time;
  }
}
