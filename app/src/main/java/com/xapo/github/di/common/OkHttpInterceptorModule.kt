package com.mabnadp.rahavard365.di.common


import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Singleton

@Module
object OkHttpInterceptorModule {


    @Singleton
    @Provides
    @JvmStatic
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.tag("OkHttp").d(message) })
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging


    }


}
