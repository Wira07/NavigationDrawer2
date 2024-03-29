package com.example.navigationdrawer.ui.signup

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationdrawer.MainActivity
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.ActivitySignupBinding
import com.google.android.material.animation.AnimatorSetCompat.playTogether
import kotlinx.coroutines.NonCancellable.start

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        playAnimation()
        val topAnimPair = Pair(binding.gambar1, R.anim.top_animation)
        val logoNamePair = Pair(binding.logoName, R.anim.top_animation)
        val sloganNamePair = Pair(binding.sloganName, R.anim.top_animation)
        val usernamePair = Pair(binding.username, R.anim.bottom_animation)
        val passwordPair = Pair(binding.password, R.anim.bottom_animation)
        val forgetPair = Pair(binding.forget, R.anim.bottom_animation)
        val buttonSignPair = Pair(binding.buttonSign, R.anim.bottom_animation)
        val signupPair = Pair(binding.signup, R.anim.bottom_animation)

        val pairs = arrayOf(
            topAnimPair,
            logoNamePair,
            sloganNamePair,
            usernamePair,
            passwordPair,
            forgetPair,
            buttonSignPair,
            signupPair
        )

        pairs.forEach { pair ->
            pair.first.startAnimation(AnimationUtils.loadAnimation(this, pair.second))
        }

        binding.buttonSign.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("kunci", "Nilai yang akan Anda kirim")
            startActivity(intent)
        }

        binding.signup.setOnClickListener {
            if (validateForm()) {
                // Jika form valid, pindah ke RegistrasiActivity
                val intent = Intent(this, RegistrasiActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.gambar1, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 3000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()
    }

    private fun validateForm(): Boolean {
        val username = binding.username.editText?.text.toString().trim()
        val password = binding.password.editText?.text.toString().trim()
        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Mohon lengkapi semua bidang isian.")
            return false
        }
        return true
    }
    // Fungsi untuk menampilkan pesan Toast
    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
