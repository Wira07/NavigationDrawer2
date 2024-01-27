package com.example.navigationdrawer.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import com.example.navigationdrawer.MainActivity
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Animations
        topAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        binding.gambar1.startAnimation(topAnim)
        binding.logoName.startAnimation(topAnim)
        binding.sloganName.startAnimation(topAnim)
        binding.username.startAnimation(bottomAnim)
        binding.password.startAnimation(bottomAnim)
        binding.forget.startAnimation(bottomAnim)
        binding.buttonSign.startAnimation(bottomAnim)
        binding.signup.startAnimation(bottomAnim)

        binding.buttonSign.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("kunci", "Nilai yang akan Anda kirim")
            startActivity(intent)
        }

    }
}