package com.xapo.github.utils.base

import com.xapo.github.utils.GeneralApiException
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.annotations.NotNull
import retrofit2.HttpException
import timber.log.Timber

abstract class IPresenter<T> {


    protected val compositeDisposable = CompositeDisposable()

    fun unsubscribe() {
        compositeDisposable.clear()
    }


    abstract fun attachView(@NotNull view: T)

    protected open fun errorHandler(e: Throwable) {
        when (e) {
            is HttpException -> Timber.tag(TAG).d("onError StatusCode: %s", e.code())
            is GeneralApiException -> Timber.tag(TAG).d("onError message: %s", e.message())
            else -> Timber.tag(TAG).d("onError")
        }

    }

    companion object {
        var TAG = ""
    }
}
