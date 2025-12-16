package com.example.api_project

import androidx.annotation.DrawableRes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
class ResultResponse<T>(
    @SerialName("results") val results: List<T>,
)

@Serializable
@SerialName("item")
data class Character(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("status") val status: String,
    @SerialName("species") val species: String,
    @SerialName("type") val type: String,
    @SerialName("gender") val gender: String,
    @SerialName("origin") val origin: Origin,
    @SerialName("location") val location: Location,
    @SerialName("image") val image: String,
    @SerialName("episode") val episode: List<String>,
    @SerialName("url") val url: String,
    @SerialName("created") val created: String
)

@Serializable
data class Origin(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)

@Serializable
data class Location(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)

@Serializable
data class CharactersResponse(

    @SerialName("results") val results: List<Character>
)

@Serializable
class RickResponse(
    @SerialName ("id") val id: Int,
    @SerialName ("name") val name: String,
    @SerialName ("type") val type: String,
    @SerialName ("dimension") val dimension: String,
    @SerialName ("residents") val residents: List<String>,
    @SerialName ("url") val url: String,
    @SerialName ("created") val created: String,
)





@Serializable
sealed class RecyclerData {

    @Serializable
    @SerialName("item")
    data class Item(
        @param:DrawableRes val ImageViewRes: Int,
        val title: String,
        val subtitle: String
    ) : RecyclerData()


    @Serializable
    @SerialName("title")
    data class Title(val text: String) : RecyclerData()
}


//TODO
@Serializable
sealed class FactData {

    @Serializable
    @SerialName("item")
    data class Item(
        val title: String,
        val subtitle: String
    ) : FactData()


    @Serializable
    @SerialName("title")
    data class Title(val text: String) : FactData()
}

data class CharacterItem(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val imageUrl: String,
    val location: String,
    val episodesCount: Int
) {
    companion object {
        fun fromCharacter(character: Character): CharacterItem {
            return CharacterItem(
                id = character.id,
                name = character.name,
                status = character.status,
                species = character.species,
                imageUrl = character.image,
                location = character.location.name,
                episodesCount = character.episode.size
            )
        }
    }
}
