package com.example.hiltdemo

import android.app.Application
import android.util.Log
import com.example.hiltdemo.data.SingletonRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var singletonRepository: SingletonRepository

    override fun onCreate() {
        super.onCreate()

        Log.d("hilt-demo", "App hash: ${this.hashCode()}")
        Log.d("hilt-demo", "App singleton repository hash: ${singletonRepository.hashCode()}")
    }
}