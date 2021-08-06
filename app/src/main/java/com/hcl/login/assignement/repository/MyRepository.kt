package com.hcl.login.assignement.repository

import androidx.lifecycle.MutableLiveData
import com.hcl.login.assignement.model.Movie
import com.hcl.login.assignement.network.RetrofitInsatnce
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRepository {

    lateinit var mutablelivedata:MutableLiveData<List<Movie>>
    var message =MutableLiveData<String>()


    fun getData():MutableLiveData<List<Movie>>{
        mutablelivedata= MutableLiveData()

        CoroutineScope(Dispatchers.IO).launch{
            var retrofitInsatnce=RetrofitInsatnce.getInstance()
            withContext(Dispatchers.Main){
                retrofitInsatnce.getAllMovieData().enqueue(object :Callback<List<Movie>>{
                    override fun onResponse(
                        call: Call<List<Movie>>,
                        response: Response<List<Movie>>
                    ) {
                        mutablelivedata.postValue(response.body())
                    }

                    override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                        message.postValue(t.message)
                    }

                })
            }

        }


        return mutablelivedata
    }
}