package com.example.api_project


import android.icu.lang.UCharacter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivityWrong : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CharacterAdapter// MyAdapter
    private val service = RickAndMortyService()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Sample data
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        loadThings()
    }

    private fun loadThings() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val characters = service.getData_ver()
                val characterItems = characters.map { CharacterItem.fromCharacter(it) }

                withContext(Dispatchers.Main) {
                    adapter = CharacterAdapter(characterItems) { character ->
                        showCharacterDetails(character)
                    }
                    recyclerView.adapter = adapter
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@MainActivityWrong,
                        "Error loading characters: ${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
    private fun showCharacterDetails(character: CharacterItem) {
        Toast.makeText(
            this,
            "Selected: ${character.name}\nStatus: ${character.status}",
            Toast.LENGTH_SHORT
        ).show()
    }

}
