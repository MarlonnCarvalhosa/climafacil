package com.marlonncarvalhosa.climafcil.data.remote.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.marlonncarvalhosa.climafcil.data.service.ForecastService
import com.marlonncarvalhosa.climafcil.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideGson() }
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), get()) }
    single { provideGetForecastService(get()) }
}

fun provideGson(): Gson {
    return GsonBuilder().create()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

fun provideGetForecastService(retrofit: Retrofit): ForecastService {
    return retrofit.create(ForecastService::class.java)
}