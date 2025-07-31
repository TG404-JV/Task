package com.tg.societymanagment.model.repositry

import com.tg.societymanagment.data.ProjectTask
import com.tg.societymanagment.db.ProjectDao

class ProjectRepo(private val projectDao: ProjectDao)
{

    suspend fun getAllProject() = projectDao.getAllProject()

    suspend fun addProject(projectTask: ProjectTask) = projectDao.addProject(projectTask)

    suspend fun deleteProject(projectTask: ProjectTask) = projectDao.deleteProject(projectTask)

    suspend fun updateProject(projectTask: ProjectTask) = projectDao.updateProject(projectTask)




}