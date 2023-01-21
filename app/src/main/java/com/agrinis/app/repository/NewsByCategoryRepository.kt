package com.agrinis.app.repository

import com.agrinis.app.data.models.response.NewsResponse
import com.agrinis.app.network.Resource
import kotlinx.coroutines.flow.Flow

interface NewsByCategoryRepository {
    suspend fun topheadlinesByBusiness(): Flow<Resource<NewsResponse>>
    suspend fun topheadlinesByEntertainment(): Flow<Resource<NewsResponse>>
    suspend fun topheadlinesByGeneral(): Flow<Resource<NewsResponse>>
    suspend fun topheadlinesByHealth(): Flow<Resource<NewsResponse>>
    suspend fun topheadlinesByScience(): Flow<Resource<NewsResponse>>
    suspend fun topheadlinesBySports(): Flow<Resource<NewsResponse>>
    suspend fun topheadlinesByTechnology(): Flow<Resource<NewsResponse>>
}