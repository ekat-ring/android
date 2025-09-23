package com.example.test3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button_first).setOnClickListener{
            val context: Context = this@MainActivity
            val intent = Intent(context, SecondActivity::class.java)
            //    .putExtra("switchflag", 5)
            context.startActivity(intent)
        }
    }
}

