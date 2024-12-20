package com.example.hi.adapter

import com.example.hi.R
import com.example.hi.data.GiftCard


import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



import android.view.ViewGroup

class GiftCardAdapter(private val GiftList : List<GiftCard>) :
    RecyclerView.Adapter<GiftCardAdapter.GiftCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiftCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_gift, parent, false)
        return GiftCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: GiftCardViewHolder, position: Int) {
        val giftCard = GiftList[position]
        holder.code.text = "Code :  ${giftCard.code}"
        holder.img.setImageResource(giftCard.image)
    }

    override fun getItemCount(): Int = GiftList.size

    class GiftCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageButton>(R.id.imgGift)
        val code = itemView.findViewById<TextView>(R.id.code)
    }
}