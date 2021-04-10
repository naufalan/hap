package com.example.ceria.network

import com.example.ceria.data.remote.response.GithubResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("${API.SEARCH}/${API.USERS}")
    fun getUsers(@Query("q") q: String): Observable<GithubResponse>
}
