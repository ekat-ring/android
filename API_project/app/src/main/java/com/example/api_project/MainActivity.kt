package com.example.api_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Sample data
        //  val list: MutableList<RecyclerData> = getData();

        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set Adapter
        val adapter = MyAdapter()
        recyclerView.adapter = adapter

    }
}