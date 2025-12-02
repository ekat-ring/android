package com.example.api_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


sealed class RecyclerData {
    data class Item(
        @param:DrawableRes val ImageViewRes: Int,
        val title: String,
        val subtitle: String
    ) : RecyclerData()

    data class Title (val text: String) : RecyclerData()
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Sample data
        val list: MutableList<RecyclerData> = ArrayList()



        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set Adapter
        val adapter = MyAdapter()
        recyclerView.adapter = adapter
    }

 /*   suspend fun network_call(){
        var items = getData()
        recyclerView.adapter = MyAdapter(items)
    }*/
}

class MyAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: List<RecyclerData> = emptyList()


    class ViewHolderTitle(view : View) : RecyclerView.ViewHolder(view) {
        val title : TextView = itemView.findViewById(R.id.title)

        fun update(item : RecyclerData.Title){
            title.text = item.text
        }
    }

    class ViewHolderItem(view : View) : RecyclerView.ViewHolder(view) {
        val subtitle : TextView = itemView.findViewById(R.id.subtitle)
        fun update(item : RecyclerData.Item){
            subtitle.text = item.subtitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.text_row_subtitle, parent, false)

                ViewHolderItem(view)
            }

            TITLE_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.text_row_title, parent, false)
                ViewHolderTitle(view)
            }
            else -> throw IllegalStateException ("unsupported type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(val item = list[position]){
            is RecyclerData.Item -> (holder as ViewHolderItem).update(item)
            is RecyclerData.Title -> (holder as ViewHolderTitle).update(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(list[position]){
            is RecyclerData.Item -> ITEM_TYPE
            is RecyclerData.Title -> TITLE_TYPE
        }
    }
    companion object {

        private const val ITEM_TYPE = 0
        private const val TITLE_TYPE = 1
    }



}