package com.example.navigationdrawer.response

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.navigationdrawer.ui.about.AboutFragment
import com.example.navigationdrawer.ui.cart.CartFragment
import com.example.navigationdrawer.ui.gallery.GalleryFragment
import com.example.navigationdrawer.ui.upload.Upload_Fragment


class SectionsPagerAdapter (activity: AppCompatActivity) : FragmentStateAdapter(activity)  {
    override fun getItemCount(): Int {
            return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = AboutFragment()
            1 -> fragment = CartFragment()
        }
        return fragment as Fragment
    }

}