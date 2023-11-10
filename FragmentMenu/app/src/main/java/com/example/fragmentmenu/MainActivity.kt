package com.example.fragmentmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //assign btn
        val btnTop : Button = findViewById(R.id.btnTop)
        val btnMenu : Button = findViewById(R.id.btnMenu)

        btnTop.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fvMain,TopFragment.newInstance())
                .commit()
        }

        btnMenu.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fvMain,MenuFragment.newInstance())
                .commit()
        }

    }
}