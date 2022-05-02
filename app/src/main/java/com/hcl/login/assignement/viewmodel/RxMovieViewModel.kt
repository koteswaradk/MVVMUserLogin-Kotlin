package com.hcl.login.assignement.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hcl.login.assignement.di.DaggerApiComponent
import com.hcl.login.assignement.model.Movie
import com.hcl.login.assignement.repository.RxMovieRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RxMovieViewModel : ViewModel() {

    var movieList = MutableLiveData<List<Movie>>()
    var erroMessage = MutableLiveData<String>()
    var loading = MutableLiveData<Boolean>()
    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var rxMovieRepository: RxMovieRepository

    init {
        DaggerApiComponent.create().inject(this)
    }
    fun getDataFromMovieViewModel(): MutableLiveData<List<Movie>> {

        compositeDisposable.add(
            rxMovieRepository.getAllMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Movie>>() {
                    override fun onSuccess(t: List<Movie>) {
                        movieList.value = t
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        erroMessage.value = e.message
                    }
                })

        )
        //  val response = MovieRepository().getAllMovies()

              /*  response.(object : Callback<List<Movie>> {
                    override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                        movieList.postValue(response.body())
                        Log.d("TAG", "onResponse: ${response.body()}")
                        loading.value = false
                    }

                    override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                        erroMessage.postValue(t.message)
                    }
                })*/

        return movieList
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
    private fun onError(message: String) {
        erroMessage.value = message
        loading.value = false
    }
}
