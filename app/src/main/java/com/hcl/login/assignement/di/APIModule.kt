package com.hcl.login.assignement.di

import com.hcl.login.assignement.network.*
import com.hcl.login.assignement.repository.CoMovieRepository
import com.hcl.login.assignement.repository.RxMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class APIModule {
    @Singleton
    @Provides
    fun provideCountriesApi(): RxRetroApi {
        return RxRetroAPIService().api
    }
    @Provides
    fun provideCountriesService(): RxMovieRepository {
        return RxMovieRepository()
    }
    @Provides
    fun provideCoMovieRepository(): CoMovieRepository {
        return CoMovieRepository()
    }
    @Provides
    fun provideCoApi(): CoRetroApi {
        return CoRetroApiService().api
    }
}