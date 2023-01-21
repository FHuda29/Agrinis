package com.agrinis.app.ui.category.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agrinis.app.data.models.DataStatus
import com.agrinis.app.data.models.response.NewsResponse
import com.agrinis.app.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(private val newsRepository: NewsRepository): ViewModel() {
    val topHeadlines = MutableLiveData<DataStatus<NewsResponse>>()
    val topScienceHeadlines = MutableLiveData<DataStatus<NewsResponse>>()
    val topSportsHeadlines = MutableLiveData<DataStatus<NewsResponse>>()
    val topBusinessHeadlines = MutableLiveData<DataStatus<NewsResponse>>()
    val topEntertainmentHeadlines = MutableLiveData<DataStatus<NewsResponse>>()

    fun getTopHeadlines() {
        viewModelScope.launch {
            val data = newsRepository.topheadlines()
            topHeadlines.postValue(data)
        }
    }

    fun getTopScienceHeadlines() {
        viewModelScope.launch {
            val data = newsRepository.topheadlinesByScience()
            topScienceHeadlines.postValue(data)
        }
    }

    fun getTopSportsHeadlines() {
        viewModelScope.launch {
            val data = newsRepository.topheadlinesBySports()
            topSportsHeadlines.postValue(data)
        }
    }

    fun getTopBusinessHeadlines() {
        viewModelScope.launch {
            val data = newsRepository.topheadlinesByBusiness()
            topBusinessHeadlines.postValue(data)
        }
    }

    fun getTopEntertainmentHeadlines() {
        viewModelScope.launch {
            val data = newsRepository.topheadlinesByEntertainment()
            topEntertainmentHeadlines.postValue(data)
        }
    }
}