package com.marlonncarvalhosa.climafcil.presentation.di

import com.marlonncarvalhosa.climafcil.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WeatherViewModel(get()) }
}