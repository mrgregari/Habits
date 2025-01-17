package com.example.habits.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.habits.data.db.AppDatabase
import com.example.habits.domain.Habit
import com.example.habits.domain.HabitRepository

class HabitRepositoryImpl(
    application: Application
) : HabitRepository {

    val habitsDao = AppDatabase.getInstance(application).habitDao()
    val mapper = HabitMapper()

    override suspend fun addHabit(habit: Habit) {
        habitsDao.addHabit(mapper.mapEntityToDbModel(habit))
    }

    override suspend fun deleteHabit(habit: Habit) {
        habitsDao.deleteHabit(habit.id)
    }

    override suspend fun editHabit(habit: Habit) {
        habitsDao.addHabit(mapper.mapEntityToDbModel(habit))
    }

    override suspend fun updateHabitList(habitList: List<Habit>) {
        habitsDao.updateHabitList(mapper.mapListEntityToListDbModel(habitList))
    }

    override suspend fun getHabitById(habitId: Int): Habit {
        val dbModel = habitsDao.getHabit(habitId)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun getHabitList(): LiveData<List<Habit>> =
        MediatorLiveData<List<Habit>>().apply {
            addSource(habitsDao.getHabitsList()) {
                value = mapper.mapListDbModelToListEntity(it)
            }
        }

}