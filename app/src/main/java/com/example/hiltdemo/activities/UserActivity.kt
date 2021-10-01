package com.example.hiltdemo.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import com.example.hiltdemo.data.SingletonRepository
import com.example.hiltdemo.data.UserRepository
import com.example.hiltdemo.di.USER_SCOPE_ID
import com.example.hiltdemo.ui.theme.HiltDemoTheme
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class UserActivity : ComponentActivity() {

    private val userScope = getKoin().getScope(USER_SCOPE_ID)

    private val userRepository: UserRepository
            by userScope.inject(parameters = { parametersOf(1234L) })

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
