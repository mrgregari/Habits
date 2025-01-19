package com.example.habits.presentation

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.habits.presentation.workers.ChangeStateWorker

class MidnightReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.d("ALARM", "alarm")

        context?.let {
            val workRequest = OneTimeWorkRequestBuilder<ChangeStateWorker>().build()
            WorkManager.getInstance(it).enqueue(workRequest)
        }

    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MidnightReceiver::class.java)
        }
    }
}