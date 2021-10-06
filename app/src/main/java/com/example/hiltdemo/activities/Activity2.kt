package com.example.hiltdemo.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.hiltdemo.data.ActivityRepository
import com.example.hiltdemo.data.SingletonRepository
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.core.scope.Scope

class Activity2 : ComponentActivity(), AndroidScopeComponent {

    override val scope: Scope by activityScope()

    private val singletonRepository: SingletonRepository by inject()

    private val activityRepository: ActivityRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("di-demo", "-------")

        Log.d("di-demo", "activity 2 hash: ${this.hashCode()}")
        Log.d("di-demo", "activity 2 singleton repository hash: ${singletonRepository.hashCode()}")
        Log.d("di-demo", "activity 2 activity repository hash: ${activityRepository.hashCode()}")
    }
}
