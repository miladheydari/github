package com.xapo.github.di

import android.content.Context

import com.xapo.github.BuildConfig
import com.xapo.github.utils.Constants
import com.xapo.github.utils.scheduler.SchedulerProvider
import com.xapo.github.utils.scheduler.SchedulerProviderImpl

import java.io.File

import javax.inject.Named
import javax.inject.Singleton

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ApplicationModule {


    @Binds
    @Singleton

    abstract fun provideAppScheduler(schedulerProvider: SchedulerProviderImpl): SchedulerProvider

    @Module
    companion object {


        @Provides
        @Singleton
        @JvmStatic
        @Named("isDebug")
        fun provideIsDebug(): Boolean {
            return BuildConfig.DEBUG
        }

        @Provides
        @Singleton
        @JvmStatic
        @Named("networkTimeoutInSeconds")
        fun provideNetworkTimeoutInSeconds(): Int {
            return 30
        }


        @Provides
        @Singleton
        @JvmStatic
        @Named("githubApiUrl")
        fun provideGithubUrl() = Constants.GITHUB_API_URL



        @Provides
        @Singleton
        @JvmStatic
        @Named("trendingApiUrl")
        fun provideTrendingUrl() = Constants.TRENDING_API_URL




        @Provides
        @Singleton
        @JvmStatic
        @Named("cacheSize")
        fun provideCacheSize(): Long {
            return (10 * 1024 * 1024).toLong() // 10 MB
        }

        @Provides
        @Singleton
        @JvmStatic
        @Named("cacheDir")
        fun provideCacheDir(context: Context): File {
            return context.cacheDir
        }

    }
}
