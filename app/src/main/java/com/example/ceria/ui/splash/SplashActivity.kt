package com.example.ceria.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ceria.ui.main.MainActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity<MainActivity>()
        finish()
    }
}