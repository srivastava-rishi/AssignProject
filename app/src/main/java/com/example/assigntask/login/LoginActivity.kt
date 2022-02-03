package com.example.assigntask.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.assigntask.R
import com.example.assigntask.base.BaseActivity
import com.example.assigntask.constant.Constant
import com.example.assigntask.databinding.ActivityLoginBinding
import com.example.assigntask.model.UserCredential
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class LoginActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    val logTag = "@LoginActivity"
    var title: String? = ""
    var userType: String? = ""
    var typeTitle = ""

    var list: MutableList<UserCredential> = mutableListOf()
    var credential: UserCredential? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        //
        initTheme()
        initData()
        initAction()
        initView()
    }

    private fun initData() {
        title = intent.getStringExtra(Constant.LOGIN_TYPE)
        if (title.equals("A")) {
            typeTitle = "Admin Login"
            userType = "admin"
        } else if (title.equals("U")) {
            typeTitle = "User Login"
            userType = "user"
        }
    }

    private fun initView() {
        binding.iAppBar.tvTitle.text = typeTitle
        binding.tvBanner.text = typeTitle

    }

    private fun initTheme(){
        window.statusBarColor = resources.getColor(R.color.d_d1_dark2)
        window.navigationBarColor = resources.getColor(R.color.blueBackground)
    }

    private fun initAction() {
        binding.btnLogIn.setOnClickListener(this)
        binding.iAppBar.ivBack.setOnClickListener(this)
    }

    private fun checkCredential() {

        binding.pbProgressBar.visibility = View.VISIBLE

        val ref = rootRef.child("credential").child("type").child(userType!!)
        val refListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val userCredential: UserCredential? =
                        snapshot.getValue(UserCredential::class.java)

                    if (userCredential != null) {
                        list.add(userCredential!!)
                    }
                    userExist(list, userType!!)

                } catch (e: Exception) {
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }
        ref.addListenerForSingleValueEvent(refListener)
    }

    private fun userExist(user: MutableList<UserCredential>, userType: String){
        if (userType == "admin") {
            binding.pbProgressBar.visibility = View.VISIBLE
        }
         if(userType == "user") {
             binding.pbProgressBar.visibility = View.VISIBLE

         }
        else{
             Toast.makeText(this@LoginActivity, "Not found", Toast.LENGTH_SHORT).show()
            finish()
         }
}

    private fun userInput() {
        var inputUsername: String? = binding.tvUserName.text.toString().trim()
        var inputPassword: String? = binding.tvPassword.text.toString().trim()

        if (inputUsername != "" && inputUsername!!.isNotEmpty() && inputPassword != "" && inputPassword!!.isNotEmpty()) {
            credential = UserCredential(
                username = inputUsername,
                password = inputPassword
            )
            checkCredential();
        } else {
            Toast.makeText(this@LoginActivity, "Enter your credential", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

            R.id.btnLogIn -> {
                val intent = Intent(this@LoginActivity, LoginActivity::class.java)
                intent.putExtra(Constant.LOGIN_TYPE, "Admin Login")
                userInput()
            }

            R.id.ivBack -> {
                finish()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}