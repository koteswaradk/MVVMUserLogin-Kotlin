package com.hcl.login.assignement.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hcl.login.assignement.repository.LoginRepository
import com.hcl.login.assignement.repository.NewsRepository
import java.lang.IllegalArgumentException


/*
class NewsViewModelProviderFactory(private val repository: NewsRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewViewModel::class.java)) {
            NewViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}*/
