package com.xapo.github.screens.main

import com.xapo.github.remote.api.trending.ITrendingService
import com.xapo.github.remote.models.Trend
import com.xapo.github.utils.GeneralApiException
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver

import javax.inject.Inject

class MainPresenter @Inject
constructor(private val trendingService: ITrendingService)
    : MainContract.Presenter() {

    private lateinit var viewLayer: MainContract.View

    override fun getRepositories() {

        Observable.merge(trendingService.getTrends("kotlin", "weekly"),
                trendingService.getTrends("java", "weekly")).subscribeWith(object : DisposableObserver<List<Trend>>() {
            override fun onComplete() {
            }

            override fun onNext(t: List<Trend>) {
                viewLayer.onShow(t.filter { it.description?.contains("android".toRegex()) ?: false
                        || it.description?.contains("Android".toRegex()) ?: false }.toList())
            }

            override fun onError(e: Throwable) {

                errorHandler(e)
            }
        })


    }

    override fun errorHandler(e: Throwable) {
        super.errorHandler(e)
        viewLayer.onError(e as? GeneralApiException)
    }


    override fun attachView(view: MainContract.View) {

        viewLayer = view
    }


}
