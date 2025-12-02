package com.example.api_project


import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNames
import timber.log.Timber
import android.app.Service
import android.content.Intent
import android.os.IBinder


@Serializable
class ResultResponse<T>(
    @SerialName("results") val results: List<T>,
)

@Serializable
class LocationResponse(
    @SerialName ("id") val id: Int,
    @SerialName ("name") val name: String,
    @SerialName ("type") val type: String,
    @SerialName ("dimension") val dimension: String,
    @SerialName ("residents") val residents: List<String>,
    @SerialName ("url") val url: String,
    @SerialName ("created") val created: String,
)

val client = HttpClient(OkHttp.create()) {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                useAlternativeNames = true
                ignoreUnknownKeys = true
                encodeDefaults = false
            }
        )
    }


    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }

    defaultRequest {
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
    }
}

suspend fun getData() {
    val data = client.get {
        url("https://rickandmortyapi.com/api/episode")
        contentType(ContentType.Application.Json)
    }
       // .body<ResultResponse>()

    Timber.d("data: $data")
}


/*
fun init() {
    viewModelScope.launch {
        service.getSomeData()
    }
}

override fun onBind(intent: Intent?): IBinder? {
    TODO("Not yet implemented")
}
*/

/*
try:
        client.get {
            url("https://rickandmortyapi.com/api/location")
            contentType(ContentType.Application.Json)
        }

        }
*/