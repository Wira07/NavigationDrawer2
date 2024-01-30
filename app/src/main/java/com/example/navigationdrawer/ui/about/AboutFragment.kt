package com.example.navigationdrawer.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)

        // Animations
        topAnim = android.view.animation.AnimationUtils.loadAnimation(requireContext(), R.anim.top_animation)
        bottomAnim = android.view.animation.AnimationUtils.loadAnimation(requireContext(), R.anim.bottom_animation)

        binding.container.startAnimation(topAnim)
        binding.profileImage.startAnimation(topAnim)
        binding.fullName.startAnimation(topAnim)
        binding.androidDeveloper.startAnimation(topAnim)
        binding.card1.startAnimation(topAnim)
        binding.card2.startAnimation(topAnim)
        binding.containerCard1.startAnimation(bottomAnim)
        binding.containerCard2.startAnimation(bottomAnim)
        binding.namaLengkap.startAnimation(bottomAnim)
        binding.namaLengkap2.startAnimation(bottomAnim)
        binding.namaLengkap3.startAnimation(bottomAnim)
        binding.botton.startAnimation(bottomAnim)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
