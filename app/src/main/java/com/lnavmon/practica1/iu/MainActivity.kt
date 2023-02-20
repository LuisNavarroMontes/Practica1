package com.lnavmon.practica1.iu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.lnavmon.practica1.R

import com.lnavmon.practica1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        binding.bottomNavigationView.setupWithNavController(navController)
        setSupportActionBar(binding.materialToolbar)
        setupActionBarWithNavController(navController, AppBarConfiguration(setOf(R.id.newQuotationFragment, R.id.aboutDialogFragment,R.id.favouritesFragment,R.id.settingsFragment)))

    }
}