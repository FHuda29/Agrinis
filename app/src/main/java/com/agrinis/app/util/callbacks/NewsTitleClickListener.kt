package com.agrinis.app.util.callbacks

import android.view.View
import com.agrinis.app.data.models.Article

interface NewsTitleClickListener {
    fun onClickItem(view: View, itemData: Article)
}