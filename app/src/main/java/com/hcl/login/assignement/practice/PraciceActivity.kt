package com.hcl.login.assignement.practice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hcl.login.assignement.R
import com.hcl.login.assignement.view.DetailsActivity

class PraciceActivity : AppCompatActivity() {
    lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pracice)
        dataRequest()
    }

    private fun dataRequest() {
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        movieViewModel.getDataFromViewModel().observe(
            this,
            Observer {
                Log.d("TAG", "dataRequest: $it")
                if (it.isNotEmpty()) {
                    startActivity(Intent(this, DetailsActivity::class.java))
                }
            }
        )
    }
}
