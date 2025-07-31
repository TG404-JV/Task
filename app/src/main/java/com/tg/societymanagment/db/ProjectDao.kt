package com.tg.societymanagment.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tg.societymanagment.data.ProjectTask

@Dao
interface ProjectDao {

    @Query("SELECT * FROM projects")
    suspend fun getAllProject(): List<ProjectTask>

    @Insert
    suspend fun addProject(projectTask: ProjectTask)

    @Delete
    suspend fun deleteProject(projectTask: ProjectTask)

    @Update
    suspend fun  updateProject(projectTask: ProjectTask)

}