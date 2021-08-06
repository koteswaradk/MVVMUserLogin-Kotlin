package com.hcl.login.assignement.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hcl.login.assignement.model.Movie
import com.hcl.login.assignement.repository.LoginRepository
import com.hcl.login.assignement.repository.NewsRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job

class NewViewModel() : ViewModel() {

    var movieList=MutableLiveData<List<Movie>>()
    private val loginRepository: NewsRepository=NewsRepository()

    fun getMovieData():MutableLiveData<List<Movie>>{


       movieList= loginRepository.getMoveData()
        return movieList
    }

}