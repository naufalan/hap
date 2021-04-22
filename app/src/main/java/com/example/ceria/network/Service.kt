package com.example.ceria.network

import com.example.ceria.data.remote.response.CeriaResponse
import com.example.ceria.data.remote.response.GithubResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    //@GET("${API.SEARCH}/${API.USERS}")
    //fun getUsers(@Query("q") q: String): Observable<GithubResponse>
    @GET("api/auth")
    fun getEndPoint(@Query("login") login: String): Observable<CeriaResponse>
    @GET("${API.PHONE}/${API.PIN}")
    fun getUsers(@Query("login") login: String): Observable<CeriaResponse>
}
