package com.example.ceria.base

import android.app.Application
import com.example.ceria.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class BaseApp : Application() {

    companion object {
        private lateinit var instance: BaseApp
        fun getInstance(): BaseApp {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@BaseApp)
        }
    }
}