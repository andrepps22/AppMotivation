package com.example.motivation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.R
import com.example.motivation.data.PhraseRepository
import com.example.motivation.data.SharedPreferences
import com.example.motivation.databinding.ActivityHomeBinding
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.utils.AppConsts

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var phrase = PhraseRepository()
    private var filter = AppConsts.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        sharedPreferences = SharedPreferences(this)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getPhrase(filter)
        getInformations()
        setListenes()
    }


    override fun onClick(v: View) {

        val filtes = listOf(
            R.id.imageview_all,
            R.id.imageview_happy,
            R.id.imageview_sunny
        )

        if (v.id == R.id.btn_new_phrase) {
            getPhrase(filter)
        } else if (v.id in filtes) {
            phraseFilters(v.id)
        }
    }

    private fun setListenes() {
        binding.btnNewPhrase.setOnClickListener(this)
        binding.imageviewAll.setOnClickListener(this)
        binding.imageviewHappy.setOnClickListener(this)
        binding.imageviewSunny.setOnClickListener(this)

    }

    private fun phraseFilters(id: Int) {
        binding.imageviewHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageviewAll.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageviewSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))
        when (id) {
            R.id.imageview_all -> {
                filter = AppConsts.FILTER.ALL
                binding.imageviewAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }

            R.id.imageview_happy -> {
                filter = AppConsts.FILTER.HAPPY
                binding.imageviewHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }

            R.id.imageview_sunny -> {
                filter = AppConsts.FILTER.SUNNY
                binding.imageviewSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
        }
    }

    private fun getInformations() {
        val nome = sharedPreferences.getPreferences(AppConsts.KEY.NOME_KEY)
        binding.textviewGreet.text = "Olá, $nome"
    }

    private fun getPhrase(filter: Int) {
        binding.textviewFrasemotivacional.text = phrase.getPhrase(filter)
    }

}