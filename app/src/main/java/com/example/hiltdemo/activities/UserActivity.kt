package com.example.hiltdemo.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userRepository = EntryPoints.get(
            userComponentManager.userComponent,
            UserComponentEntryPoint::class.java
        ).getUserRepository()

        setContent {
            HiltDemoTheme {
                Column {
                    Text("user session = ${userRepository.getSession()}")
                }
            }
        }
    }
}
