package com.shehata.movies_kmp.movies.data.ktor.service

import com.shehata.movies_kmp.data.remote.APIConstants
import com.shehata.movies_kmp.movies.data.ktor.response.MoviesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MoviesServiceImpl(
    private val client: HttpClient
) : MoviesService {
    override suspend fun getMovies(page: Int, pageSize: Int): MoviesResponse {
        return client.get(APIConstants.Path.POPULAR_MOVIES) {
            url {
                parameters.append(APIConstants.Parameters.PAGE, page.toString())
            }
        }.body()
    }
}