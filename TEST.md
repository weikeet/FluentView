# Test data

## diff

replace on `com/weiwei/fluent/widget` xx.widget -> com.weiwei.fluent.widget

change codeStyle and format

copy abs path to merge tools

## Constraint XML

### Sample

```
964
938
973
958
952
914
960
952
969
961
956
957
```

```
inflateAvgTime=276810 inflateTimeList=[275030, 277853, 275708, 279319, 275957, 277669, 276612, 274944, 277432, 275850, 277839, 277293, 277024]
preDrawAvgTime=427 preDrawTimeList=[446, 426, 425, 428, 427, 424, 407, 427, 434, 436, 425, 427, 423]
```

### Multi

```
886
855
871
827
864
799
841
848
821
819
865
861
```

```
inflateAvgTime=277903 inflateTimeList=[277016, 277218, 279152, 279832, 277567, 277681, 275844, 278758, 279127, 278292, 278323, 278263, 275677]
preDrawAvgTime=493 preDrawTimeList=[515, 506, 498, 499, 482, 499, 467, 489, 492, 477, 481, 510, 501]
```

## Constraint Kotlin

### Sample

```
836
782
764
754
764
789
749
744
770
766
749
770
```

```
inflateAvgTime=1363 inflateTimeList=[1319, 1442, 1365, 1456, 1317, 1313, 1444, 1265, 1311, 1509, 1370, 1273, 1345]
preDrawAvgTime=405 preDrawTimeList=[391, 415, 402, 412, 398, 421, 418, 409, 404, 401, 398, 393, 411]
```

### Multi

```
903
810
847
810
830
812
793
814
789
810
810
835
```

```
inflateAvgTime=1403 inflateTimeList=[1236, 1520, 1348, 1485, 1387, 1592, 1291, 1440, 1419, 1343, 1360, 1402, 1426]
preDrawAvgTime=457 preDrawTimeList=[451, 465, 453, 464, 457, 465, 453, 452, 456, 459, 452, 455, 460]
```

## 锁定 CPU 频率

```zsh
$ cd ~/Benchmark
$ ./gradlew lockClocks

> Task :lockClocks
uid=0(root) gid=0(root) groups=0(root),1004(input),1007(log),1011(adb),1015(sdcard_rw),1028(sdcard_r),1078(ext_data_rw),1079(ext_obb_rw),3001(net_bt_admin),3002(net_bt),3003(inet),3006(net_bw_stats),3009(readproc),3011(uhid) context=u:r:su:s0
/var/folders/zf/ygg4cnfn7x9cr9fpgqv2xztc0000gn/T/lockClocks.sh8120460470295479374.tmp: 1 file pushed, 0 skipped. 4.2 MB/s (9233 bytes in 0.002s)
==================================
Locked CPUs 0,1,2,3,4,5,6,7 to 1036800 / 2016000 KHz
Disabled CPUs
==================================
Locked GPU to 133330000 / 650000000 Hz
Unable to lock memory bus of Redmi 4 (markw).
markw clocks have been locked - to reset, reboot the device
Unable to stop service 'perfd'
See dmesg for error reason.
Unable to stop service 'vendor.thermal-engine'
See dmesg for error reason.
Unable to stop service 'vendor.perfd'
See dmesg for error reason.
Failed to set property 'ctl.interface_restart' to 'android.hardware.power@1.0::IPower/default'.
See dmesg for error reason.
```

## XiaoMi 6

### Constraint XML

#### Sample

```
323
328
353
347
334
326
314
334
328
324
347
320
```

```
inflateAvgTime=78397 inflateTimeList=[85621, 77891, 77912, 77047, 77931, 79281, 76945, 80147, 80449, 76989, 76124, 76386, 76442]
preDrawAvgTime=151 preDrawTimeList=[187, 149, 146, 150, 152, 149, 146, 148, 150, 146, 150, 147, 148]
```

#### Multi

```
361
354
359
353
369
358
370
346
357
363
351
379
```

```
inflateAvgTime=79621 inflateTimeList=[78996, 77994, 78993, 79039, 79999, 79507, 82109, 79909, 80495, 81063, 78218, 80125, 78635]
preDrawAvgTime=185 preDrawTimeList=[192, 185, 187, 184, 183, 184, 186, 185, 182, 184, 186, 185, 191]
```

### Constraint Kotlin

#### Sample

```
289
294
293
279
276
293
281
275
278
282
287
285
```

```
inflateAvgTime=311 inflateTimeList=[493, 301, 271, 236, 263, 262, 298, 276, 405, 284, 314, 347, 296]
preDrawAvgTime=120 preDrawTimeList=[141, 115, 117, 131, 120, 115, 119, 118, 118, 115, 114, 121, 117]
```

#### Multi

```
359
330
345
325
346
352
334
333
361
349
336
337
```

```
inflateAvgTime=470 inflateTimeList=[579, 434, 450, 506, 471, 432, 480, 427, 451, 456, 441, 451, 534]
preDrawAvgTime=165 preDrawTimeList=[183, 168, 160, 166, 161, 164, 168, 163, 159, 165, 164, 166, 164]
```

### app/release/sample_tra.apk

284 289 304 295 298 322 315 292 287 287 292 298

inflateAvgTime=75067 inflateTimeList=[84296, 73645, 73769, 73765, 73938, 73261, 74170, 80591, 73122, 73865, 73056, 75145, 73252]
preDrawAvgTime=136 preDrawTimeList=[178, 128, 128, 130, 130, 127, 147, 160, 129, 128, 128, 134, 127]

### app/release/sample_xml.apk

363 370 381 372 366 385 385 386 363 363 352 363

inflateAvgTime=78984 inflateTimeList=[82736, 80149, 80837, 80055, 81988, 78426, 79917, 77457, 77865, 77363, 76580, 76892, 76534]
preDrawAvgTime=152 preDrawTimeList=[162, 153, 151, 148, 150, 149, 167, 164, 147, 147, 146, 144, 148]

### app/release/sample_ktl.apk

362 367 364 369 374 375 349 380 399 347 354

inflateAvgTime=494 inflateTimeList=[551, 479, 480, 489, 478, 519, 480, 485, 456, 516, 484, 519, 498]
preDrawAvgTime=142 preDrawTimeList=[144, 141, 132, 134, 132, 155, 153, 151, 135, 154, 148, 138, 136]
