package com.example.habits.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.habits.domain.HabitState

@Entity(tableName = "habits")
data class HabitDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val days: Int,
    val state: HabitState
)
