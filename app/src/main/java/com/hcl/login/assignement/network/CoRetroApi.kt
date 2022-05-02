package com.hcl.login.assignement.network

import com.hcl.login.assignement.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface CoRetroApi {
    @GET("/movielist.json")
    suspend fun getDataFromURl(): Response<List<Movie>>
}
