package com.example.navigationdrawer.ui.signup.loginsignup

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.ActivityStartupBinding
import com.example.navigationdrawer.ui.signup.SignupActivity

class StartupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartupBinding
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Animations
        topAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        binding.imageView.startAnimation(topAnim)
        binding.WiraSukmaSaputra.startAnimation(bottomAnim)
        binding.Deskripsi.startAnimation(bottomAnim)
        binding.loginButton.startAnimation(bottomAnim)
        binding.signupButton.startAnimation(bottomAnim)
        binding.Wira2.startAnimation(bottomAnim)

//        binding.loginButton.setOnClickListener {
//            val loginIntent = Intent(this@StartupActivity, SignupActivity::class.java)
//            startActivity(loginIntent)
//        }
//
        binding.signupButton.setOnClickListener {
            val signupIntent = Intent(this@StartupActivity, SignupActivity::class.java)
            startActivity(signupIntent)
        }
    }
    fun callLogin(view: View) {
        val intent = Intent(applicationContext, SignupActivity::class.java)

        // Correctly create the Pair array with a single Pair element:
        val pairs = arrayOf(Pair(view, "transition_login"))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@StartupActivity)
            startActivity(intent, options.toBundle())
        } else {
            startActivity(intent)
        }
    }
}
