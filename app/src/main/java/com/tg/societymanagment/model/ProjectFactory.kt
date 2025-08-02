package com.tg.societymanagment.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tg.societymanagment.model.repositry.ProjectRepo
import java.lang.IllegalArgumentException

class ProjectFactory(private val repositry : ProjectRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProjectViewModel::class.java)) {
            return ProjectViewModel(repositry)  as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}