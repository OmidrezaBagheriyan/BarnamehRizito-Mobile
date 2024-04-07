package com.omidrezabagheriyan.barnamehrizitomobile.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task
import com.omidrezabagheriyan.barnamehrizitomobile.domain.repositories.BarnamehRizitoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: BarnamehRizitoRepository) :
    ViewModel() {

    private val _details = MutableSharedFlow<Task>()
    val details: SharedFlow<Task> = _details.asSharedFlow()

    fun taskById(id: Int) {
        viewModelScope.launch {
            repository.getTaskById(id).collect { task ->
                _details.emit(task)
            }
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }
}