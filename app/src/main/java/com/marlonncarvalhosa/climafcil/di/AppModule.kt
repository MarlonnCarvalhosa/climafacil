package com.marlonncarvalhosa.climafcil.di

import com.marlonncarvalhosa.climafcil.data.di.networkModule
import com.marlonncarvalhosa.climafcil.data.di.repositoryModule
import com.marlonncarvalhosa.climafcil.domain.di.useCaseModule
import com.marlonncarvalhosa.climafcil.presentation.di.viewModelModule
import org.koin.core.module.Module

val appModules: List<Module> = listOf(
    networkModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)