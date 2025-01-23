package com.example.habits.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.habits.R
import com.example.habits.databinding.FragmentHabitBinding
import com.example.habits.presentation.HabitsApp
import com.example.habits.presentation.viewmodels.HabitViewModel
import com.example.habits.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject

class HabitFragment : Fragment() {

    companion object {
        fun newInstance() = HabitFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as HabitsApp).component
    }

    private lateinit var viewModel: HabitViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this, viewModelFactory)[HabitViewModel::class.java]
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