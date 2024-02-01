package com.example.navigationdrawer.ui.signup

import android.animation.ObjectAnimator
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationdrawer.MainActivity
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.ActivityRegistrasiBinding

class RegistrasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playAnimation()

        val pairs = arrayOf(
            Pair(binding.gambar1, R.anim.top_animation),
            Pair(binding.logoName, R.anim.top_animation),
            Pair(binding.name, R.anim.top_animation),
            Pair(binding.email, R.anim.top_animation),
            Pair(binding.phoneNo, R.anim.top_animation),
            Pair(binding.sloganName, R.anim.top_animation),
            Pair(binding.username, R.anim.bottom_animation),
            Pair(binding.password, R.anim.bottom_animation),
            Pair(binding.buttonSign, R.anim.bottom_animation),
            Pair(binding.buttonIhave, R.anim.bottom_animation)
        )

        pairs.forEach { pair ->
            pair.first.startAnimation(AnimationUtils.loadAnimation(this, pair.second))
        }

        binding.buttonSign.setOnClickListener {
            if (validateForm()) {
                val intent = Intent(this, SignupActivity::class.java)
                intent.putExtra("kunci", "Nilai yang akan Anda kirim")
                startActivity(intent)
                showMessage()
            }
        }
    }
    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.gambar1, View.TRANSLATION_X, -50f, 50f).apply {
            duration = 3000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()
    }
    private fun validateForm(): Boolean {
        // Mendapatkan nilai dari setiap bidang isian
        val name = binding.name.editText?.text.toString().trim()
        val email = binding.email.editText?.text.toString().trim()
        val phone = binding.phoneNo.editText?.text.toString().trim()
        val username = binding.username.editText?.text.toString().trim()
        val password = binding.password.editText?.text.toString().trim()
        // Memeriksa apakah ada bidang isian yang kosong
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty()) {
            showMessage("Mohon lengkapi semua bidang isian.")
            return false
        }
        // Memeriksa apakah format email valid
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showMessage("Format email tidak valid.")
            return false
        }
        // Anda dapat menambahkan validasi tambahan sesuai kebutuhan (contoh: panjang kata sandi, dll.)
        // Jika semua validasi berhasil, kembalikan true
        return true
    }
    private fun showMessage() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sukses")
            .setMessage("Akun berhasil dibuat!")
            .setPositiveButton("OK") { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
                // Pindah ke MainActivity setelah menekan tombol OK
                val intent = Intent(this, SignupActivity::class.java)
                intent.putExtra("kunci", "Nilai yang akan Anda kirim")
                startActivity(intent)
            }
            .show()
    }

    // Fungsi untuk menampilkan pesan Toast
    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
