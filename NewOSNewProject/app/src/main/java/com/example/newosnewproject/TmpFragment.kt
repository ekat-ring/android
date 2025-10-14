package com.example.newosnewproject


import android.content.Context
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


class User (val login: String, val password: String){
    fun check_input (l_input: String, p_input: String): Int {

        return (if (l_input == login && p_input == password) 1 else 0)
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, FirstFragment.newInstance("foo"))
        }
    }
}

class FirstFragment : Fragment(R.layout.fragment_first){
  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?,): View {
      return inflater.inflate(R.layout.fragment_first, container, false)
  }

  override fun onViewCreated(
      view: View,
      savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      val usr = User("katey", "1234")

      val emailfield: EditText = view.findViewById<EditText>(R.id.email)
      val pswdfield: EditText = view.findViewById<EditText>(R.id.password)



      val nextbutton:Button = view.findViewById<Button>(R.id.button_first)
      nextbutton.setOnClickListener{
          val l_input: String = emailfield.getText().toString()
          val p_input: String = pswdfield.getText().toString()
          val verify: Int = usr.check_input(l_input, p_input)


          if (verify != 0){
              //TODO
          } else {
              Toast.makeText(context, "Login Failed!", Toast.LENGTH_SHORT).show()
          }
      }
  }
  companion object {

      fun newInstance (name:String): FirstFragment = FirstFragment().apply {  }
  }

}

class SecondFragment : Fragment(){
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

}
