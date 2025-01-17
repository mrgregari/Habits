package com.example.habits.data

import com.example.habits.domain.Habit

class HabitMapper {

    fun mapDbModelToEntity(habitDbModel: HabitDbModel) = Habit(
        habitDbModel.id,
        habitDbModel.name,
        habitDbModel.days,
        habitDbModel.state
    )

    fun mapEntityToDbModel(habit: Habit) = HabitDbModel(
        habit.id,
        habit.name,
        habit.days,
        habit.state
    )

    fun mapListDbModelToListEntity(listDbModel: List<HabitDbModel>) = listDbModel.map {
        mapDbModelToEntity(it)
    }

}