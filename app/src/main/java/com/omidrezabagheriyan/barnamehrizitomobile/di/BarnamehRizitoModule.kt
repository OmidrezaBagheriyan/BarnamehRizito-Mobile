package com.omidrezabagheriyan.barnamehrizitomobile.di

import android.content.Context
import androidx.room.Room
import com.omidrezabagheriyan.barnamehrizitomobile.data.local.BarnamehRizitoDao
import com.omidrezabagheriyan.barnamehrizitomobile.data.local.BarnamehRizitoDatabase
import com.omidrezabagheriyan.barnamehrizitomobile.data.local.LocalDataSource
import com.omidrezabagheriyan.barnamehrizitomobile.domain.repositories.BarnamehRizitoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BarnamehRizitoModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): BarnamehRizitoDatabase =
        Room.databaseBuilder(
            context,
            BarnamehRizitoDatabase::class.java,
            "TaskManagement"
        ).build()

    @Singleton
    @Provides
    fun provideDao(database: BarnamehRizitoDatabase): BarnamehRizitoDao = database.barnamehRizitoDao()

    @Singleton
    @Provides
    fun provideTaskManagementRepository(
        localDataSource: LocalDataSource
    ):BarnamehRizitoRepository = BarnamehRizitoRepository(localDataSource)
}

