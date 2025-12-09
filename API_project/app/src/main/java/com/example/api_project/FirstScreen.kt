package com.example.api_project

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController


class FirstFragment : Fragment(R.layout.fragment_first){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextbutton:Button = view.findViewById<Button>(R.id.button_get)
        nextbutton.setOnClickListener {
            onButtonPressed()
        }
    }

    fun onButtonPressed(){
       // try {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        //}
        //catch:
          //  Toast.makeText(context, "Login Failed!", Toast.LENGTH_SHORT).show()

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    companion object {
        fun newInstance() =
            FirstFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}

/*
class FirstScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val viewProductBtn= findViewById<Button>(R.id.viewProduct)

        viewProductBtn.setOnClickListener {
            val intent = Intent(this, SecondScreen::class.java)
            startActivity(intent)
        }

    }
}



*/