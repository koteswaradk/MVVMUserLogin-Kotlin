package com.hcl.login.assignement.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hcl.login.assignement.model.Movie
import com.hcl.login.assignement.repository.LoginRepository
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    val movieList=MutableLiveData<List<Movie>>()
    val erromesage=MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    var job: Job? = null


   val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
       onError("Exception handled: ${throwable.localizedMessage}")
    }
    fun getAllMovies() {

        job =  CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
            val response = loginRepository.getAllMovies()
            withContext(Dispatchers.Main){
                response.enqueue(object : Callback<List<Movie>> {
                    override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                        movieList.postValue(response.body())
                        Log.d("TAG", "onResponse: ${response.body()}")
                        loading.value = false
                    }

                    override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                        erromesage.postValue(t.message)
                    }
                })
            }

        }

    }
    private fun onError(message: String) {
        erromesage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}