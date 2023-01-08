package com.igti.netfilxapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.igti.netfilxapp.adapter.MainAdapter
import com.igti.netfilxapp.model.Category
import com.igti.netfilxapp.util.CategoryTask

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categories = mutableListOf<Category>()


        val rvCategory: RecyclerView = findViewById(R.id.rv_main)
        val adapter = MainAdapter(categories)
        rvCategory.adapter = adapter
        rvCategory.layoutManager = LinearLayoutManager(this)

        CategoryTask().execute("https://api.tiagoaguiar.co/netflixapp/home?apiKey=9d261bbe-fc91-4159-b2e8-51a70a1d4e8a")

    }



}