package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RecyclerviewItemBinding
import com.squareup.picasso.Picasso


class CustomRecyclerAdapter(private var context: Context, val userItem: List<DataX>): RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

        class MyViewHolder(binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
            val largeTextView = binding.textViewLarge
            val smallTextView = binding.textViewSmall
            val image = binding.imView

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding =
            RecyclerviewItemBinding
                .inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userItem.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.largeTextView.text = userItem[position].first_name
        holder.smallTextView.text = userItem[position].email
        Picasso.get()
            .load(userItem[position].avatar)
            .into(holder.image)
    }


}