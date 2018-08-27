package com.xapo.github.screens.main

import com.xapo.github.remote.models.Trend
import com.xapo.github.utils.base.IPresenter
import com.xapo.github.utils.base.IView

class MainContract {
    interface View : IView<Presenter> {
        fun onShow(toList: List<Trend>)

    }

    abstract class Presenter : IPresenter<View>() {
       abstract fun getRepositories()
    }
}
