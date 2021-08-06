package com.hcl.login.assignement.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hcl.login.assignement.databinding.ActivityLoginBinding

import com.hcl.login.assignement.util.LoginValidator
import com.hcl.login.assignement.viewmodel.LoginViewModel
import com.hcl.login.assignement.viewmodel.NewViewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var loginviewmodel:LoginViewModel
    private lateinit var newViewModel: NewViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginCheck()
    }


    fun loginCheck(){

        val username =binding.etUsername
        val password=binding.etPassword

            binding.btLogin.setOnClickListener {
            if (username.text.toString().isEmpty()){
                username.error="username required"
                username.requestFocus()
            }else
            if (password.text.toString().isEmpty()){
                password.error="password required"
                password.requestFocus()
            }
            if (LoginValidator.isValidUserName(username.text.toString())&&LoginValidator.isValidPassword(password.text.toString())
                &&LoginValidator.isLoginvalid(username.text.toString(),password.text.toString())){
                dataRequest()
            }
                else{
                Toast.makeText(this,"Problem: Please check credentials",Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun dataRequest() {
       // newViewModel=ViewModelProvider(this,NewsViewModelProviderFactory(NewsRepository())).get(NewViewModel::class.java)
        newViewModel=ViewModelProvider(this).get(NewViewModel::class.java)
        newViewModel.getMovieData().observe(this, Observer {
            if (it.isNotEmpty()) {
                Log.d("TAG", "dataRequest: $it")
               //startActivity(Intent(this, DetailsActivity::class.java))
                startActivity(Intent(this,DetailsToTestActivity::class.java))
            }
        })
       /* loginviewmodel=ViewModelProvider(this,LoginViewModelFactory(LoginRepository())).get(LoginViewModel::class.java)
        loginviewmodel.movieList.observe(this, Observer {
           if (it.isNotEmpty()) {
               startActivity(Intent(this, DetailsActivity::class.java))
               //startActivity(Intent(this,DetailsToTestActivity::class.java))
           }
        })
        loginviewmodel.erromesage.observe(this, Observer {
            Toast.makeText(this,"Problem"+it,Toast.LENGTH_LONG).show()


        })

        loginviewmodel.getAllMovies()*/
    }

}