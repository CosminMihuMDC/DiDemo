package com.example.hiltdemo.di

import com.example.hiltdemo.data.UserRepository
import com.example.hiltdemo.data.UserRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val USER_SCOPE_ID = "userScope_id"

val userModule = module {

    scope(named("userScope")) {
        scoped<UserRepository> { (session: Long) -> UserRepositoryImpl(session) }
    }
}