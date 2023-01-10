package com.igti.netfilxapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.igti.netfilxapp.R
import com.igti.netfilxapp.model.Category

class CategoryAdapter(
    private val categories: List<Category>,
    private val onItemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.CategoryViewHolder {

        val movieView = LayoutInflater.from(parent.context).inflate(
            R.layout.category_item,
            parent,
            false
        )
        return CategoryViewHolder(movieView)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int = categories.size


    inner class CategoryViewHolder(movieItem: View) : RecyclerView.ViewHolder(movieItem) {

        fun bind(category: Category) {
            val txtTitle = itemView.findViewById<TextView>(R.id.txt_title)
            txtTitle.text = category.name

            val rvCategory = itemView.findViewById<RecyclerView>(R.id.rv_category)

            rvCategory.adapter = MovieAdapter(
                category.movies,
                R.layout.movie_item,
                onItemClickListener
            )

            rvCategory.layoutManager = LinearLayoutManager(
                itemView.context,
                RecyclerView.HORIZONTAL,
                false
            )
        }
    }

}