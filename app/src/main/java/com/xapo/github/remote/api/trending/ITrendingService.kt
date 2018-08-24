package com.xapo.github.remote.api.trending

import com.xapo.github.remote.models.Trend
import io.reactivex.Observable
import retrofit2.http.Query

interface ITrendingService {
    fun getTrends(language: String? = null, since: String? = null): Observable<List<Trend>>
}