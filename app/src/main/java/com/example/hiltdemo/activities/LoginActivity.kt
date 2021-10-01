package com.example.hiltdemo.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.platform.LocalContext
import com.example.hiltdemo.di.UserComponentManager
import com.example.hiltdemo.ui.theme.HiltDemoTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    @Inject
    lateinit var userComponentManager: UserComponentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HiltDemoTheme {
                val context = LocalContext.current

                Column {
                    Button(onClick = {
                        userComponentManager.start(Random.nextLong())
                    }) {
                        Text("Login")
                    }

                    Button(onClick = {
                        userComponentManager.stop()
                    }) {
                        Text("Logout")
                    }


                    Button(onClick = {
                        context.startActivity(Intent(context, UserActivity::class.java))
                    }) {
                        Text("User Activity")
                    }
                }
            }
        }
    }
}
