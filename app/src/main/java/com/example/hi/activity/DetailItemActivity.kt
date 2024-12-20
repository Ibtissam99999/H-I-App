package com.example.hi.activity

import com.example.hi.List.recommendedItems
import com.example.hi.adapter.RecommandAdapter
import com.example.hi.data.JewelryItem
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hi.Manager.PanierManager
import com.example.hi.R
import com.example.hi.data.CartItem


class DetailItemActivity : AppCompatActivity() {
    private var isFavorite = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_item)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val addCart = findViewById<Button>(R.id.addCart)
        val id = intent.getIntExtra("id", 0)
        val title = intent.getStringExtra("title")
        val price = intent.getDoubleExtra("price", 0.0)
        val image = intent.getIntExtra("image", 0)

        val txtTitle = findViewById<TextView>(R.id.txNom)
        val txtPrice = findViewById<TextView>(R.id.txprice)
        val imageView = findViewById<ImageView>(R.id.imageItem)

        txtTitle.text = title
        txtPrice.text = price.toString()
        imageView.setImageResource(image)

        addCart.setOnClickListener {
            try {
                val quantity = findViewById<TextView>(R.id.quantite).text.toString().toInt()
                PanierManager.addToFavorites(CartItem(title.toString(), price.toDouble(), quantity))
                Toast.makeText(this, "Ajouté au panier", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur : ${e.message}", Toast.LENGTH_SHORT).show()
                println("DEBUG: Erreur - ${e.message}")
            }
        }


        val back = findViewById<ImageButton>(R.id.back)
        back.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        //fav click

        val favIcon = findViewById<ImageButton>(R.id.fav)
        favIcon.setOnClickListener {


            isFavorite = !isFavorite
            favIcon.setImageResource(if (isFavorite) R.drawable.heart_red else R.drawable.heart)
        }





        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = RecommandAdapter(this,recommendedItems,::openDetailActivity)

    }
    fun afficherMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    private fun openDetailActivity(item: JewelryItem) {
        val intent = Intent(this, DetailItemActivity::class.java).apply {
            putExtra("id", item.id)
            putExtra("title", item.title)
            putExtra("price", item.price)
            putExtra("image", item.imageRes)
        }
        startActivity(intent)
    }

}