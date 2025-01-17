package com.example.habits.domain

import androidx.lifecycle.LiveData

interface HabitRepository {

    suspend fun addHabit(habit: Habit)

    suspend fun deleteHabit(habit: Habit)

    suspend fun editHabit(habit: Habit)

    suspend fun updateHabitList(habitList: List<Habit>)

    suspend fun getHabitById(habitId: Int): Habit

    fun getHabitList(): LiveData<List<Habit>>
}