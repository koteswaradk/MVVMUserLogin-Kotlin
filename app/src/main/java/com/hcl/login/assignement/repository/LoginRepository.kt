package com.hcl.login.assignement.repository

import com.hcl.login.assignement.model.Movie
import com.hcl.login.assignement.network.RetrofitService
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import javax.inject.Inject

class LoginRepository {
    private val retrofitService = RetrofitService.getInstance()
    fun getAllMovies(): Call<List<Movie>> {
       return retrofitService.getAllMovies()
   }
}