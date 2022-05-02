package com.hcl.login.assignement.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hcl.login.assignement.databinding.ActivityLoginBinding
import com.hcl.login.assignement.util.LoginValidator
import com.hcl.login.assignement.viewmodel.CoMovieViewModel
import com.hcl.login.assignement.viewmodel.LoginViewModel
import com.hcl.login.assignement.viewmodel.RxMovieViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var loginviewmodel: LoginViewModel

    // private lateinit var newViewModel: NewViewModel
    lateinit var coMovieViewModel: CoMovieViewModel
    lateinit var movieViewModel: RxMovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginCheck()
    }

    fun loginCheck() {

        val username = binding.etUsername
        val password = binding.etPassword

        binding.btLogin.setOnClickListener {
            username.apply {
                if (text.isEmpty()) {
                    error = "username required"
                    requestFocus()
                }
            }
            password.apply {
                if (text.isEmpty())
                    error = "password required"
                requestFocus()
            }
            if (LoginValidator.isValidUserName(username.text.toString()) && LoginValidator.isValidPassword(password.text.toString()) &&
                LoginValidator.isLoginvalid(username.text.toString(), password.text.toString())
            ) {
                dataRequestWithRxjava()
                // dataRequestWithCoroutine()
            } else {
                Toast.makeText(this, "Problem: Please check credentials", Toast.LENGTH_LONG).show()
            }
        }
    }

    /*private fun dataRequestWithCoroutine() {

        coMovieViewModel = ViewModelProvider(this).get(CoMovieViewModel::class.java)

        coMovieViewModel.getDataFromCoViewModel().observe(this, Observer {
            if (it.isNotEmpty()) {
                Intent(this, DetailsToTestActivity::class.java).apply {
                    startActivity(this)
                }
            }
        })


    }*/

    fun dataRequestWithRxjava() {
        movieViewModel = ViewModelProvider(this).get(RxMovieViewModel::class.java)
        movieViewModel.getDataFromMovieViewModel().observe(
            this,
            Observer {
                if (it.isNotEmpty()) {
                    Log.d("TAG", "dataRequest: $it")
                    Intent(this, DetailsToTestActivity::class.java).apply {

                        startActivity(this)
                    }
                }
            }
        )
    }

    private fun dataRequest() {

        loginviewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginviewmodel.getAllMovies().observe(
            this,
            Observer {
                if (it.isNotEmpty()) {
                    Log.d("TAG", "dataRequest: $it")
                    // startActivity(Intent(this, DetailsActivity::class.java))
                    startActivity(Intent(this, DetailsActivity::class.java))
                }
            }
        )

        loginviewmodel.erromesage.observe(
            this,
            Observer {
                Toast.makeText(this, "Problem" + it, Toast.LENGTH_LONG).show()
            }
        )
    }
}

/* loginviewmodel=ViewModelProvider(this,LoginViewModelFactory(LoginRepository())).get(LoginViewModel::class.java)
        loginviewmodel.movieList.observe(this, Observer {
           if (it.isNotEmpty()) {
               startActivity(Intent(this, DetailsActivity::class.java))
               //startActivity(Intent(this,DetailsToTestActivity::class.java))
           }
        })


        loginviewmodel.getAllMovies()*/
