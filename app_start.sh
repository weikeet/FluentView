#!/usr/bin/env bash

for i in `seq 1 8`
do 
  adb shell am force-stop com.weicools.kotlinlayout
  sleep 2
  adb shell am start-activity -W -n com.weicools.kotlinlayout/.MainActivity | grep "TotalTime" | cut -d ' ' -f 2
  sleep 2
done