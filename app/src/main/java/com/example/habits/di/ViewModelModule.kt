package com.example.habits.di

import androidx.lifecycle.ViewModel
import com.example.habits.presentation.viewmodels.HabitViewModel
import com.example.habits.presentation.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HabitViewModel::class)
    fun bindHabitViewModel(viewModel: HabitViewModel) : ViewModel
}