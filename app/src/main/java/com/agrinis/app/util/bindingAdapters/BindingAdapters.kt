package com.agrinis.app.util.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.agrinis.app.util.extensions.loadImageFromUrl

@BindingAdapter("android:urlSrc")
fun urlSrc(view: ImageView, url: String?){
    view.loadImageFromUrl(url)
}