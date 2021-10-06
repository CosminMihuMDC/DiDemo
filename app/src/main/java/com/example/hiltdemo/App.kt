package com.example.hiltdemo

import android.app.Application
import android.util.Log
import com.example.hiltdemo.data.SingletonRepository
import com.example.hiltdemo.di.activityDataModule
import com.example.hiltdemo.di.singletonDataModule
import com.example.hiltdemo.di.userModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : Application() {

    private val singletonRepository: SingletonRepository by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(
                singletonDataModule,
                activityDataModule,
                userModule
            )
        }


        Log.d("di-demo", "-------")

        Log.d("di-demo", "App hash: ${this.hashCode()}")
        Log.d("di-demo", "App singleton repository hash: ${singletonRepository.hashCode()}")
    }
}