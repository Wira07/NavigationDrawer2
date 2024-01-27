package com.example.navigationdrawer.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import com.example.navigationdrawer.MainActivity
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.ActivitySplashScreenBinding
import com.example.navigationdrawer.ui.signup.SignupActivity
import com.example.navigationdrawer.ui.signup.StartedActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    private val splashTimeOut: Long = 3000
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Animations
        topAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        binding.gambar.startAnimation(topAnim)
        binding.textView2.startAnimation(bottomAnim)

        Handler().postDelayed({
            val intent = Intent(this, StartedActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimeOut)

    }
}