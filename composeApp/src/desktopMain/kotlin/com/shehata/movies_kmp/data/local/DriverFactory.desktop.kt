package com.shehata.movies_kmp.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.shehata.movies_kmp.AppDatabase
import com.shehata.movies_kmp.data.local.SQLConstants.DATABASE_NAME
import java.io.File

actual class DriverFactory {
    actual fun create(): SqlDriver {
        val driver = JdbcSqliteDriver("jdbc:sqlite:${DATABASE_NAME}")
        if (!File(DATABASE_NAME).exists())
        {
            AppDatabase.Schema.create(driver)
        }
        return driver
    }
}