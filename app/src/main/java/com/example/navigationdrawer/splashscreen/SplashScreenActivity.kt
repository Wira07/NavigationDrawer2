package com.example.navigationdrawer.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.navigationdrawer.MainActivity
import com.example.navigationdrawer.R
import com.example.navigationdrawer.ui.signup.SignupActivity

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 2000 // 2 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Using Handler to delay the start of the next activity
        Handler().postDelayed({
            val intent = Intent(this@SplashScreenActivity, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}