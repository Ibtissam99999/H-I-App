package com.example.hi.activity

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hi.R
import com.example.hi.adapter.ShippedAdapter
import com.example.hi.data.ShippedItem
import kotlinx.coroutines.*

class ShippedActivity : AppCompatActivity() {

    private val shippedItems = mutableListOf(
        ShippedItem("Commande 1", "En cours")
    )
    private lateinit var adapter: ShippedAdapter
    lateinit var recycler_shipped : RecyclerView
    private val statusList = listOf("En cours", "Expédiée", "Livrée") // États possibles
    private var coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipped)

        recycler_shipped = findViewById(R.id.recycler_shipped)

        // Initialisation de l'Adapter et de la RecyclerView
        adapter = ShippedAdapter(shippedItems)
        recycler_shipped.layoutManager = LinearLayoutManager(this)
        recycler_shipped.adapter = adapter

        // Lancer la mise à jour automatique des états
        startStatusUpdate()

        // Configurer le bouton retour
        val back = findViewById<ImageButton>(R.id.back)
        back.setOnClickListener {
            coroutineScope.cancel() // Arrêter les mises à jour si on quitte l'activité
            finish()
        }
    }

    private fun startStatusUpdate() {
        coroutineScope.launch {
            while (true) {
                delay(5000) // Attendre 5 secondes

                // Mettre à jour les états des commandes
                for (item in shippedItems) {
                    val currentIndex = statusList.indexOf(item.status)
                    if (currentIndex < statusList.size - 1) {
                        item.status = statusList[currentIndex + 1]
                    }
                }

                // Notifier l'Adapter des changements
                adapter.notifyDataSetChanged()

                // Arrêter si toutes les commandes sont "Livrée"
                if (shippedItems.all { it.status == "Livrée" }) {
                    break
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel() // Arrêter les coroutines en quittant l'activité
    }
}
