package com.example.hiltdemo.di

import com.example.hiltdemo.data.SingletonRepository
import com.example.hiltdemo.data.SingletonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonDataModule {

    @Provides
    @Singleton
    fun provideSingletonRepository(): SingletonRepository = SingletonRepositoryImpl()
}