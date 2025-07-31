package com.tg.societymanagment.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tg.societymanagment.data.ProjectTask


open class Converters {


    @TypeConverter
    fun fromPair(projectTask: List<Pair<String, String>>): String {

        return Gson().toJson(projectTask)
    }

    @TypeConverter
    fun toPair(projectTask: String):List<Pair<String, String>>
    {
       val mapType = object :  TypeToken<Map<String, String>>(){}.type
        return Gson().fromJson(projectTask,mapType)
        
    }

}