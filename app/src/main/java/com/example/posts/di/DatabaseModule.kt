package com.example.posts.di

import android.content.Context
import com.example.posts.core.RealmProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRealmProvider(@ApplicationContext context: Context): RealmProvider =
        RealmProvider.Base(context)
}