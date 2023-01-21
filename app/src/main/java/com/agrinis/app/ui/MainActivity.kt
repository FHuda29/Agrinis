package com.agrinis.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agrinis.app.R
import com.agrinis.app.databinding.ActivityMainBinding
import com.agrinis.app.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
    }
}