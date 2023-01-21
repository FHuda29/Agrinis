package com.agrinis.app.data.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.agrinis.app.data.persistence.entities.News

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: News)

    @Delete
    suspend fun deleteArticle(article: News)

    @Query("SELECT * FROM articles")
    fun getArticles(): LiveData<List<News>>
}