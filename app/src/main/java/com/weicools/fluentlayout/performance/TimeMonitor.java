package com.weicools.fluentlayout.performance;

import android.util.Log;
import com.weicools.fluentlayout.AppGlobal;
import com.weicools.fluentlayout.BuildConfig;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/**
 * @author weicools
 * @date 2021.03.15
 */
public final class TimeMonitor {
  private static final String TAG = "TimeMonitor";

  private int monitorId;

  private long startTime = 0;

  private boolean writeFinish;

  // 保存一个耗时统计模块的各种耗时，tag对应某一个阶段的时间
  private final HashMap<String, Long> timeTag = new HashMap<>();

  private final List<TimeTag> timeTagList = new ArrayList<>();
  private final List<TimeTag> durationTagList = new ArrayList<>();

  public TimeMonitor(int monitorId) {
    this.monitorId = monitorId;
  }

  public void startMonitor() {
    // 每次重新启动都把前面的数据清除，避免统计错误的数据
    if (timeTag.size() > 0) {
      timeTag.clear();
    }
    if (timeTagList.size() > 0) {
      timeTagList.clear();
    }
    if (durationTagList.size() > 0) {
      durationTagList.clear();
    }
    startTime = System.currentTimeMillis();
  }

  /**
   * 每打一次点，记录某个tag的耗时
   */
  public void recordTime(String tag) {
    long time = System.currentTimeMillis() - startTime;
    timeTag.put(tag, time);
    timeTagList.add(new TimeTag(tag, time));
  }

  /**
   * 记录某个tag的耗时, 并记录与startTag之间时长
   */
  public void recordTime(String startTag, String tag) {
    long time = System.currentTimeMillis() - startTime;
    timeTag.put(tag, time);
    timeTagList.add(new TimeTag(tag, time));

    long startTagTime = 0L;
    Long l = timeTag.get(startTag);
    if (l == null) {
      if (BuildConfig.DEBUG) {
        throw new IllegalArgumentException(startTag + ", StartTag not record time");
      }
    } else {
      startTagTime = l;
    }
    String durationKey = startTag + "_" + tag;
    durationTagList.add(new TimeTag(durationKey, (time - startTagTime)));
  }

  public void recordDuration(String tag, long duration) {
    durationTagList.add(new TimeTag(tag, duration));
  }

  public void end(boolean writeLog) {
    if (writeFinish) {
      return;
    }
    new Thread(() -> endInner(writeLog)).start();
  }

  private void endInner(boolean writeLog) {
    try {
      JSONObject timeObject = new JSONObject();
      for (TimeTag tag : timeTagList) {
        timeObject.put(tag.tag, tag.time);
      }

      JSONObject durationObject = new JSONObject();
      for (TimeTag tag : durationTagList) {
        durationObject.put(tag.tag, tag.time);
      }

      if (writeLog) {
        JSONObject output = new JSONObject();
        output.put("Timer", timeObject);
        output.put("Duration", durationObject);

        String outputContent = output.toString();
        Log.d(TAG + monitorId, outputContent);

        File startupDir = AppGlobal.getAppContext().getExternalFilesDir("Startup");
        if (startupDir == null) {
          return;
        }
        boolean mk = startupDir.mkdirs();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA);
        String filename = sdf.format(new Date()) + ".json";

        try {
          File outputFile = new File(startupDir, filename);
          BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
          out.write(outputContent);
          out.close();
          writeFinish = true;
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
