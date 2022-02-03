package com.example.assigntask.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.assigntask.R
import com.example.assigntask.base.BaseActivity
import com.example.assigntask.constant.Constant
import com.example.assigntask.databinding.ActivitySplashBinding
import com.example.assigntask.login.RoleActivity
import com.example.assigntask.main.MainActivity

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        //
        initTheme()
        goToRole()
        goToMainActivity()
        goToRole()
    }

    private fun initTheme(){
        window.statusBarColor = resources.getColor(R.color.blueBackground)
        window.navigationBarColor = resources.getColor(R.color.blueBackground)
    }
    private fun goToRole() {
        if (!pref.getIsLoggedIn()) {
            Handler(Looper.getMainLooper()).postDelayed(
                Runnable {
                    val intent = Intent(this@SplashActivity, RoleActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 500
            )
        }
    }

    private fun goToMainActivity() {
        if (pref.getIsLoggedIn()) {
            Handler(Looper.getMainLooper()).postDelayed(
                Runnable {
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                }, 500
            )
        } }
}