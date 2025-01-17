package com.example.habits.domain

enum class HabitState {
    UNDONE,
    DONE,
    FAILED;

    fun getNextState(): HabitState {
        return when(this) {
            UNDONE -> FAILED
            DONE -> UNDONE
            FAILED -> FAILED
        }
    }
}