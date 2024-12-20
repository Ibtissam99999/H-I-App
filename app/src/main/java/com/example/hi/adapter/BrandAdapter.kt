package com.example.hi.adapter

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.hi.R
import com.example.hi.data.Brand

class BrandAdapter(private val brands: List<Brand>) : RecyclerView.Adapter<BrandAdapter.BrandViewHolder>() {

    private var selectPosition = -1
    private var lastSelectPosition = -1
    private lateinit var context: Context

    class BrandViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.img)
        val titleView: TextView = view.findViewById(R.id.title)
        val cardView: LinearLayout = view.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.viewholder_jewelry, parent, false)
        return BrandViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val brand = brands[position]

        holder.imageView.setImageResource(brand.imageRes)
        holder.titleView.text = brand.title

        holder.cardView.setOnClickListener() {
            lastSelectPosition = selectPosition
            selectPosition = position
            notifyItemChanged(selectPosition)
            notifyItemChanged(lastSelectPosition)
        }

        if (selectPosition == position) {
            val drawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.rounded)
            holder.cardView.background = drawable
            holder.titleView.visibility = View.VISIBLE
        } else {
            holder.cardView.background = null
            holder.titleView.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = brands.size
}
