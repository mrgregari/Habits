package com.example.habits.domain.usecases

import com.example.habits.domain.Habit
import com.example.habits.domain.HabitRepository
import javax.inject.Inject

class EditHabitUseCase @Inject constructor(
    private val habitRepository: HabitRepository
) {

    suspend fun editHabit(habit: Habit) {
        return habitRepository.editHabit(habit)
    }
}