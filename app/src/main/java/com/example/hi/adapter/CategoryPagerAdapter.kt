package com.example.hi.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.hi.Fragment.CategoryFragment

class CategoryPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val categories = listOf("Rings", "Earring", "Bracelet", "Necklace", "Watche")

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CategoryFragment.newInstance("Rings")
            1 -> CategoryFragment.newInstance("Earrings")
            2 -> CategoryFragment.newInstance("Bracelets")
            3 -> CategoryFragment.newInstance("Necklaces")
            4 -> CategoryFragment.newInstance("Watches")
            else -> CategoryFragment.newInstance("Autre")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return categories[position]
    }

    override fun getCount(): Int {
        return categories.size
    }
}
