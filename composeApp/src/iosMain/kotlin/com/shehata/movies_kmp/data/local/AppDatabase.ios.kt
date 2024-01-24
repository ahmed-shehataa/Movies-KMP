package com.shehata.movies_kmp.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.shehata.movies_kmp.AppDatabase
import com.shehata.movies_kmp.data.local.SQLConstants.DATABASE_NAME

actual class DriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, DATABASE_NAME)
    }
}