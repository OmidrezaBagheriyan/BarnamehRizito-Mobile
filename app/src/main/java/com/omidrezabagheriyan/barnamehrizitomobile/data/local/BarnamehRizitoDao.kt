package com.omidrezabagheriyan.barnamehrizitomobile.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.TaskStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface BarnamehRizitoDao {
    @Query("SELECT * FROM task_db")
    fun getAllTask(): Flow<List<Task>>

    @Query("SELECT * FROM task_db WHERE taskStatus == :taskStatus")
    fun getTaskByStatus(taskStatus: TaskStatus): Flow<List<Task>>

    @Query("SELECT * FROM task_db WHERE id == :id")
    fun getTaskById(id: Int): Flow<Task>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)
}