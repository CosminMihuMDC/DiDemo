package com.example.hiltdemo.di

import android.util.Log
import com.example.hiltdemo.data.SingletonRepository
import com.example.hiltdemo.data.UserRepository
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.internal.GeneratedComponentManager
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class UserScope

@DefineComponent(parent = SingletonComponent::class)
@UserScope
interface UserComponent

@DefineComponent.Builder
interface UserComponentBuilder {

    // Create new user scope with session.
    fun setSession(@BindsInstance session: Long): UserComponentBuilder

    fun build(): UserComponent
}

@EntryPoint
@InstallIn(UserComponent::class)
interface UserComponentEntryPoint {

    // get from UserModule.
    fun getUserRepository(): UserRepository

    // get from parent singleton component.
    fun getSingletonRepository(): SingletonRepository
}

@Singleton
class UserComponentManager @Inject constructor(
    private val userComponentBuilder: UserComponentBuilder
) : GeneratedComponentManager<UserComponent> {

    private var userComponent: UserComponent? = null

    fun start(session: Long) {
        if (userComponent == null) {
            userComponent = userComponentBuilder.setSession(session).build()
            Log.d("hilt-demo", "create userComponent hash: ${userComponent.hashCode()}")
        }
    }

    fun stop() {
        if (userComponent != null) {
            Log.d("hilt-demo", "destroy userComponent hash: ${userComponent.hashCode()}")
            userComponent = null
        }
    }

    override fun generatedComponent() = userComponent

}
