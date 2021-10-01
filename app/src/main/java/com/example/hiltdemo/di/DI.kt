package com.example.hiltdemo.di

import com.example.hiltdemo.data.MainRepository
import com.example.hiltdemo.data.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideMainRepository(): MainRepository = MainRepositoryImpl()
}