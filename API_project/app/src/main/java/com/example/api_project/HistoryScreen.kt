package com.example.api_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class HistoryFragment : Fragment(R.layout.fragment_second){
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
        val backbutton:Button = view.findViewById<Button>(R.id.button_back)
        backbutton.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
    companion object {
        fun newInstance() =
            HistoryFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}

