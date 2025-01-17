package com.example.habits.domain

data class Habit(
    val id: Int = UNDEFINED_ID,
    val name: String,
    val days: Int,
    val state: HabitState
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}

