package com.example.habits.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habits.data.HabitRepositoryImpl
import com.example.habits.domain.Habit
import com.example.habits.domain.HabitState
import com.example.habits.domain.usecases.AddHabitUseCase
import kotlinx.coroutines.launch

class HabitViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = HabitRepositoryImpl(application)

    private val addHabitUseCase = AddHabitUseCase(repository)

    fun addHabit(habitName: String) {
        viewModelScope.launch {
            val habit = Habit(name = habitName, days = 0, state = HabitState.UNDONE)
            addHabitUseCase.addHabit(habit)
        }
    }



}