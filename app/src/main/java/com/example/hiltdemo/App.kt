package com.example.hiltdemo

import android.app.Application
import android.util.Log
import com.example.hiltdemo.data.MainRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var repository: MainRepository

    override fun onCreate() {
        super.onCreate()

        Log.d("hilt-demo", "App hash: ${this.hashCode()}")
        Log.d("hilt-demo", "App repository hash: ${repository.hashCode()}")
    }
}