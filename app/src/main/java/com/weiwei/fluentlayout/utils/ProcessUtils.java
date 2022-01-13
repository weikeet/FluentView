package com.weiwei.fluentlayout.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.weiwei.fluentlayout.AppGlobal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author weiwei
 * @date 2021.04.21
 *
 * link: https://juejin.cn/post/6877127949452050446
 */
public final class ProcessUtils {
  private static final String TAG = "ProcessUtils";

  private static String processName;
  private static Boolean mainProcess = null;

  @Nullable
  public static String getProcessName(@NonNull Context context) {
    if (!TextUtils.isEmpty(processName)) {
      return processName;
    }

    processName = getProcessNameByApplication();
    if (!TextUtils.isEmpty(processName)) {
      Log.d(TAG, "getProcessNameByApplication: processName=" + processName);
      return processName;
    }

    processName = getProcessNameByActivityThread();
    if (!TextUtils.isEmpty(processName)) {
      Log.d(TAG, "getProcessNameByActivityThread: processName=" + processName);
      return processName;
    }

    processName = getProcessNameByActivityManager(context);
    Log.d(TAG, "getProcessNameByActivityManager: processName=" + processName);

    return processName;
  }

  /**
   * 通过 Application 新的 API 获取进程名，无需反射，无需IPC，效率最高。
   */
  private static String getProcessNameByApplication() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
      return Application.getProcessName();
    }
    return null;
  }

  /**
   * 通过反射 ActivityThread 获取进程名，避免 IPC 通信
   */
  @SuppressLint("PrivateApi")
  @SuppressWarnings("RedundantArrayCreation")
  private static String getProcessNameByActivityThread() {
    String processName = null;
    try {
      final String name = "android.app.ActivityThread";
      final Class<?> clazz = Class.forName(name, false, Application.class.getClassLoader());
      final Method declaredMethod = clazz.getDeclaredMethod("currentProcessName", new Class[0]);
      declaredMethod.setAccessible(true);
      final Object invoke = declaredMethod.invoke(null, new Object[0]);
      if (invoke instanceof String) {
        processName = (String) invoke;
      }
    } catch (Throwable e) {
      Log.d(TAG, "getProcessNameByActivityThread: e=" + e.getMessage());
    }
    return processName;
  }

  /**
   * 通过 ActivityManager 获取进程名，需要 IPC 通信
   */
  private static String getProcessNameByActivityManager(@NonNull Context context) {
    int pid = Process.myPid();
    ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    if (am != null) {
      List<ActivityManager.RunningAppProcessInfo> runningAppList = am.getRunningAppProcesses();
      if (runningAppList != null) {
        for (ActivityManager.RunningAppProcessInfo processInfo : runningAppList) {
          if (processInfo.pid == pid) {
            return processInfo.processName;
          }
        }
      }
    }
    return null;
  }

  private static String getProcessNameByShell() {
    String processName = null;
    BufferedReader bufferedReader = null;
    try {
      File file = new File("/proc/" + Process.myPid() + "/cmdline");
      bufferedReader = new BufferedReader(new FileReader(file));
      processName = bufferedReader.readLine().trim();
      bufferedReader.close();
    } catch (Throwable e) {
      Log.d(TAG, "getProcessNameByShell: e=" + e.getMessage());
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) {
          Log.d(TAG, "getProcessNameByShell close: e=" + e.getMessage());
        }
      }
    }
    return processName;
  }

  public static boolean isMainProcess() {
    if (mainProcess == null) {
      Context ctx = AppGlobal.getAppContext();
      mainProcess = ctx.getPackageName().equals(getProcessName(ctx));
    }
    return mainProcess;
  }

  public static void testProcessName() {
    Log.d(TAG, "testProcessName getProcessNameByApplication: " + getProcessNameByApplication());
    Log.d(TAG, "testProcessName getProcessNameByActivityThread: " + getProcessNameByActivityThread());
    Log.d(TAG, "testProcessName getProcessNameByActivityManager: " + getProcessNameByActivityManager(AppGlobal.getAppContext()));
    Log.d(TAG, "testProcessName getProcessNameByShell: " + getProcessNameByShell());
  }
}
