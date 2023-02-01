package com.example.magicidapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etID = findViewById<EditText>(R.id.etID)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tvResults = findViewById<TextView>(R.id.tvResults)

        tvResults.visibility = View.GONE

        btnSubmit.setOnClickListener {
            val idNumber: String = etID.text.toString().trim()
            val dob: String = idNumber.substring(0, 6)
            val gender = Integer.parseInt((idNumber[6].toString()))

            val sGender: String = if (gender < 5) {
                getString(R.string.female)
            } else {
                getString(R.string.male)
            }

            val nationality = Integer.parseInt((idNumber[10].toString()))

            val sNationality: String = if(nationality == 0) {
                getString(R.string.sacit)
            } else {
                getString(R.string.permanent)
            }

            val newtext = getString(R.string.dob) + dob+ "\n" + getString(R.string.gender) + sGender + "\n"+ getString(R.string.nationality) + sNationality

            tvResults.text = newtext
            tvResults.visibility = View.VISIBLE


        }
    }




}




