package com.example.api_project


import android.R.string
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
import kotlinx.serialization.json.Json


class FactService {
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

    suspend fun getFact(): FactResponse {

        //   try {
        val response = client.get {
            url("https://uselessfacts.jsph.pl/api/v2/facts/random?language=en")
            contentType(ContentType.Application.Json)
        }
            .body<FactResponse>()
        return response
        // } catch (e: Exception) {
        //      return emptyList()
        //   }
    }
}

class TranslationService {
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

    suspend fun getTranslation(fact: String) : TranslateResponse {

        //   try {
        var response = client.get {
            url("https://api.mymemory.translated.net/get?q=$fact&langpair=en|ru")
            contentType(ContentType.Application.Json)
        }.body<TranslateResponse>()
        return response
        // } catch (e: Exception) {
        //      return emptyList()
        //   }
    }
}