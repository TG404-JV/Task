package com.tg.societymanagment.model.repositry

import com.tg.societymanagment.data.Task
import com.tg.societymanagment.db.ListDao
import com.tg.societymanagment.dummyData.getTask
import java.sql.Time

class ListRepositry(private val listDao: ListDao) {
    suspend fun addTask(task: Task) = listDao.addTask(task)
    suspend fun getAllTask(): List<Task> {
        val list = listDao.getAllTask()
        if (list.isEmpty()) {
            getTask().forEach {
                listDao.addTask(it)
            }
        }

        return listDao.getAllTask()

    }

    suspend fun deleteTask(id: Int) = listDao.deleteTask(id)
    suspend fun updateTask(id: Int, isCompleted: Boolean) = listDao.updateTask(id, isCompleted)

}