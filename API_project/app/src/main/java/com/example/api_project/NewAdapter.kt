package com.example.api_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(
    private val characters: List<CharacterItem>,
    private val onItemClick: (CharacterItem) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
        holder.itemView.setOnClickListener {
            onItemClick(character)
        }
    }

    override fun getItemCount(): Int = characters.size

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {        private val characterName: TextView = itemView.findViewById(R.id.characterName)
        private val characterStatus: TextView = itemView.findViewById(R.id.characterStatus)
        private val characterSpecies: TextView = itemView.findViewById(R.id.characterSpecies)
        private val characterLocation: TextView = itemView.findViewById(R.id.characterLocation)
        private val episodesCount: TextView = itemView.findViewById(R.id.episodesCount)

        fun bind(character: CharacterItem) {
            characterName.text = character.name
            characterStatus.text = "Status: ${character.status}"
            characterSpecies.text = "Species: ${character.species}"
            characterLocation.text = "Location: ${character.location}"
            episodesCount.text = "Episodes: ${character.episodesCount}"

        }
    }
}