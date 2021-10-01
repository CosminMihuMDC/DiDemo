package com.example.hiltdemo.di

import com.example.hiltdemo.activities.Activity1
import com.example.hiltdemo.activities.Activity2
import com.example.hiltdemo.data.ActivityRepository
import com.example.hiltdemo.data.ActivityRepositoryImpl
import org.koin.dsl.module

val activityDataModule = module {

    scope<Activity1> {
        scoped<ActivityRepository> { ActivityRepositoryImpl() }
    }

    scope<Activity2> {
        scoped<ActivityRepository> { ActivityRepositoryImpl() }
    }
}