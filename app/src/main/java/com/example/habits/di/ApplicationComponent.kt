package com.example.habits.di

import android.app.Application
import com.example.habits.presentation.HabitsApp
import com.example.habits.presentation.fragments.HabitFragment
import com.example.habits.presentation.fragments.MainFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: MainFragment)

    fun inject(fragment: HabitFragment)

    fun inject(application: HabitsApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}