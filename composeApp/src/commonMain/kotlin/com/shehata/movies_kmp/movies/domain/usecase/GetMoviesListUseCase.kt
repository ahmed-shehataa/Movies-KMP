package com.shehata.movies_kmp.movies.domain.usecase

import com.shehata.movies_kmp.movies.domain.model.MovieDomainModel
import com.shehata.movies_kmp.movies.domain.repository.MoviesRepository

class GetMoviesListUseCase (
    private val repository: MoviesRepository
) {

    suspend fun execute(): List<MovieDomainModel> {
        return repository.getMovies()
    }
}