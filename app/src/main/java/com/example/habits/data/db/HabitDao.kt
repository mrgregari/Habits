package com.example.habits.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.habits.data.HabitDbModel

@Dao
interface HabitDao {

    @Query("SELECT * FROM habits")
    fun getHabitsList(): LiveData<List<HabitDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHabit(habit: HabitDbModel)

    @Query("DELETE FROM habits WHERE id=:habitId")
    suspend fun deleteHabit(habitId: Int)

    @Query("SELECT * FROM habits WHERE id=:habitId LIMIT 1")
    suspend fun getHabit(habitId: Int): HabitDbModel

    @Update
    suspend fun updateHabitList(habitList: List<HabitDbModel>)

    @Query("SELECT * FROM habits")
    suspend fun getHabitsListSync(): List<HabitDbModel>
}