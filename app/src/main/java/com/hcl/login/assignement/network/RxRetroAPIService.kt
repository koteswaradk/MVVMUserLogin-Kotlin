package com.hcl.login.assignement.network

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RxRetroAPIService {

    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://howtodoandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }
    }

    val api by lazy {
        retrofit.create(RxRetroApi::class.java)
    }
}
