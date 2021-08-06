package com.hcl.login.assignement.repository

import com.hcl.login.assignement.network.RetrofitService

class LoginRepository {
    private val retrofitService = RetrofitService.getInstance()
    fun getAllMovies()=retrofitService.getAllMovies()
}