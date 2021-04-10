package com.example.ceria.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ceria.R
import com.example.ceria.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_main)
        binding.navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment /*||
                destination.id == R.id.profileFragment ||
                destination.id == R.id.billingFragment ||
                destination.id == R.id.installmentFragment ||
                destination.id == R.id.messageFragment ||
                */
            ) {
//                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                binding.navView.visibility = View.VISIBLE
            } else {
//                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                binding.navView.visibility = View.GONE
            }
        }
    }
}
