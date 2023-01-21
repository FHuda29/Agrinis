package com.agrinis.app.data.models.response

import com.agrinis.app.data.models.Article
import com.squareup.moshi.Json

data class NewsResponse(
    /*@Json(name = "articles") val articles: List<Article>,
    @Json(name = "status") val status: String,
    @Json(name = "totalResults") val totalResults: Int*/
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
