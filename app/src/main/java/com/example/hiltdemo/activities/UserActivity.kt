package com.example.hiltdemo.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import com.example.hiltdemo.data.SingletonRepository
import com.example.hiltdemo.di.UserComponentEntryPoint
import com.example.hiltdemo.di.UserComponentManager
import com.example.hiltdemo.ui.theme.HiltDemoTheme
import dagger.hilt.EntryPoints
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserActivity : ComponentActivity() {

    @Inject
    lateinit var userComponentManager: UserComponentManager

    @Inject
    lateinit var singletonRepository: SingletonRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(
            "hilt-demo",
            "user activity singleton repository hash: ${singletonRepository.hashCode()}"
        )

        val userRepository =
            EntryPoints.get(userComponentManager, UserComponentEntryPoint::class.java)
                .getUserRepository()

        Log.d("di-demo", "user activity user repository hash: ${userRepository.hashCode()}")

        setContent {
            HiltDemoTheme {
                Column {
                    Text("user session = ${userRepository.getSession()}")
                }
            }
        }

        val userScopeSingletonRepository =
            EntryPoints.get(userComponentManager, UserComponentEntryPoint::class.java)
                .getSingletonRepository()

        Log.d(
            "hilt-demo",
            "user activity user scope singleton repository hash: ${userScopeSingletonRepository.hashCode()}"
        )

    }
}
