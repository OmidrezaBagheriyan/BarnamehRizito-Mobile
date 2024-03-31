package com.omidrezabagheriyan.barnamehrizitomobile.data.local

import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.TaskStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val barnamehRizitoDao: BarnamehRizitoDao) {

    fun getAllTask(): Flow<List<Task>> = barnamehRizitoDao.getAllTask()

    fun getTaskByStatus(taskStatus: TaskStatus): Flow<List<Task>> =
        barnamehRizitoDao.getTaskByStatus(taskStatus)

    fun getTaskById(id: Int): Flow<Task> = barnamehRizitoDao.getTaskById(id)

    suspend fun insertTask(task: Task) {
        barnamehRizitoDao.insertTask(task)
    }

    suspend fun deleteTask(task: Task) {
        barnamehRizitoDao.deleteTask(task)
    }

    suspend fun updateTask(task: Task) {
        barnamehRizitoDao.updateTask(task)
    }
}