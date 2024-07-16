package com.marlonncarvalhosa.climafcil.data.di

import com.marlonncarvalhosa.climafcil.data.repositoryImpl.WeatherRepositoryImpl
import com.marlonncarvalhosa.climafcil.domain.repository.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
}