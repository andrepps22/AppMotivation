package com.example.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.R
import com.example.motivation.data.SharedPreferences
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.utils.AppConsts

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        sharedPreferences = SharedPreferences(this)

        setContentView(binding.main)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        verificaNome()
        setListenes()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_save){
                handleSave()

        }
    }

    private fun verificaNome(){
        if (sharedPreferences.getPreferences(AppConsts.KEY.NOME_KEY).isNotEmpty()){
            val intent = Intent(this, HomeActivity::class.java)

            startActivity(intent)
            finish()
        }


    }

    private fun handleSave(){
        val nome = binding.textviewYourName.text.toString()

        if (nome.isNotEmpty()) {

            sharedPreferences.savePreferences(AppConsts.KEY.NOME_KEY, nome)


            val intent = Intent(this, HomeActivity::class.java)

            startActivity(intent)
            finish()

        } else {
            Toast.makeText(this, AppConsts.NOTIFICATION.NAME_EMPTY, Toast.LENGTH_LONG).show()
        }
    }

    private fun setListenes(){
        binding.btnSave.setOnClickListener(this)
    }
}