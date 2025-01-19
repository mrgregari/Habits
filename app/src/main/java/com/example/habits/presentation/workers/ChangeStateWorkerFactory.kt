package com.example.habits.presentation.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.habits.domain.usecases.UpdateHabitListUseCase

class ChangeStateWorkerFactory (
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