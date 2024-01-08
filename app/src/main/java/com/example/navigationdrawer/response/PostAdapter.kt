package com.example.navigationdrawer.response

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdrawer.R

class PostAdapter(private val list: ArrayList<PostResponse>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(postResponse: PostResponse) {
            with(itemView) {
                val text = "id: ${postResponse.id}\n" +
                        "title: ${postResponse.title}\n" +
                        "text: ${postResponse.text}\n"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

    }
}