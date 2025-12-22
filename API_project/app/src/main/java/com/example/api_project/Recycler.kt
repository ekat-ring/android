package com.example.api_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class MyAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolderFact(view : View) : RecyclerView.ViewHolder(view) {
        val fact : TextView = itemView.findViewById(R.id.text)

        fun update(item : FactResponse){
            fact.text = item.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row, parent, false)
        return ViewHolderFact(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolderFact).update(History[position])
    }

    override fun getItemCount(): Int {
        return History.size
    }

}