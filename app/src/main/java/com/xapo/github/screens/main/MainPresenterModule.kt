package com.xapo.github.screens.main

import dagger.Module
import dagger.Provides

@Module
class MainPresenterModule {
    @Provides
    fun provideMainPresenter(presenter: MainPresenter): MainContract.Presenter = presenter
}
