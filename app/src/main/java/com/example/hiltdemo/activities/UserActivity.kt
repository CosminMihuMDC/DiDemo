package com.example.hiltdemo.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.hiltdemo.data.UserRepository
import com.example.hiltdemo.di.UserComponent
import com.example.hiltdemo.di.UserComponentBuilder
import com.example.hiltdemo.di.UserComponentEntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

val userId = 1234L


@AndroidEntryPoint
class UserActivity : ComponentActivity() {

    @Inject
    lateinit var userComponentBuilder: UserComponentBuilder

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val component: UserComponent = userComponentBuilder.setUserId(userId).build()
        val userId = EntryPoints.get(component, UserComponentEntryPoint::class.java).getUserId()

        Log.d("hilt-demo", "-------")

        Log.d("hilt-demo", "user activity 2 hash: ${this.hashCode()}")
        Log.d("hilt-demo", "user activity userRepository hash: ${userRepository.hashCode()}")

    }
}
