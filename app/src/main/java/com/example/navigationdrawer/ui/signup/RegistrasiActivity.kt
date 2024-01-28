package com.example.navigationdrawer.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import com.example.navigationdrawer.MainActivity
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.ActivityRegistrasiBinding

class RegistrasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topAnimPair = Pair(binding.gambar1, R.anim.top_animation)
        val logoNamePair = Pair(binding.logoName, R.anim.top_animation)
        val Pairfullname = Pair(binding.name, R.anim.top_animation)
        val Email = Pair(binding.email, R.anim.top_animation)
        val Phone = Pair(binding.phoneNo, R.anim.top_animation)
        val sloganNamePair = Pair(binding.sloganName, R.anim.top_animation)
        val usernamePair = Pair(binding.username, R.anim.bottom_animation)
        val passwordPair = Pair(binding.password, R.anim.bottom_animation)
        val buttonSignPair = Pair(binding.buttonSign, R.anim.bottom_animation)
        val signupPair = Pair(binding.buttonIhave, R.anim.bottom_animation)

        val pairs = arrayOf(
            topAnimPair,
            logoNamePair,
            Pairfullname,
            Email,
            Phone,
            sloganNamePair,
            usernamePair,
            passwordPair,
            buttonSignPair,
            signupPair
        )

        pairs.forEach { pair ->
            pair.first.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this, pair.second))
        }

        binding.buttonSign.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("kunci", "Nilai yang akan Anda kirim")
            startActivity(intent)
        }
    }
}
