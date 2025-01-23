package com.example.habits.presentation

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import com.example.habits.data.HabitRepositoryImpl
import com.example.habits.di.DaggerApplicationComponent
import com.example.habits.domain.usecases.UpdateHabitListUseCase
import com.example.habits.presentation.workers.ChangeStateWorkerFactory
import javax.inject.Inject

class HabitsApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: ChangeStateWorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()

        WorkManager.initialize(
            this,
            Configuration.Builder()
                .setWorkerFactory(workerFactory)
                .build()
        )
    }

    override val workManagerConfiguration: Configuration
        get() {
            return Configuration.Builder()
                .setWorkerFactory(workerFactory)
                .build()
        }


}
