package com.example.hiltdemo.data

class UserRepositoryImpl(private val session: Long) : UserRepository {

    override fun getSession() = session
}