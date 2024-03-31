package com.omidrezabagheriyan.barnamehrizitomobile.data.local

import androidx.room.Database
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task

@Database(entities = [Task::class], version = 1, exportSchema = true)
abstract class BarnamehRizitoDatabase {
    abstract fun barnamehRizitoDao(): BarnamehRizitoDao
}