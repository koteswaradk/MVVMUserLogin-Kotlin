package com.hcl.login.assignement.practice

import retrofit2.Call

class Repository {

    val retrofitService = RetrofitService.getInstance()
    fun getDataFromTheRepository(): Call<List<Movie>> {

        return retrofitService.getDataFromAPI()
    }
}
