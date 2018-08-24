package com.xapo.github.di.common

import com.xapo.github.remote.api.github.GithubService
import com.xapo.github.remote.api.github.IGithubService
import com.xapo.github.remote.api.trending.ITrendingService
import com.xapo.github.remote.api.trending.TrendingService
import com.xapo.github.utils.scheduler.SchedulerProvider
import com.xapo.github.utils.scheduler.SchedulerProviderImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class TrendingApiModule {


    @Binds
    @Singleton
    abstract fun provideTrendingService(trendingService: TrendingService): ITrendingService
}