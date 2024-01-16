package com.shehata.movies_kmp.movies.presentation.model

enum class VoteRate {
    HIGH,
    MEDIUM,
    LOW,
    UNKNOWN;

    companion object {
        fun getRate(voteAverage: Double): VoteRate {
            return when {
                voteAverage >= 7.5 -> HIGH
                voteAverage in 6.0..7.49 -> MEDIUM
                voteAverage < 6.0 -> LOW
                else -> UNKNOWN
            }
        }
    }
}