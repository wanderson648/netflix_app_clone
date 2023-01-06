package com.igti.netfilxapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.igti.netfilxapp.R
import com.igti.netfilxapp.model.Category
import com.igti.netfilxapp.model.Movie
import kotlin.coroutines.coroutineContext

class MainAdapter(
    private val categories: List<Category>
) : RecyclerView.Adapter<MainAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainAdapter.CategoryViewHolder {

        val movieView = LayoutInflater.from(parent.context).inflate(
            R.layout.category_item,
            parent,
            false
        )
        return CategoryViewHolder(movieView)
    }

    override fun onBindViewHolder(
        holder: MainAdapter.CategoryViewHolder,
        position: Int
    ) {
        val category = categories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int = categories.size


    inner class CategoryViewHolder(
        movieItem: View
    ) : RecyclerView.ViewHolder(movieItem) {

        fun bind(category: Category) {
            val txtTitle = itemView.findViewById<TextView>(R.id.txt_title)
            txtTitle.text = category.name

            val rvCategory = itemView.findViewById<RecyclerView>(R.id.rv_category)
            rvCategory.adapter = MovieAdapter(category.movies)
            rvCategory.layoutManager = LinearLayoutManager(
                itemView.context,
                RecyclerView.HORIZONTAL,
                false
            )


        }
    }

}