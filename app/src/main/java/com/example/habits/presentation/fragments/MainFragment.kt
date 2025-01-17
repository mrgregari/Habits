package com.example.habits.presentation.fragments

import android.app.AlarmManager
import android.content.Context.ALARM_SERVICE
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.RecyclerView
import com.example.habits.R
import com.example.habits.databinding.FragmentMainBinding
import com.example.habits.presentation.adapters.HabitListAdapter
import com.example.habits.presentation.viewmodels.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: HabitListAdapter
    private lateinit var snackbar: Snackbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSwipeListener(binding.habitList)
        setupSnackbar()

        binding.addHabit.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_habitFragment)
        }

        adapter = HabitListAdapter()
        binding.habitList.adapter = adapter
        viewModel.habitList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


    }

    private fun setupSwipeListener(recyclerView: RecyclerView?) {
        val callback = object : SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val habit = adapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteHabit(habit)
                snackbar.show()
            }

        }

        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun setupSnackbar() {
        snackbar = Snackbar.make(binding.constraint,
            R.string.habit_deleted, Snackbar.LENGTH_LONG)
        snackbar.setAction(R.string.undo) {
            viewModel.undoDelete()
        }
    }

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMain == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
}