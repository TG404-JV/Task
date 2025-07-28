package com.tg.societymanagment.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tg.societymanagment.data.Task

@Dao
interface ListDao {

    @Insert
    suspend fun addTask(task : Task)

    @Query("SELECT * From task_table")
    suspend fun getAllTask() : List<Task>

    @Query("DELETE From task_table where id = :id")
    suspend fun deleteTask(id : Int)

    @Query("UPDATE task_table set isCompleted = :isCompleted where id = :id")
    suspend fun updateTask(id : Int,isCompleted : Boolean)

}