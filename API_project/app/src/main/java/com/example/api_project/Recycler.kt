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
import kotlinx.serialization.json.JsonElement
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.internal.readJson
//import com.google.gson.Gson

/*
@Serializable(with = JsonArraySerializer::class)
class JsonArray(content: List<JsonElement>) : JsonElement, List<JsonElement>

public fun <T> decodeFromJsonElement(deserializer: DeserializationStrategy<T>, element: JsonElement): T {
    return readJson(this, element, deserializer)
}
*/


class MyAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: List<RecyclerData> = emptyList()

    suspend fun network_call(){

//        list = Json.decodeFromString<RecyclerData>(getData())

    }


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