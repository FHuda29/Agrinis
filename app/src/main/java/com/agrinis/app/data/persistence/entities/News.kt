package com.agrinis.app.data.persistence.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.agrinis.app.data.models.Source
import java.io.Serializable

@Entity(tableName = "articles")
data class News (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String?,
    val source: Source?,
    val content: String?,
) : Serializable