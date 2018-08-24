package com.xapo.github.di


import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.google.gson.Gson

import com.xapo.github.Github
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
object AndroidModule {


    @Provides
    @Singleton
    @JvmStatic
    fun provideContext(application: Github): Context {
        return application.applicationContext
    }


    @Provides
    @Singleton
    @JvmStatic
    fun provideResources(application: Github): Resources {
        return application.resources

    }


    @Provides
    @Singleton
    @JvmStatic
    fun provideUserSharedPreferences(application: Github): SharedPreferences {
        return application.getSharedPreferences("github", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    @JvmStatic
    fun provideGson(): Gson {
        return Gson()
    }

}
