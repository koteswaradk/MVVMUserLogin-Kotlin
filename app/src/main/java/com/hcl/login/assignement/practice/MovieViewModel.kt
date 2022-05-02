package com.hcl.login.assignement.practice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    var movilist = MutableLiveData<List<Movie>>()
    var errormessage = MutableLiveData<String>()

    fun getDataFromViewModel(): MutableLiveData<List<Movie>> {

        val response = Repository().getDataFromTheRepository()
        response.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movilist.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errormessage.postValue(t.message)
            }
        })

        return movilist
    }
}
