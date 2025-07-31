package com.tg.societymanagment.db

import androidx.room.Database
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tg.societymanagment.data.ProjectTask
import com.tg.societymanagment.data.Task

@Database(entities = [Task::class, ProjectTask::class], version = 2)
@TypeConverters(Converters::class)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun listDao(): ListDao
    abstract fun projectDao(): ProjectDao

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }
}