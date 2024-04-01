package com.omidrezabagheriyan.barnamehrizitomobile.domain.repositories

import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.TaskStatus
import com.omidrezabagheriyan.barnamehrizitomobile.data.local.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BarnamehRizitoRepository @Inject constructor(private val localDataSource: LocalDataSource) {

    fun getAllTask(): Flow<List<Task>> = localDataSource.getAllTask()

    fun getTaskByStatus(taskStatus: TaskStatus): Flow<List<Task>> =
        localDataSource.getTaskByStatus(taskStatus)

    fun getTaskById(id: Int): Flow<Task> = localDataSource.getTaskById(id)

    suspend fun insertTask(task: Task) {
        localDataSource.insertTask(task)
    }

    suspend fun deleteTask(task: Task) {
        localDataSource.deleteTask(task)
    }

    suspend fun updateTask(task: Task) {
        localDataSource.updateTask(task)
    }
}