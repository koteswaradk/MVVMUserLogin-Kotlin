package com.hcl.login.assignement.network

import com.hcl.login.assignement.model.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitInsatnce {
    @GET("/movielistjson")
    fun getAllMovieData():Call<List<Movie>>

    companion object{

        var retrofitInsatnce:RetrofitInsatnce?=null
        fun getInstance():RetrofitInsatnce{
            if (retrofitInsatnce==null){
                val retrofit=Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitInsatnce= retrofit.create(RetrofitInsatnce::class.java)
            }


            return retrofitInsatnce!!
        }
    }
}