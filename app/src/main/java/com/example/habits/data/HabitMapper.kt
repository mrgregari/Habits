package com.example.habits.data

import com.example.habits.domain.Habit
import javax.inject.Inject

class HabitMapper @Inject constructor(){

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

    fun mapListEntityToListDbModel(listEntity : List<Habit>) = listEntity.map {
        mapEntityToDbModel(it)
    }

}