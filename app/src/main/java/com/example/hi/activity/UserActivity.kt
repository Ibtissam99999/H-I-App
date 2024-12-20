package com.example.hi.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hi.List.recommendedItems
import com.example.hi.R
import com.example.hi.adapter.RecommandAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Call button
        val call = findViewById<ImageButton>(R.id.call)
        call.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:0600000000")
            startActivity(callIntent)
        }

        // Settings button
        val setting = findViewById<ImageButton>(R.id.setting)
        setting.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

        // Wallet button
        val wallet = findViewById<CardView>(R.id.wallet)
        wallet.setOnClickListener {
            val intent = Intent(this, WalletActivity::class.java)
            startActivity(intent)
        }

        // Gift Cart button
        val giftCart = findViewById<CardView>(R.id.giftCart)
        giftCart.setOnClickListener {
            val intent = Intent(this, GiftActivity::class.java)
            startActivity(intent)
        }

        // About Us button
        val about = findViewById<CardView>(R.id.about)
        about.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        // Shipped button
        val shipped = findViewById<CardView>(R.id.shipping)
        shipped.setOnClickListener {
            val intent = Intent(this, ShippedActivity::class.java)
            startActivity(intent)
        }

        // Review button
        val review = findViewById<CardView>(R.id.review)
        review.setOnClickListener {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }

        // Returns button
        val returns = findViewById<CardView>(R.id.returns)
        returns.setOnClickListener {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }

        // RecyclerView for "Also you like"
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = RecommandAdapter(this, recommendedItems) { product ->
            // Action to take when an item is clicked
            val intent = Intent(this, DetailItemActivity::class.java)
            intent.putExtra("title", product.title)
            intent.putExtra("prix", product.price.toString())
            startActivity(intent)
        }

        // Bottom Navigation Bar
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.acc
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.category -> {
                    val intent = Intent(this, CategoryActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.cart -> {
                    val intent = Intent(this, CartActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.fav -> {
                    val intent = Intent(this, FavoritesActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.acc -> {
                    true
                }
                else ->false
            }
        }
    }
}
