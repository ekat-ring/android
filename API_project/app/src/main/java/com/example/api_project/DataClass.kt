package com.example.api_project

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class FactResponse (
    @SerialName ("id") val id: String,
    @SerialName ("text") val text: String,
    @SerialName ("source") val source: String,
    @SerialName ("source_url") val source_url: String,
    @SerialName ("language") val language: String,
    @SerialName ("permalink") val permalink: String,

    )

@Serializable
class ResponseData(
    @SerialName ("match") val match: Float,
    @SerialName ("translatedText") val translatedTtext: String)

@Serializable
data class Matches (

    @SerialName("id") val id : Int,
    @SerialName("segment") val segment : String,
    @SerialName("translation") val translation : String,
    @SerialName("source") val source : String,
    @SerialName("target") val target : String,
    @SerialName("quality") val quality : Int,
    @SerialName("reference") val reference : String?,
    @SerialName("usage-count") val usage_count : Int,
    @SerialName("subject") val subject : String,
    @SerialName("created-by") val created_by : String,
    @SerialName("last-updated-by") val last_updated_by : String,
    @SerialName("create-date") val create_date : String,
    @SerialName("last-update-date") val last_update_date : String,
    @SerialName("match") val match : Float,
    @SerialName("penalty") val penalty : Int?,
)
@Serializable
class TranslateResponse (
    @SerialName("responseData") val responseData : ResponseData,
    @SerialName("quotaFinished") val quotaFinished : Boolean,
    @SerialName("mtLangSupported") val mtLangSupported : String?,
    @SerialName("responseDetails") val responseDetails : String,
    @SerialName("responseStatus") val responseStatus : Int,
    @SerialName("responderId") val responderId : String?,
    @SerialName("exception_code") val exception_code : String?,
    @SerialName("matches") val matches : List<Matches>
    )
