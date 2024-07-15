package com.marlonncarvalhosa.climafcil.di

import com.marlonncarvalhosa.climafcil.data.remote.di.networkModule
import org.koin.core.module.Module

val appModules: List<Module> = listOf(
    networkModule
)