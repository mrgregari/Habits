package com.example.habits.domain.usecases

import com.example.habits.domain.HabitRepository

class UpdateHabitListUseCase(private val habitRepository: HabitRepository) {

    suspend fun updateHabitList() {

        val habitList = habitRepository.getHabitList().value.orEmpty()
        val updatedHabitList = habitList.map { habit ->
            habit.copy(state = habit.state.getNextState())
        }

        return habitRepository.updateHabitList(updatedHabitList)
    }
}