package com.shehata.movies_kmp.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.shehata.movies_kmp.AppDatabase
import com.shehata.movies_kmp.data.local.SQLConstants.DATABASE_NAME

actual class DriverFactory(
    private val context: Context,
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(
            AppDatabase.Schema,
            context,
            DATABASE_NAME
        )
    }
}