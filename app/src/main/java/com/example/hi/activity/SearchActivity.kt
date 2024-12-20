package com.example.hi.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hi.List.searchList
import com.example.hi.R
import com.example.hi.adapter.SearchAdapter
import com.example.hi.data.JewelryItem

class SearchActivity : AppCompatActivity() {
    private lateinit var searchBox: EditText
    private lateinit var ls: ListView
    private lateinit var cancel: TextView
    private var listeFiltrée: MutableList<JewelryItem> = mutableListOf()
    private lateinit var searchAdapter: SearchAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        searchBox = findViewById(R.id.search)
        ls = findViewById(R.id.serres)
        cancel = findViewById(R.id.cancel)

        // Initialize the adapter
        listeFiltrée.addAll(searchList) // Initially, show all items
        searchAdapter = SearchAdapter(this, listeFiltrée)
        ls.adapter = searchAdapter

        searchBox.setOnClickListener {
            configurerRecherche()
            cancel.visibility = View.VISIBLE
        }
    }

    private fun configurerRecherche() {
        searchBox.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                filtrerListe(s.toString())
            }
        })
    }

    private fun filtrerListe(texte: String) {
        listeFiltrée.clear()
        if (texte.isEmpty()) {
            listeFiltrée.addAll(searchList)
        } else {
            listeFiltrée.addAll(searchList.filter {
                it.title.contains(texte, ignoreCase = true)
            })
        }
        // Notify the adapter about data changes
        searchAdapter.notifyDataSetChanged()
    }
}
