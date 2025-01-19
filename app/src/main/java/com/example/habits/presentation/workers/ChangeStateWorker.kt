package com.example.habits.presentation.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.habits.domain.usecases.UpdateHabitListUseCase

class ChangeStateWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val updateHabitListUseCase: UpdateHabitListUseCase
) : CoroutineWorker(context, workerParameters) {


    override suspend fun doWork(): Result {
        Log.d("WORK", "doWork")

        updateHabitListUseCase.updateHabitList()

        return Result.success()
    }
}