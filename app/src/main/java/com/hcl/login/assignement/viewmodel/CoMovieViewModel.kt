package com.hcl.login.assignement.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hcl.login.assignement.di.DaggerApiComponent
import com.hcl.login.assignement.model.Movie
import com.hcl.login.assignement.repository.CoMovieRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class CoMovieViewModel:ViewModel() {
    var movieList= MutableLiveData<List<Movie>>()
    var  erroMessage= MutableLiveData<String>()
    var loading= MutableLiveData<Boolean>()
    val coroutineScope=CoroutineScope(Dispatchers.IO)
    @Inject
    lateinit var coMovieRepository: CoMovieRepository

    init {
        DaggerApiComponent.create().inject(this)
    }
    fun getDataFromCoViewModel():MutableLiveData<List<Movie>>{
        coroutineScope.launch {
            val response = coMovieRepository.getCoAllMovies()
            withContext(Dispatchers.Main){
                if (response.isSuccessful) {
                    response.body().let { resultResponse ->
                        movieList.value = resultResponse
                        loading.value=true
                    }
                } else {
                    loading.value=false
                    erroMessage.value = response.message()
                }
            }


        }
       /* coroutineScope.launch {
            val response= coMovieRepository.getCoAllMovies()
            withContext(Dispatchers.Main){
                response.apply {
                    movieList.value=this.body()
                }
            }
        }*/

        return movieList
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.coroutineContext.cancelChildren()
    }
}