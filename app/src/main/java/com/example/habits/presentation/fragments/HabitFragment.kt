package com.example.habits.presentation.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.habits.R
import com.example.habits.databinding.FragmentHabitBinding
import com.example.habits.presentation.viewmodels.HabitViewModel

class HabitFragment : Fragment() {

    companion object {
        fun newInstance() = HabitFragment()
    }

    private val viewModel: HabitViewModel by viewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveHabitButton.setOnClickListener {
            viewModel.addHabit(binding.habitName.text.toString())
            findNavController().navigate(R.id.action_habitFragment_to_mainFragment)
        }
    }

    private var _binding: FragmentHabitBinding? = null
    private val binding: FragmentHabitBinding
        get() = _binding ?: throw RuntimeException("FragmentHabit == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHabitBinding.inflate(inflater, container, false)
        return binding.root
    }
}