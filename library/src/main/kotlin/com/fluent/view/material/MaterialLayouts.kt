package com.fluent.view.material

import android.content.Context
import android.view.ViewGroup
import com.fluent.view.wrapContent
import com.fluent.view.wrapContextIfNeeded
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.card.MaterialCardView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputLayout

//region tabLayout
inline fun ViewGroup.tabLayout(id: Int? = null, style: Int? = null, init: TabLayout.() -> Unit): TabLayout {
  val widget = TabLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.tabLayout(id: Int? = null, style: Int? = null, init: TabLayout.() -> Unit): TabLayout {
  val widget = TabLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region appBarLayout
inline fun ViewGroup.appBarLayout(id: Int? = null, style: Int? = null, init: AppBarLayout.() -> Unit): AppBarLayout {
  val widget = AppBarLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun ViewGroup.collapsingToolbarLayout(id: Int? = null, style: Int? = null, init: CollapsingToolbarLayout.() -> Unit): CollapsingToolbarLayout {
  val widget = CollapsingToolbarLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}
//endregion

//region bottomAppBar
inline fun ViewGroup.bottomAppBar(id: Int? = null, style: Int? = null, init: BottomAppBar.() -> Unit): BottomAppBar {
  val widget = BottomAppBar(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.bottomAppBar(id: Int? = null, style: Int? = null, init: BottomAppBar.() -> Unit): BottomAppBar {
  val widget = BottomAppBar(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region materialToolbar
inline fun ViewGroup.materialToolbar(id: Int? = null, style: Int? = null, init: MaterialToolbar.() -> Unit): MaterialToolbar {
  val widget = MaterialToolbar(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.materialToolbar(id: Int? = null, style: Int? = null, init: MaterialToolbar.() -> Unit): MaterialToolbar {
  val widget = MaterialToolbar(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region materialCardView
inline fun ViewGroup.materialCardView(id: Int? = null, style: Int? = null, init: MaterialCardView.() -> Unit): MaterialCardView {
  val widget = MaterialCardView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.materialCardView(id: Int? = null, style: Int? = null, init: MaterialCardView.() -> Unit): MaterialCardView {
  val widget = MaterialCardView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region bottomNavigationView
inline fun ViewGroup.bottomNavigationView(id: Int? = null, style: Int? = null, init: BottomNavigationView.() -> Unit): BottomNavigationView {
  val widget = BottomNavigationView(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.bottomNavigationView(id: Int? = null, style: Int? = null, init: BottomNavigationView.() -> Unit): BottomNavigationView {
  val widget = BottomNavigationView(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region materialButtonToggleGroup
inline fun ViewGroup.materialButtonToggleGroup(id: Int? = null, style: Int? = null, init: MaterialButtonToggleGroup.() -> Unit): MaterialButtonToggleGroup {
  val widget = MaterialButtonToggleGroup(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.materialButtonToggleGroup(id: Int? = null, style: Int? = null, init: MaterialButtonToggleGroup.() -> Unit): MaterialButtonToggleGroup {
  val widget = MaterialButtonToggleGroup(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

//region textInputLayout
inline fun ViewGroup.textInputLayout(id: Int? = null, style: Int? = null, init: TextInputLayout.() -> Unit): TextInputLayout {
  val widget = TextInputLayout(wrapContextIfNeeded(context, style))
  if (id != null) widget.id = id
  return widget.apply(init).also { addView(it) }
}

inline fun Context.textInputLayout(id: Int? = null, style: Int? = null, init: TextInputLayout.() -> Unit): TextInputLayout {
  val widget = TextInputLayout(wrapContextIfNeeded(this, style))
  if (id != null) widget.id = id
  return widget.apply(init)
}
//endregion

// TabLayout extends HorizontalScrollView, HorizontalScrollView extends FrameLayout, LayoutParams: FrameLayout.LayoutParams

inline fun appBarParams(width: Int = wrapContent, height: Int = wrapContent, init: AppBarLayout.LayoutParams.() -> Unit) =
  AppBarLayout.LayoutParams(width, height).apply(init)

inline fun collapsingToolbarParams(width: Int = wrapContent, height: Int = wrapContent, init: CollapsingToolbarLayout.LayoutParams.() -> Unit) =
  CollapsingToolbarLayout.LayoutParams(width, height).apply(init)
