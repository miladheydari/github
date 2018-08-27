package com.xapo.github.utils.base

import com.xapo.github.utils.GeneralApiException

interface IView<T>{
    fun onError(generalApiException: GeneralApiException?)
}
