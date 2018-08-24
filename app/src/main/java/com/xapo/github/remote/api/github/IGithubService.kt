package com.xapo.github.remote.api.github

import com.xapo.github.remote.models.Repository
import com.xapo.github.remote.models.User
import io.reactivex.Observable

interface IGithubService {

    fun getUser(username: String): Observable<User>
    fun getRepositories(username: String): Observable<List<Repository>>

}