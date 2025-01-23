package com.example.habits.domain.usecases

import androidx.lifecycle.LiveData
import com.example.habits.domain.Habit
import com.example.habits.domain.HabitRepository
import javax.inject.Inject

class GetHabitListUseCase @Inject constructor(
    private val habitRepository: HabitRepository
) {

    fun getHabitList(): LiveData<List<Habit>> {
        return habitRepository.getHabitList()
    }
}