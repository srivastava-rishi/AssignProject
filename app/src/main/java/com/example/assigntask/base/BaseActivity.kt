package com.example.assigntask.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.Preference
import androidx.databinding.DataBindingUtil
import com.example.assigntask.R
import com.example.assigntask.data.preferences.PreferenceProvider
import com.example.assigntask.databinding.ActivityBaseBinding
import com.example.assigntask.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var pref: PreferenceProvider
    lateinit var rootRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        // Root Ref
        rootRef= FirebaseDatabase.getInstance().reference
    }

}