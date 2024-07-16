package com.marlonncarvalhosa.climafcil.domain.di

import com.marlonncarvalhosa.climafcil.domain.usecase.GetWeatherUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetWeatherUseCase(get()) }
}