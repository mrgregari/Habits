package com.example.habits.domain.usecases

import androidx.lifecycle.LiveData
import com.example.habits.domain.Habit
import com.example.habits.domain.HabitRepository

class GetHabitListUseCase(private val habitRepository: HabitRepository) {

    fun getHabitList() : LiveData<List<Habit>> {
        return habitRepository.getHabitList()
    }
}