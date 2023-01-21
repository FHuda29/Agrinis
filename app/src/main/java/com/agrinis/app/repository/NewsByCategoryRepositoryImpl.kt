package com.agrinis.app.repository

import com.agrinis.app.network.ApiService
import com.agrinis.app.network.request
import kotlinx.coroutines.flow.flow

class NewsByCategoryRepositoryImpl(
    private val service: ApiService,
) : NewsByCategoryRepository {

    override suspend fun topheadlinesByBusiness() = flow {
        request { service.getTopHeadlinesByCategory(category = "business") }
            .collect { result ->
                emit(result)
            }
    }

    override suspend fun topheadlinesByEntertainment() = flow {
        request { service.getTopHeadlinesByCategory(category = "entertainment") }
            .collect { result ->
                emit(result)
            }
    }

    override suspend fun topheadlinesByGeneral() = flow {
        request { service.getTopHeadlinesByCategory(category = "general") }
            .collect { result ->
                emit(result)
            }
    }

    override suspend fun topheadlinesByHealth() = flow {
        request { service.getTopHeadlinesByCategory(category = "health") }
            .collect { result ->
                emit(result)
            }
    }

    override suspend fun topheadlinesByScience() = flow {
        request { service.getTopHeadlinesByCategory(category = "science") }
            .collect { result ->
                emit(result)
            }
    }

    override suspend fun topheadlinesBySports() = flow {
        request { service.getTopHeadlinesByCategory(category = "sports") }
            .collect { result ->
                emit(result)
            }
    }

    override suspend fun topheadlinesByTechnology() = flow {
        request { service.getTopHeadlinesByCategory(category = "technology") }
            .collect { result ->
                emit(result)
            }
    }

}