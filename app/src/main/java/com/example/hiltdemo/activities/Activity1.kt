package com.example.hiltdemo.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.hiltdemo.data.ActivityRepository
import com.example.hiltdemo.data.SingletonRepository
import org.koin.android.ext.android.inject

class Activity1 : ComponentActivity() {

    private val singletonRepository: SingletonRepository by inject()

    private val activityRepository: ActivityRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("hilt-demo", "-------")

        Log.d("hilt-demo", "activity 1 hash: ${this.hashCode()}")
        Log.d("hilt-demo", "activity 1 singleton repository hash: ${singletonRepository.hashCode()}")
        Log.d("hilt-demo", "activity 1 activity repository hash: ${activityRepository.hashCode()}")
    }
}
