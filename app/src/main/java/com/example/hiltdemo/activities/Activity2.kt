package com.example.hiltdemo.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import com.example.hiltdemo.data.MainRepository
import com.example.hiltdemo.ui.theme.HiltDemoTheme
import javax.inject.Inject

class Activity2 : ComponentActivity() {

    @Inject
    lateinit var repository: MainRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HiltDemoTheme {
                Surface(color = MaterialTheme.colors.background) {

                    Text("activity 2 hash: ${this.hashCode()}")
                    Text("repository hash: ${repository.hashCode()}")

                }
            }
        }
    }
}
