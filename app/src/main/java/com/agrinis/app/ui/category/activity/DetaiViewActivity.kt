package com.agrinis.app.ui.category.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agrinis.app.databinding.ActivityDetailBinding
import com.agrinis.app.util.viewBinding

class DetaiViewActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityDetailBinding::inflate)
    companion object {
        val EXTRA_URL = "extra.url"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}