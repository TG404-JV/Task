package com.tg.societymanagment.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class ProjectTask(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val projectName : String,
    val category : String,
    val projectTask : List<Pair<String, String>>,
    val date : String,
    val isCompleted : Boolean
)
