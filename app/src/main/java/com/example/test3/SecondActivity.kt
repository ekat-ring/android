package com.example.test3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class SecondActivity :  AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.button_second).setOnClickListener{
            //val context: Context = this@SecondActivity
            //val intent = Intent(context, MainActivity::class.java)
            //val flag = intent.getIntExtra("switchflag", -1).toString()
            //context.startActivity(intent)
            finish()
        }
    }
}