package com.omidrezabagheriyan.barnamehrizitomobile.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.omidrezabagheriyan.barnamehrizitomobile.domain.models.Task

@Database(entities = [Task::class], version = 1, exportSchema = true)
abstract class BarnamehRizitoDatabase : RoomDatabase() {
    abstract fun barnamehRizitoDao(): BarnamehRizitoDao
}