package com.example.hiltdemo.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.hiltdemo.data.SingletonRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Activity2 : ComponentActivity() {

    @Inject
    lateinit var singletonRepository: SingletonRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("hilt-demo", "activity 2 hash: ${this.hashCode()}")
        Log.d("hilt-demo", "activity 2 singleton repository hash: ${singletonRepository.hashCode()}")
    }
}
