package com.tg.societymanagment.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tg.societymanagment.data.Task
import com.tg.societymanagment.model.repositry.ListRepositry
import kotlinx.coroutines.launch

class ListModel (private val repository: ListRepositry) : ViewModel() {

    private val _taskList =
        MutableLiveData<List<Task>>()  // Main Task List Whose Values Never Going To Change
     val taskList: LiveData<List<Task>> get() = _taskList


    fun loadTaskList() {
        viewModelScope.launch {
            _taskList.value = repository.getAllTask()

        }
    }

    fun addTask(task: Task)
    {
        viewModelScope.launch {
            repository.addTask(task)
        }

    }

}