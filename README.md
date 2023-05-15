# FluentUI

Effective implementation of high performance dynamic layout, drawable for Android via kotlin dsl.

[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/lecymeng/FluentView/blob/master/LICENSE)
![maven-central](https://img.shields.io/maven-central/v/com.weicools/fluent-ui.svg)
![jetbrains-plugin](https://img.shields.io/jetbrains/plugin/v/9202-a8translate.svg)

## Getting started

In your `build.gradle`:

```groovy
allprojects {
  repositories {
    mavenCentral()
  }
}
```

In your `module/build.gradle`:

```groovy
dependencies {
  implementation 'com.weicools:fluent-ui:1.0.1'
}
```

### Usage

```kotlin
val rootView = constraintLayout {
  layoutParams = defaultParams(matchParent, 64.dp)

  imageView(R.id.iconId) {
    layoutParams = constraintParams(40.dp, 40.dp) {
      leftToLeft = parentId
      centerVerticalOf = parentId
      leftMargin = 16.dp
    }
    imageResource = R.drawable.ic_arrow
  }

  textView(R.id.textId) {
    layoutParams = constraintParams(0, wrapContent) {
      leftToRight = R.id.iconId
      rightToRight = parentId
      centerVerticalOf = parentId
      leftMargin = 8.dp
      rightMargin = 16.dp
    }
    text = "layout title"
  }
}
```

> Note 📢
> The main process is automatically initialized context by default, Multiple processes need to be initialized manually: [FluentUiInitializer.initialize]
> Avoid using `xxxResourceOf` methods (such as `colorResourceOf`, `dimenResourceOf`, etc.) in View/Layout (which internally depends on appContext).
> Using them directly can cause the View/Layout to fail to preview because during preview, appContext is not initialized and cannot access the relevant resources.

### Screenshots

![Usage sample](https://blog-1251678165.cos.ap-chengdu.myqcloud.com/NWvJSz.png)

## Structure

```
com.weikeet.ui
├── animation   -> 动画: Kotlin dsl 构建动画
├── app         -> 应用: app context 以及通过 app context 获取相关资源
├── graphics    -> 图形: Kotlin dsl 构建 drawable
├── res         -> 资源: color, dimen, drawable, font, string
├── unit        -> 单位: dp, sp, px 转换
├── view        -> 视图: Kotlin dsl 构建 view, viewgroup
├── widget      -> 控件: Kotlin 控件属性扩展
└── window      -> 窗口: WindowInsets(StatusBar, NavigationBar, ime) 相关监听
```

### animation

快速创建动画 animator

```kotlin
startFloatAnimation(0f, 1f) {
  doOnFloatUpdate { animatedValue ->
    // do something
  }
  doOnStart {
    // do something
  }
  doOnEnd {
    // do something
  }
  duration = 240
  // repeatCount = 0
  // repeatMode = 
  // startDelay = 0
  // interpolator = LinearInterpolator()
}
```

more uses see [Animator.kt](library/src/main/kotlin/com/weikeet/ui/animation/Animator.kt)

### app

> 避免在 View/Layout 直接使用 `dpOf(xx)` 和 `xxxResourceOf` 方法 (如 `colorResourceOf`, `dimenResourceOf` 等), 
> 直接使用会导致 View/Layout 预览失败, 因为预览时 appContext 未初始化, 无法访问相关资源.
> 应该使用 xx.dp, dip(xx), `xxxResources` 方法 (如 `colorResources`, `dimenResources` 等)

资源获取

```kotlin
// get resource using app context
val color = colorResourceOf(R.color.colorPrimary)
val colorList = colorStateListOf(R.color.colorPrimary)

val dimen16 = dimenResourceOf(R.dimen.padding_16)
val dimenSize16 = dimenSizeResourceOf(R.dimen.padding_16)
val dimenOffset16 = dimenOffsetResourceOf(R.dimen.padding_16)

val drawable = drawableResourceOf(R.drawable.ic_arrow)

val font = fontResourceOf(R.font.font_name)

val string = stringResourceOf(R.string.app_name)
```

Unit 转换

```kotlin
// Convert dp to px using app context
val dp10 = dpOf(10)
val dp10f = dpOf(10f)
```

### graphics

使用 Kotlin dsl 像 xml 一样构建 drawable

```kotlin
// create drawable using kotlin dsl
val drawable = shapeDrawable {
  corners {
    radius = 20f.dp
  }
  solidColor = 0xff00ff00.toInt()
}
```

more uses see

- [Drawable.kt](library/src/main/kotlin/com/weikeet/ui/graphics/drawable/Drawable.kt)
- [Shapes.kt](library/src/main/kotlin/com/weikeet/ui/graphics/drawable/Shapes.kt)
- [States.kt](library/src/main/kotlin/com/weikeet/ui/graphics/drawable/States.kt)

### res

Context/Fragment/View 快捷获取资源

```kotlin
// get color using context/fragment/view resource
val color = colorResources(R.color.colorPrimary)
val colorList = colorStateList(R.color.colorPrimary)

val dimen16 = dimenResources(R.dimen.padding_16)
val dimenSize16 = dimenSizeResources(R.dimen.padding_16)
val dimenOffset16 = dimenOffsetResources(R.dimen.padding_16)

val drawable = drawableResources(R.drawable.ic_arrow)

val font = fontResources(R.font.font_name)

val string = stringResources(R.string.app_name)
```

### unit

dp, px 转换

```kotlin
// Convert dp to px using context/fragment/view resource
val dp10 = dp(10)
val dp10f = dp(10f)

// Convert sp to px using system resource
val dp20 = 20.dp
val dp20f = 20f.dp
```

### view

使用 Kotlin dsl 像 xml 一样构建 View, ViewGroup

```kotlin
val rootView = constraintLayout {
  layoutParams = defaultParams(matchParent, 64.dp)

  imageView(R.id.iconId) {
    layoutParams = constraintParams(40.dp, 40.dp) {
      // ...
    }
  }

  textView(R.id.textId) {
    layoutParams = constraintParams(0, wrapContent) {
      // ...
    }
  }
}
```

more uses see [ui/view](library/src/main/kotlin/com/weikeet/ui/view)

### widget

kotlin 控件属性扩展

```kotlin
context.textView {
  textColorResource = R.color.colorPrimary
  stringResource = R.string.app_name
  // ...
}

context.imageView {
  imageResource = R.drawable.ic_arrow
  // ...
}
```

more uses see [ui/widget](library/src/main/kotlin/com/weikeet/ui/widget)

### window

WindowInsets 相关监听

```kotlin
// adapt edge to edge
WindowInsetsEdgeDelegate(activity).start()

// listen window insets
view.doOnApplyWindowInsets { windowInsets ->
  // do something
  // eg: view.updatePadding(top = windowInsets.systemBarTop)
}
```

more uses see [ui/window](library/src/main/kotlin/com/weikeet/ui/window)

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
