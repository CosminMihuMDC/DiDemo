package com.example.hiltdemo.di

import android.util.Log
import com.example.hiltdemo.data.UserRepository
import com.example.hiltdemo.data.UserRepositoryImpl
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class UserScope

@DefineComponent(parent = ActivityComponent::class)
@UserScope
interface UserComponent

@DefineComponent.Builder
interface UserComponentBuilder {

    fun session(@BindsInstance session: Long): UserComponentBuilder

    fun build(): UserComponent
}

@ActivityScoped
class UserComponentManager @Inject constructor(
    private val userComponentBuilder: UserComponentBuilder
) {

    private var userComponent: UserComponent? = null

    fun start(session: Long) {
        if (userComponent == null) {
            userComponent = userComponentBuilder.session(session).build()
            Log.d("hilt-demo", "create userComponent hash: ${userComponent.hashCode()}")
        }
    }

    fun stop() {
        if (userComponent != null) {
            Log.d("hilt-demo", "destroy userComponent hash: ${userComponent.hashCode()}")
            userComponent = null
        }
    }

}


@Module
@InstallIn(UserComponent::class)
class UserModule {

    @Provides
    @UserScope
    fun provideUserRepository(userId: Long): UserRepository = UserRepositoryImpl(userId)

}