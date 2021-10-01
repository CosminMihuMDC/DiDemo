package com.example.hiltdemo.di

import com.example.hiltdemo.data.UserRepository
import com.example.hiltdemo.data.UserRepositoryImpl
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@DefineComponent(parent = SingletonComponent::class)
interface UserComponent

@DefineComponent.Builder
interface UserComponentBuilder {

    fun setUserId(@BindsInstance userId: Long): UserComponentBuilder

    fun build(): UserComponent
}

@EntryPoint
@InstallIn(UserComponent::class)
interface UserComponentEntryPoint {
    fun getUserId(): Long
}

@Module
@InstallIn(UserComponent::class)
class UserModule {

    @Provides
    fun provideUserRepository(userId: Long): UserRepository = UserRepositoryImpl(userId)

}