package com.fernandez.practica2.launcher
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.fernandez.practica2.R
import com.fernandez.practica2.home.HomeActivity
import com.fernandez.practica2.login.LoginActivity
import kotlinx.android.synthetic.main.activity_login.*

class LauncherActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val actionBar = supportActionBar
        actionBar?.hide()

        Handler(Looper.getMainLooper()).
        postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 6000)

    }
}