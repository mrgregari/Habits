package com.example.habits.presentation

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import com.example.habits.data.HabitRepositoryImpl
import com.example.habits.domain.usecases.UpdateHabitListUseCase
import com.example.habits.presentation.workers.ChangeStateWorkerFactory

class HabitsApp : Application(), Configuration.Provider {

    override fun onCreate() {
        super.onCreate()

        WorkManager.initialize(
            this,
            Configuration.Builder()
                .setWorkerFactory(
                    ChangeStateWorkerFactory(
                        UpdateHabitListUseCase(
                            HabitRepositoryImpl(this)
                        )
                    )
                )
                .build()
        )
    }

    override val workManagerConfiguration: Configuration
        get() {
            return Configuration.Builder()
                .setWorkerFactory(
                    ChangeStateWorkerFactory(
                        UpdateHabitListUseCase(
                            HabitRepositoryImpl(this)
                        )
                    )
                )
                .build()
        }


}
