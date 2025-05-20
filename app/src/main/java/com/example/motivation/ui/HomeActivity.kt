package com.example.motivation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.R
import com.example.motivation.data.SharedPreferences
import com.example.motivation.databinding.ActivityHomeBinding
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.utils.AppConsts

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        sharedPreferences = SharedPreferences(this)

        setContentView(binding.main)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getInformations()
    }

    private fun getInformations(){
        val nome = sharedPreferences.getPreferences(AppConsts.KEY.NOME_KEY)
        binding.textviewGreet.text = "Olá, $nome"
    }
}