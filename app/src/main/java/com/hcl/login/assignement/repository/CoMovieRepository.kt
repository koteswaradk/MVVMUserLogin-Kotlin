package com.hcl.login.assignement.repository

import com.hcl.login.assignement.di.DaggerApiComponent
import com.hcl.login.assignement.model.Movie
import com.hcl.login.assignement.network.CoRetroApi
import retrofit2.Response
import javax.inject.Inject

class CoMovieRepository {

    // private val retrofitService :RxRetroApi= RxRetroAPIService.getInstance()
    // val api:CoRetroApi=CoRetroApiService().api

    @Inject
    lateinit var api: CoRetroApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    suspend fun getCoAllMovies(): Response<List<Movie>> {
        return api.getDataFromURl()
    }
}
