package com.example.hi.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.hi.List.bracelets
import com.example.hi.R
import com.example.hi.activity.DetailItemActivity
import com.example.hi.adapter.CategoryGridAdapter

class CategoryFragment : Fragment() {

    private var categoryName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryName = arguments?.getString("CATEGORY_NAME")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)
        val gridView = view.findViewById<GridView>(R.id.grid_categories)


        gridView.adapter = CategoryGridAdapter(requireContext(), bracelets)

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
//            val category = Category("Rings", R.drawable.download)
            val intent = Intent(requireContext(), DetailItemActivity::class.java)
//            intent.putExtra("CATEGORY", category)
            startActivity(intent)

        }


        return view
    }

    companion object {
        fun newInstance(category: String): CategoryFragment {
            val fragment = CategoryFragment()
            val args = Bundle()
            args.putString("CATEGORY_NAME", category)
            fragment.arguments = args
            return fragment
        }
    }
}
