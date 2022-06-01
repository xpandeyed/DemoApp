package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setCurrentFragment(firstFragment)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.item1->setCurrentFragment(firstFragment)
                R.id.item2->setCurrentFragment(secondFragment)
            }
            true
        }

    }

        private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}