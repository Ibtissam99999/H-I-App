package com.example.hi.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.hi.List.brands
import com.example.hi.List.recommendedItems
import com.example.hi.R
import com.example.hi.adapter.BrandAdapter
import com.example.hi.adapter.RecommandAdapter
import com.example.hi.adapter.ViewPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewPager: ViewPager2 = findViewById(R.id.viewPagerSlider)

        val images = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)

        viewPager.adapter = ViewPagerAdapter(images)


        //btnNotification
        var btnNotif = findViewById<ImageButton>(R.id.notification)
        btnNotif.setOnClickListener{
            val intent = Intent(this,NotificationActivity::class.java)
            startActivity(intent)
        }

        //btnsearch
        var btnSearsh = findViewById<ImageButton>(R.id.search)
        btnSearsh.setOnClickListener{
            val intent = Intent(this,SearchActivity::class.java)
            startActivity(intent)
        }

//        seeall intent

        val seeall=findViewById<TextView>(R.id.seeAll)
        seeall.setOnClickListener{
            val intent = Intent(this,CategoryActivity::class.java)
            startActivity(intent)
        }


        val seeal=findViewById<TextView>(R.id.seeAl)
        seeal.setOnClickListener{
            val intent = Intent(this,CategoryActivity::class.java)
            startActivity(intent)
        }


        // Set up RecyclerView for Brands
        val brandRecyclerView: RecyclerView = findViewById(R.id.recyclerView)
        brandRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        brandRecyclerView.adapter = BrandAdapter(brands)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = RecommandAdapter(this,recommendedItems){
            product ->
            val intent = Intent(this, DetailItemActivity::class.java)
            intent.putExtra("title",product.title)
            intent.putExtra("prix",product.price)
            intent.putExtra("image",product.imageRes)
            startActivity(intent)
        }

//        Buttom_Nav_Bar
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.home
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