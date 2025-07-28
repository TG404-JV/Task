package com.tg.societymanagment.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tg.societymanagment.model.repositry.ListRepositry

class ListModelFactor(private val repository: ListRepositry) : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}