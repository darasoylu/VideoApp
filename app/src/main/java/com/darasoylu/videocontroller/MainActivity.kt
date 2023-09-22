package com.darasoylu.videocontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

import com.darasoylu.videocontroller.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bnView, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.videoFragment) {
                binding.bnView.visibility = View.GONE
            } else {
                binding.bnView.visibility = View.VISIBLE
            }
        }

    }

}