package com.example.habits.presentation

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MidnightReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.d("ALARM", "alarm")

    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MidnightReceiver::class.java)
        }
    }
}