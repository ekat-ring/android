package com.example.api_project


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



var History: List<FactResponse> = emptyList()

class FirstScreen : Fragment(R.layout.fragment_first){
    private val fact_service = FactService()
    private val translation_service = TranslationService()

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
        val getbutton:Button = view.findViewById<Button>(R.id.button_get)
        val viewbutton:Button = view.findViewById<Button>(R.id.button_view)
        getbutton.setOnClickListener {
            onButtonGetPressed(view)
        }
        viewbutton.setOnClickListener {
            onButtonViewPressed()
        }
    }

    fun onButtonViewPressed(){
       // try {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        //}
        //catch:
          //  Toast.makeText(context, "Login Failed!", Toast.LENGTH_SHORT).show()

    }

    fun onButtonGetPressed(view: View){
        NetworkCall(view)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun NetworkCall(view: View){
        var fact: FactResponse
        var tr_fact: TranslateResponse
        val textbox = view.findViewById<TextView>(R.id.fact_textbox)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                fact = fact_service.getFact()
                textbox.text = fact.text

                History += fact
                var prepared_fact = fact.text.replace(" ", "%20")
                tr_fact = translation_service.getTranslation(prepared_fact)
                textbox.text = tr_fact.responseData.translatedTtext

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Error loading facts: ${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                    textbox.text = e.message
                    print (e.message)
                }
            }
        }
    }
}