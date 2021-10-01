package com.example.hiltdemo.di

import com.example.hiltdemo.data.ActivityRepository
import com.example.hiltdemo.data.ActivityRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object ActivityDataModule {

    @Provides
    @ActivityScoped
    fun provideActivityRepository(): ActivityRepository = ActivityRepositoryImpl()
}