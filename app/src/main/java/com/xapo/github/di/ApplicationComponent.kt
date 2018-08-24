package com.xapo.github.di

import com.mabnadp.rahavard365.di.common.OkHttpInterceptorModule
import com.mabnadp.rahavard365.di.common.RetrofitModule
import com.xapo.github.Github
import com.xapo.github.di.common.ApiModule
import com.xapo.github.di.common.GithubApiModule
import com.xapo.github.di.common.TrendingApiModule

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    ApiModule::class,
    GithubApiModule::class,
    OkHttpInterceptorModule::class,
    RetrofitModule::class,
    TrendingApiModule::class,
    ApplicationModule::class,
    ActivityBuilder::class,
    AndroidModule::class])
interface ApplicationComponent {
    fun inject(application: Github)


    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(application: Github): Builder
    }
}