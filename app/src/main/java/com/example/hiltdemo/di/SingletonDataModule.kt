package com.example.hiltdemo.di

import com.example.hiltdemo.data.SingletonRepository
import com.example.hiltdemo.data.SingletonRepositoryImpl
import org.koin.dsl.module

val singletonDataModule = module {

    // single instance of HelloRepository
    single<SingletonRepository> { SingletonRepositoryImpl() }
}