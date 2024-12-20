package com.example.hi.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.hi.R
import com.example.hi.adapter.CategoryPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)

        val adapter = CategoryPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        //Buttom_Nav_Bar
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.category
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.category -> {
                    true
                }
                R.id.home -> {
                    val intent = Intent(this,HomeActivity::class.java)
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
                else -> false
            }
        }
    }
}
