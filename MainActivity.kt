package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myName = "홍길동"
        var aaa = "바보" + "  "+"멍청이"
        var myAge:Int
        myAge = 27
        myAge = myAge+1


        Log.d("BasicSyntax", "myName = $myName, myAge = $myAge  $aaa")
    /*
        var btnSay : Button = findViewById(R.id.btnSay)
        var textSay : TextView = findViewById(R.id.textSay)
        btnSay.setOnClickListener{
            textSay.setText("Hello Kotlin!!!")
        }
      */
    }
}