package com.agrinis.app.data.models.local

import androidx.room.TypeConverter
import com.agrinis.app.data.models.Source
class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}