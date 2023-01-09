package com.igti.netfilxapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.igti.netfilxapp.adapter.MainAdapter
import com.igti.netfilxapp.model.Category
import com.igti.netfilxapp.util.CategoryTask

class MainActivity : AppCompatActivity(), CategoryTask.Callback {

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progress_main)

        val categories = mutableListOf<Category>()

        val rvCategory: RecyclerView = findViewById(R.id.rv_main)
        val adapter = MainAdapter(categories)
        rvCategory.adapter = adapter
        rvCategory.layoutManager = LinearLayoutManager(this)

        CategoryTask(this).execute("https://api.tiagoaguiar.co/netflixapp/home?apiKey=9d261bbe-fc91-4159-b2e8-51a70a1d4e8a")

    }

    override fun onPreExecute() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onResult(category: List<Category>) {
        Log.i("Test Activity", "onResult: $category")
        progressBar.visibility = View.GONE
    }

    override fun onFailure(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        ).show()
    }


}