package com.tg.societymanagment.db

import android.content.Context
import androidx.room.Room
import com.tg.societymanagment.model.repositry.ListRepositry

object DatabaseHelper {

    @Volatile
    private var Instance : TaskDatabase ? = null

    fun getDatabase(context: Context): TaskDatabase {
        return Instance ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                TaskDatabase::class.java,
                "task_database"
            ).build()
            Instance = instance
            instance
        }
    }




}