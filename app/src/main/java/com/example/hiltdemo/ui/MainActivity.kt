package com.example.hiltdemo.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.hiltdemo.activities.Activity1
import com.example.hiltdemo.activities.Activity2
import com.example.hiltdemo.activities.LoginActivity
import com.example.hiltdemo.ui.theme.HiltDemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current

    Column {
        Button(onClick = {
            context.startActivity(Intent(context, Activity1::class.java))
        }) {
            Text("Activity 1")
        }


        Button(onClick = {
            context.startActivity(Intent(context, Activity2::class.java))
        }) {
            Text("Activity 2")
        }


        Button(onClick = {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }) {
            Text("Login Activity")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HiltDemoTheme {
        Greeting("Android")
    }
}