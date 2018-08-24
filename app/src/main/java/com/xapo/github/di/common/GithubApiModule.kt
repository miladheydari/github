package com.xapo.github.di.common

import com.xapo.github.remote.api.github.GithubService
import com.xapo.github.remote.api.github.IGithubService
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class GithubApiModule {


    @Binds
    @Singleton
    abstract fun provideGithubService(githubService: GithubService): IGithubService
}