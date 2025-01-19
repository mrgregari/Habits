package com.example.habits.presentation

import android.app.AlarmManager
import android.app.PendingIntent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.habits.R
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setMidnightAlarm()
    }

    private fun setMidnightAlarm() {
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = MidnightReceiver.newIntent(this)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        /*
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }

        if (calendar.timeInMillis < System.currentTimeMillis()) {
            calendar.add(Calendar.DAY_OF_YEAR, 1)
        }

         */
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.SECOND, 3)
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)


        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            1000,
            //AlarmManager.INTERVAL_DAY,
            pendingIntent
        )


    }
}