package com.hcl.login.assignement.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hcl.login.assignement.MovieAdapter
import com.hcl.login.assignement.R
import com.hcl.login.assignement.databinding.ActivityDetailsBinding
import com.hcl.login.assignement.viewmodel.LoginViewModel

class DetailsActivity : AppCompatActivity() {
    private val adapter = MovieAdapter()
    lateinit var binding: ActivityDetailsBinding
    private lateinit var newViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.fitsSystemWindows
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.adapter = adapter
        dataRequest()
    }
    private fun dataRequest() {
        // newViewModel=ViewModelProvider(this,NewsViewModelProviderFactory(NewsRepository())).get(NewViewModel::class.java)
        newViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        newViewModel.getAllMovies().observe(
            this,
            Observer {
                if (it.isNotEmpty()) {
                    Log.d("TAG", "dataRequest: ${it.get(1).imageurl}")
                    adapter.setMovies(it)
                    binding.recyclerview.setHasFixedSize(true)
                }
            }
        )
       /* newViewModel.erromesage.observe(this, Observer {
            Toast.makeText(this,"Problem"+it, Toast.LENGTH_LONG).show()


        })
        loginviewmodel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        loginviewmodel.getAllMovies();*/
    }
}
