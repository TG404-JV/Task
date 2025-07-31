package com.tg.societymanagment.model.repositry

import com.tg.societymanagment.data.Task
import com.tg.societymanagment.db.ListDao

class ListRepositry(private val listDao: ListDao) {
    suspend fun addTask(task: Task) = listDao.addTask(task)
    suspend fun getAllTask(): List<Task> {
        return listDao.getAllTask()
    }

    suspend fun deleteTask(id: Int) = listDao.deleteTask(id)
    suspend fun updateTask(id: Int, isCompleted: Boolean) = listDao.updateTask(id, isCompleted)

}