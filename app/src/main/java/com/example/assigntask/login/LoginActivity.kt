package com.example.assigntask.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assigntask.R
import com.example.assigntask.databinding.ActivitySplashBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}