package com.xapo.github.utils.base

interface IPresenter<T> {


    fun unsubscribe()


    fun attachView(view: T)

}
