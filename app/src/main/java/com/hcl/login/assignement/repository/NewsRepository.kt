package com.hcl.login.assignement.repository

import androidx.lifecycle.MutableLiveData
import com.hcl.login.assignement.model.Movie
import com.hcl.login.assignement.network.RetrofitService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository() {
    lateinit var mutableLiveData:MutableLiveData<List<Movie>>
    var erromesage=MutableLiveData<String>()

    fun getMoveData():MutableLiveData<List<Movie>>{

        mutableLiveData= MutableLiveData()

        CoroutineScope(Dispatchers.IO).launch {

            var retrofitServiceInstance=RetrofitService.getInstance()

            withContext(Dispatchers.Main) {

                retrofitServiceInstance.getAllMovies().enqueue(

                    object : Callback<List<Movie>> {
                        override fun onResponse(
                            call: Call<List<Movie>>,
                            response: Response<List<Movie>>
                        ) {
                            mutableLiveData.postValue(response.body())
                        }

                        override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                            erromesage.postValue(t.message)
                        }

                    }
                )
            }
        }

        return mutableLiveData

    }

}