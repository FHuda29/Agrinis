package com.agrinis.app.network

import com.agrinis.app.data.models.response.ArticleResponse
import com.agrinis.app.data.models.response.FooResponse
import com.agrinis.app.data.models.response.NewsResponse
import com.agrinis.app.util.constants.ApiConstants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Created by Arca International on 21/11/2022
 */
interface ApiService {

    @GET("everything")
    suspend fun getNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int,
        @Query("apiKey") apiKey: String = API_KEY,
    ): Response<ArticleResponse>

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "id",
        @Query("pageSize") pageSize: Int = 5,
        @Query("apiKey") apiKey: String = API_KEY,
    ): Response<NewsResponse>

    @GET("top-headlines")
    suspend fun getTopHeadlinesByCategory(
        @Query("category") category: String,
        @Query("country") country: String = "id",
        @Query("pageSize") pageSize: Int = 10,
        @Query("apiKey") apiKey: String = API_KEY,
    ): Response<NewsResponse>

    @GET("/foo")
    suspend fun foo(): Response<FooResponse>
}