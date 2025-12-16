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


class MyAdapter(var list: List<CharacterItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class ViewHolderTitle(view : View) : RecyclerView.ViewHolder(view) {
        val title : TextView = itemView.findViewById(R.id.text_row_title)

        fun update(item : RecyclerData.Title){
            title.text = item.text
        }
    }

    class ViewHolderItem(view : View) : RecyclerView.ViewHolder(view) {
        val subtitle : TextView = itemView.findViewById(R.id.text_row_subtitle)
        fun update(item : RecyclerData.Item){
            subtitle.text = item.subtitle
        }
    }


    class ViewHolderChar(view : View) : RecyclerView.ViewHolder(view) {
        val subtitle : TextView = itemView.findViewById(R.id.char_row)
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


            CHAR_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.character_item, parent, false)
                ViewHolderChar(view)
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
            is CharacterItem -> CHAR_TYPE
        }
    }

    companion object {

        private const val ITEM_TYPE = 0
        private const val TITLE_TYPE = 1
        private const val CHAR_TYPE = 2
    }



}