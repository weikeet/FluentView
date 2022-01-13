package com.weiwei.fluentlayout.performance;

/**
 * @author weiwei
 * @date 2021.03.15
 */
public final class TimeMonitorManager {
  private static final class TimeMonitorHolder {
    private final static TimeMonitorManager INSTANCE = new TimeMonitorManager();
  }

  private TimeMonitorManager() {
  }

  public static TimeMonitorManager getInstance() {
    return TimeMonitorHolder.INSTANCE;
  }

  private TimeMonitor appStartMonitor = new TimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APP_START);

  public TimeMonitor getAppStartMonitor() {
    return appStartMonitor;
  }

  // private HashMap<Integer, TimeMonitor> monitorMap = new HashMap<>();
  //
  // public void resetTimeMonitor(int id) {
  //     if (monitorMap.get(id) != null) {
  //         monitorMap.remove(id);
  //     }
  //     getTimeMonitor(id);
  // }
  //
  // public TimeMonitor getTimeMonitor(int id) {
  //     TimeMonitor monitor = monitorMap.get(id);
  //     if (monitor == null) {
  //         monitor = new TimeMonitor(id);
  //         monitorMap.put(id, monitor);
  //     }
  //     return monitor;
  // }
}
