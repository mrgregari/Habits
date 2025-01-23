package com.example.habits.domain.usecases

import com.example.habits.domain.Habit
import com.example.habits.domain.HabitRepository
import javax.inject.Inject

class DeleteHabitUseCase @Inject constructor(
    private val habitRepository: HabitRepository
) {

    suspend fun deleteHabit(habit: Habit) {
        return habitRepository.deleteHabit(habit)
    }
}