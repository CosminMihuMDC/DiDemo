package com.example.hiltdemo.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.hiltdemo.data.MainRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Activity2 : ComponentActivity() {

    @Inject
    lateinit var repository: MainRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("hilt-demo", "activity 2 hash: ${this.hashCode()}")
        Log.d("hilt-demo", "activity 2 repository hash: ${repository.hashCode()}")
    }
}
