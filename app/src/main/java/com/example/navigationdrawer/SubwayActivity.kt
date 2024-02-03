package com.example.navigationdrawer

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationdrawer.databinding.ActivitySubwayBinding
import com.example.navigationdrawer.response.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class SubwayActivity : AppCompatActivity() {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3,
            R.string.tab_text_4,
            R.string.tab_text_5
        )
    }

    private lateinit var binding: ActivitySubwayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubwayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hide ActionBar
        supportActionBar?.hide()

        with(binding) {
            val sectionsPagerAdapter = SectionsPagerAdapter(this@SubwayActivity)
            viewPager.adapter = sectionsPagerAdapter

            TabLayoutMediator(tabs, viewPager) { tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()

            // Menambahkan animasi untuk ViewPager2
            viewPager.setPageTransformer { page, position ->
                val normalizedPosition = Math.abs(Math.abs(position) - 1)
                page.scaleY = normalizedPosition / 2 + 0.5f
                page.alpha = normalizedPosition
            }
        }

        supportActionBar?.elevation = 0f
    }
}
