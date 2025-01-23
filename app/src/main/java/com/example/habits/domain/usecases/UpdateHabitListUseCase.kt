package com.example.habits.domain.usecases

import com.example.habits.domain.HabitRepository
import javax.inject.Inject

class UpdateHabitListUseCase @Inject constructor(
    private val habitRepository: HabitRepository
) {

    suspend fun updateHabitList() {

        val habitList = habitRepository.getHabitsListSync()
        val updatedHabitList = habitList.map { habit ->
            habit.copy(state = habit.state.getNextState())
        }

        return habitRepository.updateHabitList(updatedHabitList)
    }
}