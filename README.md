# FluentLayout

Effective dynamic layout via kotlin dsl.

[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/lecymeng/FluentLayout/blob/master/LICENSE)
![maven-central](https://img.shields.io/maven-central/v/com.weicools/fluent-layout.svg)
![jetbrains-plugin](https://img.shields.io/jetbrains/plugin/v/9202-a8translate.svg)

## Getting started

In your `build.gradle`:

```
allprojects {
    repositories {
        mavenCentral()
    }
}
```

In your `module/build.gradle`:

```
dependencies {
  implementation 'com.weicools:fluent-layout:1.1.1'
}
```

### Usage

```kotlin
val rootView = constraintLayout {
  layoutParams = defaultParams(matchParent, 64.dp)

  imageView(R.id.iconId) {
    layoutParams = constraintParams(40.dp, 40.dp) {
      leftToLeft = parentId
      center_VerticalOf = parentId
      leftMargin = 16.dp
    }
    image_resource = R.mipmap.ic_launcher
  }

  textView(R.id.textId) {
    layoutParams = constraintParams(0, wrapContent) {
      leftToRight = R.id.iconId
      rightToRight = parentId
      center_VerticalOf = parentId
      leftMargin = 8.dp
      rightMargin = 16.dp
    }
    text = "layout title"
  }
}
```

### Screenshots

![Usage sample](https://blog-1251678165.cos.ap-chengdu.myqcloud.com/NWvJSz.png)

## TODO

- [ ] support preview like xml tools

## License

```
Copyright (c) 2021-present. Weiwei

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
