package com.lnavmon.practica1.iu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.lnavmon.practica1.R

import com.lnavmon.practica1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MenuProvider {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView as NavigationBarView
        val navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        binding.bottomNavigationView.setupWithNavController(navController)
        setSupportActionBar(binding.materialToolbar)
        setupActionBarWithNavController(navController, AppBarConfiguration(setOf(R.id.newQuotationFragment, R.id.aboutDialogFragment,R.id.favouritesFragment,R.id.settingsFragment)))

    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_about, menu)

    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        addMenuProvider(this)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView as NavigationBarView
        val navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        navController.navigate(R.id.aboutDialogFragment)
        if(menuItem.itemId == R.id.aboutDialogFragment){
            return true
        }else if(menuItem.itemId == R.id.favouritesFragment){
            return true
        }else if(menuItem.itemId == R.id.settingsFragment){
            return true
        }else if(menuItem.itemId == R.id.newQuotationFragment){
            return true
        }else{
            return false
        }
    }

}