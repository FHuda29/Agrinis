package com.agrinis.app.data.models.response

import com.agrinis.app.data.persistence.entities.News

data class ArticleResponse(
    val articles: MutableList<News>,
    val status: String,
    val totalResults: Int,
)
