package com.agrinis.app.ui.article.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agrinis.app.data.models.response.ArticleResponse
import com.agrinis.app.data.persistence.entities.News
import com.agrinis.app.repository.ArticleRepository
import com.agrinis.app.util.Resource
import com.agrinis.app.util.constants.ApiConstants.DEFAULT_TOPIC
import com.agrinis.app.util.constants.ApiConstants.STARTING_PAGE_INDEX
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val articleRepository: ArticleRepository) : ViewModel(){
    val articles: MutableLiveData<Resource<ArticleResponse>> = MutableLiveData()
    private var newsResponse: ArticleResponse? = null
    var page = STARTING_PAGE_INDEX

    init {
        getAllArticles(DEFAULT_TOPIC)
    }

    fun getAllArticles(q: String) = viewModelScope.launch {
        articles.postValue(Resource.Loading())
        val response = articleRepository.getAllArticles(q, page)
        articles.postValue(handleArticlesResponse(response))
    }

    fun getAllNewArticles(q: String) = viewModelScope.launch {
        articles.postValue(Resource.Loading())
        val response = articleRepository.getAllArticles(q, page)
        articles.postValue(handleNewArticlesResponse(response))
    }

    private fun handleArticlesResponse(response: Response<ArticleResponse>): Resource<ArticleResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                page++
                if (newsResponse == null) {
                    newsResponse = it
                } else {
                    val oldArticles = newsResponse?.articles
                    val newArticles = it.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleNewArticlesResponse(response: Response<ArticleResponse>): Resource<ArticleResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    /*fun getFavoriteArticles() = articleRepository.getFavoriteArticles()

    fun addArticleToFavorites(article: News) = viewModelScope.launch {
        articleRepository.insert(article)
    }

    fun removeArticleFromFavorites(article: News) = viewModelScope.launch {
        articleRepository.deleteArticle(article)
    }*/
}