package com.igti.netfilxapp

import android.annotation.SuppressLint
import android.os.Bundle
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
    private lateinit var adapter: MainAdapter
    private val categories = mutableListOf<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progress_main)

        val rvCategory: RecyclerView = findViewById(R.id.rv_main)
        adapter = MainAdapter(categories)
        rvCategory.adapter = adapter
        rvCategory.layoutManager = LinearLayoutManager(this)


        CategoryTask(this).execute("https://api.tiagoaguiar.co/netflixapp/home?apiKey=9d261bbe-fc91-4159-b2e8-51a70a1d4e8a")

    }

    override fun onPreExecute() {
        progressBar.visibility = View.VISIBLE
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResult(categories: List<Category>) {
        this.categories.clear()
        this.categories.addAll(categories)
        adapter.notifyDataSetChanged()

        progressBar.visibility = View.GONE
    }

    override fun onFailure(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        ).show()
        progressBar.visibility = View.GONE
    }


}