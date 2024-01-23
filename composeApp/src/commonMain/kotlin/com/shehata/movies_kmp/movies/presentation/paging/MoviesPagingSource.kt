package com.shehata.movies_kmp.movies.presentation.paging

import com.shehata.movies_kmp.base.pagination.ComposePagingSource
import com.shehata.movies_kmp.movies.domain.usecase.GetMoviesListUseCase
import com.shehata.movies_kmp.movies.presentation.mapper.toUIModel
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel

class MoviesPagingSource(
    private val moviesListUseCase: GetMoviesListUseCase,
) : ComposePagingSource<MovieUIModel>() {


    override suspend fun loadPage(page: Int, perPage: Int): List<MovieUIModel> {
        return moviesListUseCase.execute(page, perPage).map { it.toUIModel() }
    }


}