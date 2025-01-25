package com.example.habits.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.habits.R
import com.example.habits.databinding.FragmentHabitBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class HabitBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var _binding : FragmentHabitBottomSheetBinding? = null
    private val binding : FragmentHabitBottomSheetBinding
        get() = _binding ?: throw RuntimeException("FragmentHabitBottomSheet == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHabitBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }


}