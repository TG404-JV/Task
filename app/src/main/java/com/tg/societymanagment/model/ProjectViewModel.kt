package com.tg.societymanagment.model

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tg.societymanagment.data.ProjectTask
import com.tg.societymanagment.model.repositry.ProjectRepo
import kotlinx.coroutines.launch

class ProjectViewModel(private val projectRepo : ProjectRepo) : ViewModel()
{
    val _projectList = MutableLiveData<List<ProjectTask>>()
    val projectList : LiveData<List<ProjectTask>> get() = _projectList

    init {
        viewModelScope.launch {
            _projectList.value = projectRepo.getAllProject()
        }
    }

}