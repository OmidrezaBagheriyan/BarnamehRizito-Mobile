package com.omidrezabagheriyan.barnamehrizitomobile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.omidrezabagheriyan.barnamehrizitomobile.R
import com.omidrezabagheriyan.barnamehrizitomobile.databinding.ActivityMainBinding
import com.omidrezabagheriyan.barnamehrizitomobile.utils.viewbinding.viewBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}