package com.shehata.movies_kmp.data.local

import app.cash.sqldelight.db.SqlDriver
import com.shehata.movies_kmp.AppDatabase

expect class DriverFactory {
    fun create(): SqlDriver
}

fun getAppDatabase(driverFactory: DriverFactory): AppDatabase {
    return AppDatabase(driverFactory.create())
}