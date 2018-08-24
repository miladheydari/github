package com.xapo.github.remote.api.trending

import com.xapo.github.remote.models.Trend
import com.xapo.github.remote.retrofit.ITrendingRetrofit
import com.xapo.github.utils.scheduler.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import javax.inject.Inject

class TrendingService @Inject constructor(
        private val iTrendingRetrofit: ITrendingRetrofit,
        private val errorHandler: ObservableTransformer<*, *>,
        private val schedulerProvider: SchedulerProvider
) : ITrendingService {
    override fun getTrends(language: String?, since: String?): Observable<List<Trend>> {
        return iTrendingRetrofit.getTrends(language, since).compose(errorHandler as ObservableTransformer<in List<Trend>, out List<Trend>>)
                .observeOn(schedulerProvider.mainThread()).subscribeOn(schedulerProvider.backgroundThread())
    }
}