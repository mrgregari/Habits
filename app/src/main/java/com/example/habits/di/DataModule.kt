package com.example.habits.di

import android.app.Application
import com.example.habits.data.HabitRepositoryImpl
import com.example.habits.data.db.AppDatabase
import com.example.habits.data.db.HabitDao
import com.example.habits.domain.HabitRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindHabitRepository(impl: HabitRepositoryImpl): HabitRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideHabitsDao(
            application: Application
        ): HabitDao {
            return AppDatabase.getInstance(application).habitDao()
        }
    }
}