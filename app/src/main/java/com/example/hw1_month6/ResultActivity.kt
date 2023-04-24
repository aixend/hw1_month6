package com.example.hw1_month6

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw1_month6.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() {
        binding.etNext.setText(intent.getStringExtra("text_main"))
        binding.btnNext.setOnClickListener {
            intent.putExtra("text_next", binding.etNext.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}