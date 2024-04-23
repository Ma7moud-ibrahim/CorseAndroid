package com.example.mytabslayout.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mytabslayout.fragment.Home
import com.example.mytabslayout.fragment.Profile
import com.example.mytabslayout.fragment.Setting

class MyAdapter(
    fragmentActivity: FragmentActivity,
    private val totalTabs: Int
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return totalTabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Home()
            1 -> Profile()
            2 -> Setting()
            else -> throw IndexOutOfBoundsException("Invalid tab position")
        }
    }
}
