package com.mabnadp.rahavard365.di.common

import com.google.gson.Gson

import java.io.File
import java.util.concurrent.TimeUnit

import javax.inject.Named
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
object RetrofitModule {




    @Provides
    @Singleton
    @JvmStatic
    @Named("githubApiRetrofit")
    fun provideGithubRetrofit(@Named("githubApiUrl") baseUrl: String, converterFactory: Converter.Factory, callAdapterFactory: CallAdapter.Factory, @Named("githubSdkClient") okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(callAdapterFactory)
                    .client(okHttpClient)
                    .build()


    @Provides
    @Singleton
    @JvmStatic
    @Named("trendingApiRetrofit")
    fun provideTrendingRetrofit(@Named("trendingApiUrl") baseUrl: String, converterFactory: Converter.Factory, callAdapterFactory: CallAdapter.Factory, @Named("trendingSdkClient") okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(callAdapterFactory)
                    .client(okHttpClient)
                    .build()





    @Singleton
    @JvmStatic
    @Provides
    @Named("tradingSdkClient")
    fun provideTrendingOkHttpClient(loggingInterceptor: HttpLoggingInterceptor,

                                @Named("networkTimeoutInSeconds") networkTimeoutInSeconds: Int,
                                @Named("isDebug") isDebug: Boolean,
                                @Named("tradingApiCache") cache: Cache): OkHttpClient {


        val okHttpClient = OkHttpClient.Builder()

                .cache(cache)
                .readTimeout(networkTimeoutInSeconds.toLong(), TimeUnit.SECONDS)
                .connectTimeout(networkTimeoutInSeconds.toLong(), TimeUnit.SECONDS)

        //show logs if app is in Debug mode
        if (isDebug)
            okHttpClient.addInterceptor(loggingInterceptor)

        return okHttpClient.build()
    }


    @Singleton
    @Provides
    @JvmStatic
    @Named("githubSdkClient")
    fun provideGithubOkHttpClient(loggingInterceptor: HttpLoggingInterceptor,

                              @Named("networkTimeoutInSeconds") networkTimeoutInSeconds: Int,
                              @Named("isDebug") isDebug: Boolean,
                              @Named("githubApiCache") cache: Cache): OkHttpClient {


        val okHttpClient = OkHttpClient.Builder()

                .cache(cache)
                .readTimeout(networkTimeoutInSeconds.toLong(), TimeUnit.SECONDS)
                .connectTimeout(networkTimeoutInSeconds.toLong(), TimeUnit.SECONDS)

        if (isDebug)
            okHttpClient.addInterceptor(loggingInterceptor)

        return okHttpClient.build()
    }


    @Provides
    @Singleton
    @JvmStatic
    @Named("trendingApiCache")
    fun provideTrendingCache(@Named("cacheDir") cacheDir: File, @Named("cacheSize") cacheSize: Long) = Cache(File(cacheDir.path, "trending-api-cache"), cacheSize)


    @Provides
    @JvmStatic
    @Singleton
    @Named("githubApiCache")
    fun provideGithubCache(@Named("cacheDir") cacheDir: File, @Named("cacheSize") cacheSize: Long) =
            Cache(File(cacheDir.path, "github-api-cache"), cacheSize)


    @Provides
    @JvmStatic
    @Singleton
    fun provideRxJavaCallAdapterFactory(): CallAdapter.Factory =
            RxJava2CallAdapterFactory.create()


    @Provides
    @Singleton
    @JvmStatic
    fun provideGsonConverterFactory(gson: Gson): Converter.Factory =
            GsonConverterFactory.create(gson)

}
