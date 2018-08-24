package com.xapo.github.remote.retrofit

import com.xapo.github.remote.models.Trend
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ITrendingRetrofit {
    @GET("/repositories")
    fun getTrends(@Query("language") language: String?, @Query("since") since: String?): Observable<List<Trend>>
}