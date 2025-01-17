package com.example.habits.presentation

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.habits.data.HabitRepositoryImpl

class ChangeStateWorker(
    context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {


    override fun doWork(): Result {
        Log.d("WORK", "doWork")

        return Result.success()
    }
}