package com.igti.netfilxapp.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.igti.netfilxapp.R
import com.igti.netfilxapp.model.Movie
import com.igti.netfilxapp.util.DownloadImageTask
import com.squareup.picasso.Picasso

class MovieAdapter(
    private val movies: List<Movie>,
    @LayoutRes private val layoutId: Int
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {

        val movieView = LayoutInflater.from(parent.context).inflate(
            layoutId,
            parent,
            false
        )
        return MovieViewHolder(movieView)
    }

    override fun onBindViewHolder(
        holder: MovieAdapter.MovieViewHolder,
        position: Int
    ) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size


    inner class MovieViewHolder(
        movieItem: View
    ) : RecyclerView.ViewHolder(movieItem) {

        fun bind(movie: Movie) {
            val imageCover = itemView.findViewById<ImageView>(R.id.image_cover)

            DownloadImageTask(object : DownloadImageTask.Callback{
                override fun onResult(bitmap: Bitmap) {
                    imageCover.setImageBitmap(bitmap)
                }
            }).execute(movie.coverURL)

        }

    }

}