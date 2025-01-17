package com.example.habits.presentation.viewmodels

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.Context.ALARM_SERVICE
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.habits.data.HabitRepositoryImpl
import com.example.habits.domain.Habit
import com.example.habits.domain.usecases.AddHabitUseCase
import com.example.habits.domain.usecases.DeleteHabitUseCase
import com.example.habits.domain.usecases.GetHabitListUseCase
import com.example.habits.presentation.MidnightReceiver
import kotlinx.coroutines.launch
import java.util.Calendar

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = HabitRepositoryImpl(application)

    private val getHabitListUseCase = GetHabitListUseCase(repository)
    private val deleteHabitUseCase = DeleteHabitUseCase(repository)
    private val addHabitUseCase = AddHabitUseCase(repository)

    val habitList = getHabitListUseCase.getHabitList()

    private lateinit var habitForDelete: Habit

    fun deleteHabit(habit: Habit) {
        viewModelScope.launch {
            habitForDelete = habit
            deleteHabitUseCase.deleteHabit(habit)
        }
    }

    fun undoDelete() {
        viewModelScope.launch {
            addHabitUseCase.addHabit(habitForDelete)
        }
    }

    fun changeHabitState(habit: Habit) {

    }


    fun setMidnightAlarm() {
        val alarmManager =
            getApplication<Application>().getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = MidnightReceiver.newIntent(getApplication())
        val pendingIntent = PendingIntent.getBroadcast(
            getApplication(),
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
        calendar.add(Calendar.SECOND, 10)
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

        /*
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )

         */
    }

}