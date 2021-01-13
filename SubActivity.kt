package com.example.assignment2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SubActivity : AppCompatActivity() {
    lateinit var text2 : TextView
    lateinit var edit2 : EditText
    lateinit var returnButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        init()
        Log.d("@@@@@@@@@","${text2.text}")
        text2.text = intent.getStringExtra("from1")
        Log.d("############","${text2.text}")

        returnButton.setOnClickListener{
           val returnIntent = Intent()
            returnIntent.putExtra("return",edit2.text.toString())
            setResult(Activity.RESULT_OK, returnIntent)

            finish()
        }
    }
    fun init(){
        text2 = findViewById(R.id.text_2)
        edit2 = findViewById(R.id.edit_2)
        returnButton = findViewById(R.id.return_button)
    }


}