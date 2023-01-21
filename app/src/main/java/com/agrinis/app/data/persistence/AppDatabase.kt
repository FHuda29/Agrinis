package com.agrinis.app.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.agrinis.app.data.models.local.Converters
import com.agrinis.app.data.persistence.dao.ArticleDao
import com.agrinis.app.data.persistence.entities.News
/**
 * @author Created by Arca International on 21/11/2022
 */
// TODO: insert entity to database entities below
@Database(entities = [News::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    // TODO: declare DAO here
    abstract fun articleDao() : ArticleDao
}