package com.kpmj.swahyu.footballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.kpmj.swahyu.footballclub.R
import com.kpmj.swahyu.footballclub.model.Item

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = items.size;

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val img = view.findViewById<ImageView>(R.id.imageClub)
        private val name = view.findViewById<TextView>(R.id.clubName)
        fun bindItem(item: Item, listener: (Item) -> Unit) {
            name.text = item.name
            Glide.with(itemView).load(item.image).into(img)
            itemView.setOnClickListener{
                listener(item)
            }
        }
    }

}