package com.example.hi.activity


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hi.Manager.PanierManager
import com.example.hi.R
import com.example.hi.adapter.CartAdapter
import com.example.hi.data.CartItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class CartActivity : AppCompatActivity() {

    private val cartItems = mutableListOf<CartItem>()
    private lateinit var totalPriceTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)


        // Initialisation de la vue pour afficher le total
        totalPriceTextView = findViewById(R.id.tv_total_price)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_cart)
        val checkoutButton = findViewById<Button>(R.id.btn_checkout)

        // Initialisation des données de démo
//        initializeCartItems()

        val list = PanierManager.getFavorites().toMutableList()
        val adapter = CartAdapter(PanierManager.getFavorites().toMutableList()) { updateTotalPrice() }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        checkoutButton.setOnClickListener {
            // Simuler la finalisation de l'achat
            cartItems.clear()
            adapter.notifyDataSetChanged()
            totalPriceTextView.text = "Total: $0.00"
            checkoutButton.text = "Thank you for your purchase!"
        }

        checkoutButton.setOnClickListener{

        }

        // Calcul initial du total
        updateTotalPrice()

        //Buttom_Nav_Bar
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.cart
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

                    true
                }
                R.id.fav -> {
                    val intent = Intent(this, FavoritesActivity::class.java)
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



    private fun updateTotalPrice() {
        // Calcul du total
        val total = cartItems.sumOf { it.price * it.quantity }
        totalPriceTextView.text = "Total: $${"%.2f".format(total)}"
    }
}