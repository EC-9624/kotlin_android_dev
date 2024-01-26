package com.example.firebasememo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase_auth.databinding.ActivityUserBinding


class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 前画面からユーザ情報を受け取る
        val myIntent = intent;
        val user = myIntent.getStringExtra("userName")
        val email = myIntent.getStringExtra("email")
        binding.tvUser.text= user
        binding.tvEmail.text = email

    }


}