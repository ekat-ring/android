package com.example.api_project

import androidx.annotation.DrawableRes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
class ResultResponse<T>(
    @SerialName("results") val results: List<T>,
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

