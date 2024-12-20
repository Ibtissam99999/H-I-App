package com.example.hi.activity


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hi.R
import com.example.hi.adapter.GiftCardAdapter
import com.example.hi.data.GiftCard


class GiftActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var giftCardAdapter: GiftCardAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gift)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //back
        val back = findViewById<ImageButton>(R.id.back)
        back.setOnClickListener{
            val intent = Intent(this,UserActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.giftCart)
        recyclerView.layoutManager= GridLayoutManager(this, 2)

        val giftCards = listOf(
            GiftCard( R.drawable.gift_card,"HA123HD"),
            GiftCard(R.drawable.gift_card,"SOD12NJ"),
            GiftCard( R.drawable.gift_card,"QIEN12"),
            GiftCard(R.drawable.gift_card,"17HBH33"),
            GiftCard( R.drawable.gift_card,"5HSKZ23"),
            GiftCard( R.drawable.gift_card,"HA123HD"),
            GiftCard(R.drawable.gift_card,"SOD12NJ"),
            GiftCard( R.drawable.gift_card,"QIEN12"),
            GiftCard(R.drawable.gift_card,"17HBH33"),
            GiftCard( R.drawable.gift_card,"5HSKZ23"),
            GiftCard( R.drawable.gift_card,"19NLQ")
        )

        giftCardAdapter = GiftCardAdapter(giftCards)
        recyclerView.adapter = giftCardAdapter

    }
}