package com.xapo.github.di.common


import com.google.gson.Gson

import com.xapo.github.remote.retrofit.IGithubRetrofit
import com.xapo.github.remote.retrofit.ITrendingRetrofit
import com.xapo.github.utils.GeneralApiException

import javax.inject.Named
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.functions.Function
import retrofit2.HttpException
import retrofit2.Retrofit

@Module
open class ApiModule {


    @Provides
    fun provideParseHttpErrors(gson: Gson): ObservableTransformer<*, *> {
        return ObservableTransformer<Any?, Any?> { upstream ->
            upstream.onErrorResumeNext(Function<Throwable, ObservableSource<*>> { throwable ->
                if (throwable is HttpException) {

                    val generalApiException = GeneralApiException(throwable.response())
                    generalApiException.setCode(throwable.code())
                    generalApiException.setMessage(throwable.message())



                    return@Function Observable.error<Any>(generalApiException)

                }


                Observable.error<Any>(throwable)
            })
        }


    }

    @Module
    companion object {


        @JvmStatic
        @Provides
        @Singleton
        fun provideGithubApiService(@Named("githubApiRetrofit") retrofit: Retrofit): IGithubRetrofit {

            return retrofit.create(IGithubRetrofit::class.java)
        }

        @Provides
        @JvmStatic
        @Singleton
        fun provideTrendingApiService(@Named("trendingApiRetrofit") retrofit: Retrofit): ITrendingRetrofit {

            return retrofit.create(ITrendingRetrofit::class.java)
        }
    }

}
