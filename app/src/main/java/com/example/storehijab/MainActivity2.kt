package com.example.storehijab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {
private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
        R.id.homee -> {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_container, HomeFragment())
                .commit()
            return@OnNavigationItemSelectedListener true
        }
        R.id.bag -> {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_container, ShoopFragment())
                .commit()
            return@OnNavigationItemSelectedListener true
        }
        R.id.account -> {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_container, AccountFragment())
                .commit()
            return@OnNavigationItemSelectedListener true
        }
    }
    false
}

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main2)

    val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
    bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    supportFragmentManager.beginTransaction()
        .replace(R.id.frame_container, HomeFragment())
        .commit()

}
}