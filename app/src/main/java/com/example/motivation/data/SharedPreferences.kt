package com.example.motivation.data

import android.content.Context

class SharedPreferences(context: Context) {
    private val shared = context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun savePreferences(key:String, value:String){
        shared.edit().putString(key, value).apply()
    }

    fun getPreferences(key: String):String{
        return shared.getString(key, "") ?: ""
    }

}