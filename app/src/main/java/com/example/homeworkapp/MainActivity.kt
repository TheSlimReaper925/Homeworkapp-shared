package com.example.homeworkapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val PRIVATE_MODE = 0
    private val PREF_NAME = "NOTE_PREFS"
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = getSharedPreferences(PREF_NAME, PRIVATE_MODE)

        val inpref = sharedPref.getString("NOTE", "")

        var toastText = inpref

        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show()

        showBtn.setOnClickListener {
            Toast.makeText(this, toastText, Toast.LENGTH_LONG).show()
        }

        saveBtn.setOnClickListener {

            toastText = inputText.text.toString()

            sharedPref.edit().putString("NOTE", toastText).apply()

        }
    }
}
