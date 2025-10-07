package com.example.newosnewproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class User (val login: String, val password: String){
    fun check_input (l_input: String, p_input: String): Int {

            return (if (l_input == login && p_input == password) 1 else 0)
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usr = User("katey", "1234")

        val emailfield: EditText = findViewById<EditText>(R.id.email)
        val pswdfield: EditText = findViewById<EditText>(R.id.password)



        val nextbutton:Button = findViewById<Button>(R.id.button_first)
        nextbutton.setOnClickListener{
            val l_input: String = emailfield.getText().toString()
            val p_input: String = pswdfield.getText().toString()
            val verify: Int = usr.check_input(l_input, p_input)
            val context: Context = this@MainActivity
            if (verify != 0){
                val intent = Intent(context, SecondActivity::class.java)
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "Login Failed!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}