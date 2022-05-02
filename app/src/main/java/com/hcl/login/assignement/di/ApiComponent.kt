package com.hcl.login.assignement.di

import com.hcl.login.assignement.network.RetrofitService
import com.hcl.login.assignement.repository.CoMovieRepository
import com.hcl.login.assignement.repository.LoginRepository
import com.hcl.login.assignement.repository.RxMovieRepository
import com.hcl.login.assignement.viewmodel.CoMovieViewModel
import com.hcl.login.assignement.viewmodel.RxMovieViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [APIModule::class])
interface ApiComponent {
    fun inject(repository: RxMovieRepository)
    fun inject(model: RxMovieViewModel)
    fun inject(coMovieRepository: CoMovieRepository)
    fun inject(coMovieViewModel: CoMovieViewModel)

}