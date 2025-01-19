package com.example.habits.presentation.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.habits.databinding.HabitItemBinding
import com.example.habits.domain.Habit
import com.example.habits.domain.HabitState

class HabitListAdapter : ListAdapter<Habit, HabitViewHolder>(HabitDiffCallback) {

    var onHabitButtonClickListener: ((Habit) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = HabitItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HabitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = getItem(position)
        with(holder.binding) {
            with(habit) {
                habitName.text = name
                daysCount.text = days.toString()
                habitButton.setOnClickListener {
                    onHabitButtonClickListener?.invoke(habit)
                }

                when (state) {
                    HabitState.UNDONE -> habitButton.setBackgroundColor(Color.YELLOW)
                    HabitState.DONE -> habitButton.setBackgroundColor(Color.GREEN)
                    HabitState.FAILED -> habitButton.setBackgroundColor(Color.RED)
                }


            }
        }
    }
}