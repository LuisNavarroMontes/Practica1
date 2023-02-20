package com.lnavmon.practica1.iu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lnavmon.practica1.R
import com.lnavmon.practica1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}