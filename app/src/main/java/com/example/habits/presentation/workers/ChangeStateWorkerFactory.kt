package com.example.habits.presentation.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.habits.domain.usecases.UpdateHabitListUseCase
import javax.inject.Inject

class ChangeStateWorkerFactory @Inject constructor(
    private val updateHabitListUseCase: UpdateHabitListUseCase
): WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker {
        return ChangeStateWorker(
            appContext,
            workerParameters,
            updateHabitListUseCase
        )
    }
}