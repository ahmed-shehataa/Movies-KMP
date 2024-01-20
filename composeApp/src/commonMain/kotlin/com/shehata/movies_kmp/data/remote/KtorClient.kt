package com.shehata.movies_kmp.data.remote

import com.shehata.movies_kmp.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

typealias KeyValue = Pair<String, String>


fun getKtorClient(
    baseUrl: String = BuildKonfig.BASE_API_URL,
    parameters: List<KeyValue> = emptyList(),
    headers: List<KeyValue> = listOf(
        //@Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYTE1MjI0MzU1NjBmOThlN2Y2MmJmOGZhZDVkMGU1YyIsInN1YiI6IjYzNDZjMGMwZDU1YzNkMDA5MWI2MjU4MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.UGdd_xct65byKUEfXDYX2F3Z7Pw4aypXyRbSQputwH0")
        KeyValue(first = "Authorization", second = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYTE1MjI0MzU1NjBmOThlN2Y2MmJmOGZhZDVkMGU1YyIsInN1YiI6IjYzNDZjMGMwZDU1YzNkMDA5MWI2MjU4MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.UGdd_xct65byKUEfXDYX2F3Z7Pw4aypXyRbSQputwH0")
    ),
): HttpClient {
    return HttpClient(CIO) {

        // logging
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }

        // Default config
        install(DefaultRequest) {
            contentType(ContentType.Application.Json)
            url(baseUrl)
            url {
                parameters.forEach {
                    this.parameters.append(it.first, it.second)
                }
            }
            headers.forEach {
                header(it.first, it.second)
            }
        }

        // serialization type
        install(ContentNegotiation) {
            json(json = Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }

        // HttpTimeout
        install(HttpTimeout) {
            val time = 10000L
            requestTimeoutMillis = time
            socketTimeoutMillis = time
            connectTimeoutMillis = time
        }

    }

}