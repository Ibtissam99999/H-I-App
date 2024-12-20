package com.example.hi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hi.R
import com.example.hi.data.ShippedItem

class ShippedAdapter(private val shippedItems: List<ShippedItem>) :
    RecyclerView.Adapter<ShippedAdapter.ShippedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShippedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_shipped, parent, false)
        return ShippedViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShippedViewHolder, position: Int) {
        val item = shippedItems[position]
        holder.commandTextView.text = item.command
        holder.statusTextView.text = item.status

        // Change l'icône en fonction de l'état
        when (item.status) {
            "En cours" -> holder.statusImageView.setImageResource(R.drawable.ic_shipping)
            "Expédiée" -> holder.statusImageView.setImageResource(R.drawable.ic_shipped)
            "Livrée" -> holder.statusImageView.setImageResource(R.drawable.ic_delivered)
        }
    }

    override fun getItemCount(): Int = shippedItems.size

    class ShippedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val commandTextView: TextView = itemView.findViewById(R.id.command_text)
        val statusTextView: TextView = itemView.findViewById(R.id.status_text)
        val statusImageView: ImageView = itemView.findViewById(R.id.status_icon)
    }
}
