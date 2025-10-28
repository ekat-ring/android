package com.example.newosnewproject

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

import androidx.navigation.fragment.findNavController

class MainFragActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Set up the action bar for use with the NavController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}

class FirstFragment : Fragment(R.layout.fragment_first){

    private val login = "katey"
    private val pswrd = "1234"

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

        val emailfield: EditText = view.findViewById<EditText>(R.id.email)
        val pswdfield: EditText = view.findViewById<EditText>(R.id.password)
        val nextbutton:Button = view.findViewById<Button>(R.id.button_first)
        nextbutton.setOnClickListener {
            val l_input: String = emailfield.getText().toString()
            val p_input: String = pswdfield.getText().toString()
            onButtonPressed(l_input, p_input)
        }
    }

    fun onButtonPressed(l_input : String, p_input : String){
        if (l_input == login && p_input == pswrd) {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        } else {
        Toast.makeText(context, "Login Failed!", Toast.LENGTH_SHORT).show();
        }
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

class SecondFragment : Fragment(R.layout.fragment_second){
    override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?,): View {
      return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
    companion object {
        fun newInstance() =
            SecondFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
