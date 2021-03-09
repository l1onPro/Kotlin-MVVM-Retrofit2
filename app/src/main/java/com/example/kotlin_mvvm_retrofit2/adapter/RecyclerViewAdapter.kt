package com.example.kotlin_mvvm_retrofit2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_mvvm_retrofit2.R
import com.example.kotlin_mvvm_retrofit2.models.RecyclerData
import com.squareup.picasso.Picasso

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var items = ArrayList<RecyclerData>()

    fun setUpdatedData(items : ArrayList<RecyclerData>) {
        this.items = items
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val imageThumb = itemView.findViewById<ImageView>(R.id.imageThumb)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        private val tvDesk = itemView.findViewById<TextView>(R.id.tv_desc)

        fun bind(data: RecyclerData) {
            tvTitle.text = data.name
            tvDesk.text = data.description

            val url = data.owner.avatar_url

            Picasso.get()
                .load(url)
                .into(imageThumb)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }
}