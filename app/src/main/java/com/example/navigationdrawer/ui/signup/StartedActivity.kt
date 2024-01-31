package com.example.navigationdrawer.ui.signup

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.ActivityStartedBinding
import com.example.navigationdrawer.ui.signup.loginsignup.StartupActivity

class StartedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartedBinding
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        playAnimation()

        // Animations
        topAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        // Set animations to ImageView and Logo using ViewBinding
        binding.imageView.startAnimation(topAnim)
        binding.text1.startAnimation(bottomAnim)
        binding.btnNavigate.startAnimation(bottomAnim)

        binding.btnNavigate.setOnClickListener {
            val intent = Intent(this, StartupActivity::class.java)
            intent.putExtra("kunci", "Nilai yang akan Anda kirim")
            startActivity(intent)
        }
    }
    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imageView, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 3000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()
    }

}