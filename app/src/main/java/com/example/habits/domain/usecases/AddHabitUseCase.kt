package com.example.habits.domain.usecases

import com.example.habits.domain.Habit
import com.example.habits.domain.HabitRepository

class AddHabitUseCase(private val habitRepository: HabitRepository) {

    suspend fun addHabit(habit: Habit) {
        return habitRepository.addHabit(habit)
    }
}