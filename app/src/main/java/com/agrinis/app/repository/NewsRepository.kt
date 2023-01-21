package com.agrinis.app.repository

import com.agrinis.app.data.models.DataStatus
import com.agrinis.app.data.models.response.NewsResponse

interface NewsRepository {
    suspend fun topheadlines(): DataStatus<NewsResponse>
    suspend fun topheadlinesByScience(): DataStatus<NewsResponse>
    suspend fun topheadlinesBySports(): DataStatus<NewsResponse>
    suspend fun topheadlinesByBusiness(): DataStatus<NewsResponse>
    suspend fun topheadlinesByEntertainment(): DataStatus<NewsResponse>
}