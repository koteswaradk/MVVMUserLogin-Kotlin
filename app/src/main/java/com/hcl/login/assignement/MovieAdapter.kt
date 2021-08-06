package com.hcl.login.assignement

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hcl.login.assignement.databinding.AdapterMovieBinding
import com.hcl.login.assignement.model.Movie

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MainViewHolder>() {
    class MainViewHolder (val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root)

    var movieList = mutableListOf<Movie>()

    fun setMovies(movies: List<Movie>) {
        this.movieList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val binding = AdapterMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val movie = movieList[position]
        holder.binding.name.text = movie.name
        Log.d("TAG", "onBindViewHolder: ${movie.imageurl}")
            Glide.with(holder.itemView.context).load("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg").into(holder.binding.imageview)


    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}
