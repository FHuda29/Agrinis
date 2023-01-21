package com.agrinis.app.repository

import com.agrinis.app.data.models.DataStatus
import com.agrinis.app.data.models.response.NewsResponse
import com.agrinis.app.network.ApiService
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: ApiService
) : NewsRepository {
    override suspend fun topheadlines(): DataStatus<NewsResponse> {
        val data = newsService.getTopHeadlines()
        return if (data.isSuccessful) DataStatus.success(data.body()) else DataStatus.error("headline Error")
    }

    override suspend fun topheadlinesByScience(): DataStatus<NewsResponse> {
        val data = newsService.getTopHeadlinesByCategory(category = "science", pageSize = 5)
        return if (data.isSuccessful) DataStatus.success(data.body()) else DataStatus.error("science Error")
    }

    override suspend fun topheadlinesBySports(): DataStatus<NewsResponse> {
        val data = newsService.getTopHeadlinesByCategory(category = "sports", pageSize = 5)
        return if (data.isSuccessful) DataStatus.success(data.body()) else DataStatus.error("sports Error")
    }

    override suspend fun topheadlinesByBusiness(): DataStatus<NewsResponse> {
        val data = newsService.getTopHeadlinesByCategory(category = "business", pageSize = 5)
        return if (data.isSuccessful) DataStatus.success(data.body()) else DataStatus.error("business Error")
    }

    override suspend fun topheadlinesByEntertainment(): DataStatus<NewsResponse> {
        val data = newsService.getTopHeadlinesByCategory(category = "entertainment", pageSize = 5)
        return if (data.isSuccessful) DataStatus.success(data.body()) else DataStatus.error("entertainment Error")
    }
}