package com.hcl.login.assignement.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hcl.login.assignement.model.Movie
import com.hcl.login.assignement.repository.LoginRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: ViewModel() {
    val movieList=MutableLiveData<List<Movie>>()
    val erromesage=MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    val disposable= CompositeDisposable()
    var job: Job? = null

   val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
       onError("Exception handled: ${throwable.localizedMessage}")
    }
    
    fun getAllMovies():MutableLiveData<List<Movie>>{

        job =  CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
            val response = LoginRepository().getAllMovies()
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
        return movieList
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