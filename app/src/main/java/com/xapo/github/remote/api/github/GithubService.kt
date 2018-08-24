package com.xapo.github.remote.api.github

import com.xapo.github.remote.models.Repository
import com.xapo.github.remote.models.User
import com.xapo.github.remote.retrofit.IGithubRetrofit
import com.xapo.github.utils.scheduler.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import javax.inject.Inject

class GithubService @Inject constructor(
        private val iGithubRetrofit: IGithubRetrofit,
        private val errorHandler: ObservableTransformer<*, *>,
        private val schedulerProvider: SchedulerProvider
) :IGithubService{
    override fun getUser(username: String): Observable<User> {
    return iGithubRetrofit.getUser(username).compose(errorHandler as ObservableTransformer<in User, out User>).subscribeOn(schedulerProvider.backgroundThread()).observeOn(schedulerProvider.mainThread())
    }

    override fun getRepositories(username: String): Observable<List<Repository>> {

        return iGithubRetrofit.getRepositories(username).compose(errorHandler as ObservableTransformer<in List<Repository>, out List<Repository>>).subscribeOn(schedulerProvider.backgroundThread()).observeOn(schedulerProvider.mainThread())
    }

}