package com.weiwei.fluentlayout.performance;

/**
 * @author weiwei
 * @date 2021.03.22
 */
public final class AppStartMonitor {
  public static void startMonitor() {
    TimeMonitorManager.getInstance().getAppStartMonitor().startMonitor();
  }

  public static void recordTime(String tag) {
    TimeMonitorManager.getInstance().getAppStartMonitor().recordTime(tag);
  }

  public static void recordTime(String startTag, String tag) {
    TimeMonitorManager.getInstance().getAppStartMonitor().recordTime(startTag, tag);
  }

  public static void recordDuration(String tag, long duration) {
    TimeMonitorManager.getInstance().getAppStartMonitor().recordDuration(tag, duration);
  }

  public static void end(boolean writeLog) {
    TimeMonitorManager.getInstance().getAppStartMonitor().end(writeLog);
  }
}
