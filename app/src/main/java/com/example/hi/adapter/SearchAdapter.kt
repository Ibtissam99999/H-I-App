package com.example.hi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.hi.R
import com.example.hi.data.JewelryItem

class SearchAdapter(
    private val context: Context,
    private var jewelryList: MutableList<JewelryItem> // Liste mutable pour permettre les modifications dynamiques
) : BaseAdapter() {

    override fun getCount(): Int {
        return jewelryList.size
    }

    override fun getItem(position: Int): Any {
        return jewelryList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_jewelry, parent, false)

        val titleTextView: TextView = view.findViewById(R.id.titel)

        val jewelryItem = getItem(position) as JewelryItem

        titleTextView.text = jewelryItem.title


        fun updateData(newList: MutableList<JewelryItem>) {
           jewelryList= newList
            notifyDataSetChanged()
        }

        return view
    }
}
