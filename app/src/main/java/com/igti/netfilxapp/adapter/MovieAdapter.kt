package com.igti.netfilxapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.igti.netfilxapp.R
import com.igti.netfilxapp.model.Movie

class MovieAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val movieView = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item,
            parent,
            false
        )
        return MovieViewHolder(movieView)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size


    inner class MovieViewHolder(movieItem: View) : RecyclerView.ViewHolder(movieItem) {
        fun bind(movie: Movie) {
            val txtTest = itemView.findViewById<TextView>(R.id.txt_test)

            txtTest.text = movie.coverURL
        }

    }

}