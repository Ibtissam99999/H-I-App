package com.example.hi.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hi.R
import com.example.hi.data.CartItem

class CartAdapter(
    private val cartItems: MutableList<CartItem>,
    private val updateTotalPrice: () -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.productName.text = cartItem.name
        holder.productPrice.text = "$${"%.2f".format(cartItem.price)}"
        holder.productQuantity.text = cartItem.quantity.toString()

        // Calcul du prix total de l'article
        holder.productTotalPrice.text = "$${"%.2f".format(cartItem.price * cartItem.quantity)}"

        // Augmenter la quantité
        holder.btnIncrease.setOnClickListener {
            cartItem.quantity += 1
            notifyItemChanged(position)  // Re-mettre à jour l'élément du RecyclerView
            updateTotalPrice()  // Recalculer le total du panier
        }

        // Diminuer la quantité
        holder.btnDecrease.setOnClickListener {
            if (cartItem.quantity > 1) {
                cartItem.quantity -= 1
                notifyItemChanged(position)
                updateTotalPrice()
            }
        }
    }

    override fun getItemCount(): Int = cartItems.size

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.tv_product_name)
        val productPrice: TextView = itemView.findViewById(R.id.tv_product_price)
        val productQuantity: TextView = itemView.findViewById(R.id.tv_product_quantity)
        val productTotalPrice: TextView = itemView.findViewById(R.id.tv_product_total_price)
        val btnIncrease: Button = itemView.findViewById(R.id.btn_increase)
        val btnDecrease: Button = itemView.findViewById(R.id.btn_decrease)
    }
}
