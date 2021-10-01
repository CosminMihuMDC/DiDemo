package com.example.hiltdemo.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.platform.LocalContext
import com.example.hiltdemo.di.USER_SCOPE_ID
import com.example.hiltdemo.ui.theme.HiltDemoTheme
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.named

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HiltDemoTheme {
                val context = LocalContext.current

                Column {
                    Button(onClick = {
                        getKoin().createScope(USER_SCOPE_ID, named("userScope"))
                        Log.d("hilt-demo", "create scope id: $USER_SCOPE_ID")
                    }) {
                        Text("Login")
                    }

                    Button(onClick = {
                        Log.d("hilt-demo", "delete scope id: $USER_SCOPE_ID")
                        getKoin().deleteScope(USER_SCOPE_ID)
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
