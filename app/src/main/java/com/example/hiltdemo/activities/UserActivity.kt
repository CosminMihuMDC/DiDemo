package com.example.hiltdemo.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import com.example.hiltdemo.data.SingletonRepository
import com.example.hiltdemo.data.UserRepository
import com.example.hiltdemo.ui.theme.HiltDemoTheme
import org.koin.android.ext.android.inject

class UserActivity : ComponentActivity() {

    private val userRepository: UserRepository by inject()

    private val singletonRepository: SingletonRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(
            "hilt-demo",
            "user activity singleton repository hash: ${singletonRepository.hashCode()}"
        )

        Log.d("hilt-demo", "user activity user repository hash: ${userRepository.hashCode()}")

        setContent {
            HiltDemoTheme {
                Column {
                    Text("user session = ${userRepository.getSession()}")
                }
            }
        }
    }
}
