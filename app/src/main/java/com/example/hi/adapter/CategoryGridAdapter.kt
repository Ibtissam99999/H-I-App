package com.example.hi.adapter




import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.hi.R
import com.example.hi.data.JewelryItem

class CategoryGridAdapter(private val context: Context, private val categoryList: List<JewelryItem>) : BaseAdapter() {

    override fun getCount(): Int {
        return categoryList.size
    }

    override fun getItem(position: Int): Any {
        return categoryList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = convertView ?: inflater.inflate(R.layout.item_category, parent, false)

        // Récupérer les vues du layout
        val categoryImage = view.findViewById<ImageView>(R.id.category_image)
        val categoryName = view.findViewById<TextView>(R.id.category_name)

        // Remplir les données
        val category = categoryList[position]
        categoryName.text = category.title

        // Charger l'image de la catégorie
        categoryImage.setImageResource(category.imageRes)

        return view
    }
}
