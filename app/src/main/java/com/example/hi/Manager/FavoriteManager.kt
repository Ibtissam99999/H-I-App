package com.example.hi.Manager


import com.example.hi.data.JewelryItem

object FavoriteManager {
    private val favorites = mutableListOf<JewelryItem>()

    fun addToFavorites(item: JewelryItem) {
        favorites.add(item)
    }

    fun getFavorites(): MutableList<JewelryItem> = favorites
}

