package com.igti.netfilxapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.igti.netfilxapp.adapter.MainAdapter
import com.igti.netfilxapp.adapter.MovieAdapter
import com.igti.netfilxapp.model.Category
import com.igti.netfilxapp.model.Movie

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categories = mutableListOf<Category>()
        for (i in 1 until 6) {
            val movies = mutableListOf<Movie>()
            for (j in 1 until 11) {
                val movie = Movie(R.drawable.movie)
                movies.add(movie)
            }
            val category = Category("Category $i", movies)
            categories.add(category)
        }



        val rvCategory: RecyclerView = findViewById(R.id.rv_main)
        val adapter = MainAdapter(categories)
        rvCategory.adapter = adapter
        rvCategory.layoutManager = LinearLayoutManager(this)
    }



}