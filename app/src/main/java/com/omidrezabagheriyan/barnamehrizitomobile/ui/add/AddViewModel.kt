package com.omidrezabagheriyan.barnamehrizitomobile.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task
import com.omidrezabagheriyan.barnamehrizitomobile.domain.repositories.BarnamehRizitoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val repository: BarnamehRizitoRepository) :
    ViewModel() {

    fun addTask(task: Task) {
        viewModelScope.launch {
            repository.insertTask(task)
        }
    }
}