package com.example.assignment2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var toastButton:Button
    lateinit var nextButton:Button
    lateinit var editText:EditText
    lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        intent = Intent(this, SubActivity::class.java)
        intent.putExtra("from1",editText.text.toString())

        toastButton.setOnClickListener(this)
        nextButton.setOnClickListener(this)
    }
    fun init(){
        toastButton=findViewById(R.id.toast_btn)
        nextButton=findViewById(R.id.next_btn)
        editText=findViewById(R.id.edit)
        textView=findViewById(R.id.text_1)

    }

    override fun onClick(v: View?) {
        var id =v?.id
        when(id){
            R.id.toast_btn -> {
                var toast :Toast = Toast.makeText(this, editText.text, Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0)
                toast.show()
            }
            R.id.next_btn ->{
                startActivityForResult(intent,99)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK){
            textView.text=data?.getStringExtra("return")
        }

    }
}