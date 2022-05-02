package com.hcl.login.assignement.network

import com.hcl.login.assignement.model.Movie
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RxRetroApi {

    @GET("movielist.json")
    /*  fun getAllMovies(): Call<List<Movie>>*/
    fun getAllMovies(): Single<List<Movie>>
}
