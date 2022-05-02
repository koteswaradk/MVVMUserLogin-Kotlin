package com.hcl.login.assignement.repository


import com.hcl.login.assignement.di.DaggerApiComponent
import com.hcl.login.assignement.model.Movie
import com.hcl.login.assignement.network.RxRetroApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RxMovieRepository {

    @Inject
    lateinit var api: RxRetroApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getAllMovies(): Single<List<Movie>> {
        return api.getAllMovies()
    }
}