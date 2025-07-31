package com.tg.societymanagment.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity (tableName = "task_table")
data class Task(

    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val Title : String,
    val subTitle : String,
    val Category : String,
    val startTime : String,
    val endTIme : String,
    val isCompleted : Boolean,
    val isImportant : Boolean
)
