package com.hcl.login.assignement.practice

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("/movielist.json")
    fun getDataFromAPI(): Call<List<Movie>>

    companion object {
        var retrofitService: RetrofitService? = null
        fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofir = Retrofit.Builder().baseUrl("https://howtodoandroid.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofir.create(RetrofitService::class.java)
            }

            return retrofitService!!
        }
    }
}
