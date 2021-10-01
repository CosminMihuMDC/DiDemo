package com.example.hiltdemo.di

import com.example.hiltdemo.data.UserRepository
import com.example.hiltdemo.data.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(UserComponent::class)
class UserModule {

    @Provides
    @UserScope // return same instance in user scope.
    fun provideUserRepository(userId: Long): UserRepository = UserRepositoryImpl(userId)

}