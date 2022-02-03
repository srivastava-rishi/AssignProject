package com.example.assigntask.login

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.assigntask.R
import com.example.assigntask.constant.Constant
import com.example.assigntask.databinding.ActivityRoleBinding
import com.example.assigntask.databinding.ActivitySplashBinding
import com.example.assigntask.main.MainActivity
import java.lang.Exception

class RoleActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var binding: ActivityRoleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_role)
        initAction()
    }

    private fun initAction() {
        binding.btnAdminLogin.setOnClickListener(this)
        binding.btnUserLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnAdminLogin -> {
                val intent = Intent(this@RoleActivity, LoginActivity::class.java)
                intent.putExtra(Constant.LOGIN_TYPE, "A")
                startActivity(intent)
                finish()
            }
            R.id.btnUserLogin -> {
                val intent = Intent(this@RoleActivity, LoginActivity::class.java)
                intent.putExtra(Constant.LOGIN_TYPE, "U")
                startActivity(intent)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}