package com.agrinis.app.util.extensions

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.initHorizontal(context: Context?){
    setHasFixedSize(true)
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
}