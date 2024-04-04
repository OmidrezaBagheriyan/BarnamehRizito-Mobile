package com.omidrezabagheriyan.barnamehrizitomobile.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.TaskStatus
import com.omidrezabagheriyan.barnamehrizitomobile.domain.repositories.BarnamehRizitoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(private val repository: BarnamehRizitoRepository) :
    ViewModel() {

    private val _taskList = MutableStateFlow<List<Task>>(emptyList())
    val taskList: StateFlow<List<Task>> = _taskList.asStateFlow()

    private val _doneList = MutableStateFlow<List<Task>>(emptyList())
    val doneList: StateFlow<List<Task>> = _doneList.asStateFlow()

    fun showTasks(taskStatus: TaskStatus) {
        viewModelScope.launch {
            repository.getTaskByStatus(taskStatus).collect { list ->
                _taskList.emit(list)
            }
        }
    }

    fun showDones(taskStatus: TaskStatus) {
        viewModelScope.launch {
            repository.getTaskByStatus(taskStatus).collect { list ->
                _doneList.emit(list)
            }
        }
    }
}