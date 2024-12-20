package com.example.hi.activity

import FavoriteProductAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hi.Manager.FavoriteManager
import com.example.hi.R
import com.example.hi.adapter.RecommandAdapter
import com.example.hi.data.JewelryItem

import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        // Configuration du RecyclerView pour une liste verticale
        val recyclerView = findViewById<RecyclerView>(R.id.favorites_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Récupérer les favoris depuis le FavoriteManager
        val favoriteItems = FavoriteManager.getFavorites()
        val list = FavoriteManager.getFavorites()

        recyclerView.adapter = FavoriteProductAdapter(favoriteItems) { product ->
            val intent = Intent(this, DetailItemActivity::class.java)
            intent.putExtra("title", product.title)
            intent.putExtra("prix", product.price)
            intent.putExtra("imageRes", product.imageRes)
            startActivity(intent)
        }

        // Bottom Navigation Bar
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.fav
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    true
                }
                R.id.category -> {
                    val intent = Intent(this,CategoryActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.cart -> {
                    val intent = Intent(this,CartActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.fav -> {
                    val intent = Intent(this,FavoritesActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.acc -> {
                    val intent = Intent(this,UserActivity::class.java)
                    startActivity(intent)
                    true
                }
                else ->false
            }
        }
    }
}
