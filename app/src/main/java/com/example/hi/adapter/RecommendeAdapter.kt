package com.example.hi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hi.R
import com.example.hi.data.JewelryItem
import com.example.hi.List.favoriteItems  // Assurez-vous d'importer la liste partagée
import com.example.hi.Manager.FavoriteManager

class RecommandAdapter(
    private val context: Context,
    private val items: List<JewelryItem>,
    val onClick: (JewelryItem) -> Unit
) : RecyclerView.Adapter<RecommandAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_recomande, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val isFavorited = favoriteItems.contains(item)  // Vérifiez si l'élément est dans la liste des favoris
        holder.bind(item, isFavorited)

        holder.itemView.setOnClickListener {
            onClick(item)
        }

        holder.favIcon.setOnClickListener {
            if (isFavorited) {
                favoriteItems.remove(item)

                Toast.makeText(context, "${item.title} retiré des favoris", Toast.LENGTH_SHORT).show()
            } else {
                favoriteItems.add(item)  // Ajouter aux favoris
                FavoriteManager.addToFavorites(JewelryItem(1,item.title,item.price,item.imageRes))
                Toast.makeText(context, "${item.title} ajouté aux favoris", Toast.LENGTH_SHORT).show()
            }
            notifyItemChanged(position)  // Mettre à jour l'élément dans l'adaptateur
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.title)
        private val price: TextView = itemView.findViewById(R.id.price)
        private val image: ImageView = itemView.findViewById(R.id.imag)
        val favIcon: ImageView = itemView.findViewById(R.id.favIcon)

        fun bind(item: JewelryItem, isFavorited: Boolean) {
            title.text = item.title
            price.text = item.price
            image.setImageResource(item.imageRes)

            favIcon.setImageResource(
                if (isFavorited) R.drawable.heart_red else R.drawable.heart
            )
        }
    }
}
