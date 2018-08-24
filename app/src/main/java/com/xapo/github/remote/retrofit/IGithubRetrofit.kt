package com.xapo.github.remote.retrofit

import com.xapo.github.remote.models.Repository
import com.xapo.github.remote.models.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface IGithubRetrofit {

    @GET("/users/{username}")
    fun getUser(@Path("username") username: String): Observable<User>

    @GET("/users/{username}/repos")
    fun getRepositories(@Path("username") username: String): Observable<List<Repository>>

}