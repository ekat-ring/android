package com.example.project30_09

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

/*class User (val login: String, val password: String){
    fun check_input (l_input: String, p_input: String): Int {

            return (if (l_input == login and p_input == password) 1 else 0)
    }
}*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextbutton:Button = findViewById<Button>(R.id.button_first)
        nextbutton.setOnClickListener{
            val context: Context = this@MainActivity
            val intent = Intent(context, SecondActivity::class.java)
            context.startActivity(intent)
        }

    }
}