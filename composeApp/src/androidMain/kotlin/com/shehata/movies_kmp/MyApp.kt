package com.shehata.movies_kmp

import android.app.Application
import com.russhwolf.settings.BuildConfig
import com.shehata.movies_kmp.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MyApp)
            modules(commonModule)
        }
    }
}