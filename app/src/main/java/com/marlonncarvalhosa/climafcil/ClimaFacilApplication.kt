package com.marlonncarvalhosa.climafcil

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.marlonncarvalhosa.climafcil.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ClimaFacilApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = applicationContext
        startKoin{
            androidContext(this@ClimaFacilApplication)
            modules(appModules)
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var instance: Context? = null
            private set
    }
}