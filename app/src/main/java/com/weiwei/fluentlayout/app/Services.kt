package com.fluent.view.app

import android.app.ActivityManager
import android.app.AlarmManager
import android.app.AppOpsManager
import android.app.DownloadManager
import android.app.KeyguardManager
import android.app.NotificationManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.location.LocationManager
import android.media.AudioManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.BatteryManager
import android.os.PowerManager
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager

/** Returns the AccessibilityManager instance. **/
val Context.accessibilityManager: AccessibilityManager
  get() = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

/** Returns the ActivityManager instance. **/
val Context.activityManager: ActivityManager
  get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

/** Returns the AlarmManager instance. **/
val Context.alarmManager: AlarmManager
  get() = getSystemService(Context.ALARM_SERVICE) as AlarmManager

/** Returns the AppOpsManager instance. **/
val Context.appOpsManager: AppOpsManager
  get() = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

/** Returns the AudioManager instance. **/
val Context.audioManager: AudioManager
  get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager

/** Returns the BatteryManager instance. **/
val Context.batteryManager: BatteryManager
  get() = getSystemService(Context.BATTERY_SERVICE) as BatteryManager

/** Returns the BluetoothManager instance. **/
val Context.bluetoothManager: BluetoothManager
  get() = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

/** Returns the CameraManager instance. **/
val Context.cameraManager: CameraManager
  get() = getSystemService(Context.CAMERA_SERVICE) as CameraManager

/** Returns the ClipboardManager instance. **/
val Context.clipboardManager: ClipboardManager
  get() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

/** Returns the ConnectivityManager instance. **/
val Context.connectivityManager: ConnectivityManager
  get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

/** Returns the DisplayManager instance. **/
val Context.displayManager: DisplayManager
  get() = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager

/** Returns the DownloadManager instance. **/
val Context.downloadManager: DownloadManager
  get() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

/** Returns the KeyguardManager instance. **/
val Context.keyguardManager: KeyguardManager
  get() = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

/** Returns the LocationManager instance. **/
val Context.locationManager: LocationManager
  get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager

/** Returns the NotificationManager instance. **/
val Context.notificationManager: NotificationManager
  get() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

/** Returns the PowerManager instance. **/
val Context.powerManager: PowerManager
  get() = getSystemService(Context.POWER_SERVICE) as PowerManager

/** Returns the SensorManager instance. **/
val Context.sensorManager: SensorManager
  get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager

/** Returns the WifiManager instance. **/
val Context.wifiManager: WifiManager
  get() = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

/** Returns the WindowManager instance. **/
val Context.windowManager: WindowManager
  get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager
