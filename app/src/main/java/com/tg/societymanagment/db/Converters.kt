package com.tg.societymanagment.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromPair(projectTask: List<Pair<String, String>>): String {
        return Gson().toJson(projectTask)
    }

    @TypeConverter
    fun toPair(projectTask: String): List<Pair<String, String>> {
        val listType = object : TypeToken<List<Pair<String, String>>>() {}.type
        return Gson().fromJson(projectTask, listType)
    }
}
