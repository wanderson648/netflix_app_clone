package com.igti.netfilxapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.igti.netfilxapp.adapter.MovieAdapter
import com.igti.netfilxapp.model.Movie

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movies = mutableListOf<Movie>()

        for (i in 0 until 5) {
            val movie = Movie(R.drawable.movie)
            movies.add(movie)
        }


        val rvMovie: RecyclerView = findViewById(R.id.rv_movie)
        val adapter = MovieAdapter(movies)

        rvMovie.adapter = adapter
        rvMovie.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.HORIZONTAL,
            false
        )
    }



}