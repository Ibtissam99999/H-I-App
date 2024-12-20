package com.example.hi.Manager

import com.example.hi.data.CartItem
import com.example.hi.data.JewelryItem

object PanierManager {
    private val favorites = mutableListOf<CartItem>(

    )

    fun addToFavorites(item: CartItem) {
        favorites.add(item)
    }

    fun getFavorites(): MutableList<CartItem> = favorites
}
