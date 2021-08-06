package com.hcl.login.assignement.repository

import androidx.lifecycle.MutableLiveData
import com.hcl.login.assignement.model.Movie

class MovieListRepository {

    lateinit var movielist:MutableLiveData<List<Movie>>
    var message=MutableLiveData<String>()


}