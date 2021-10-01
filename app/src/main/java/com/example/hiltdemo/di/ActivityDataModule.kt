package com.example.hiltdemo.di

import android.app.Activity
import com.example.hiltdemo.data.ActivityRepository
import com.example.hiltdemo.data.ActivityRepositoryImpl
import org.koin.dsl.module

val activityDataModule = module {

    scope<Activity> {
        scoped<ActivityRepository> { ActivityRepositoryImpl() }
    }
}