package com.example.hw1_month6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hw1_month6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK && it.data != null) {
                val getText = it.data?.getStringExtra("text_next")
                Log.w("ololo", "launcherMain: ${it.data?.getStringExtra("text_next")}")
                binding.etMain.setText(getText)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() {
        binding.btnMain.setOnClickListener {
            if (binding.etMain.text.isEmpty()) {
                Toast.makeText(this, "EditText не может быть пустым!!!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("text_main", binding.etMain.text.toString())
                launcher.launch(intent)
            }
        }
    }
}

