package com.ttlabz.pombo

import android.app.Application
import com.ttlabz.pombo.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class PomboApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@PomboApplication)
            androidLogger()
        }
    }

}