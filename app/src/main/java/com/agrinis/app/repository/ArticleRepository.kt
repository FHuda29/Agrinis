package com.agrinis.app.repository


import com.agrinis.app.network.ApiService
import com.agrinis.app.util.constants.ApiConstants.API_KEY
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val newsApi: ApiService
) {

    suspend fun getAllArticles(searchQuery: String, pageNumber: Int) =
        newsApi.getNews(searchQuery, pageNumber, API_KEY)

    /*fun getFavoriteArticles() = database.articleDao().getArticles()

    suspend fun insert(article: News) = database.articleDao().insert(article)

    suspend fun deleteArticle(article: News) = database.articleDao().deleteArticle(article)*/
}