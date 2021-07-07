package com.sun.hero_02.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sun.hero_02.R
import com.sun.hero_02.databinding.ActivityMainBinding
import com.sun.hero_02.screen.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, HomeFragment.newInstance())
            .commit()
    }
}
