package com.example.posts.di

import android.content.Context
import com.example.posts.core.Communication
import com.example.posts.core.ResourceProvider
import com.example.posts.presentation.posts.PostUi
import com.example.posts.presentation.posts.PostsCommunication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {

    @Provides
    fun provideResourceProvider(@ApplicationContext context: Context): ResourceProvider =
        ResourceProvider.Base(context)

    @Provides
    fun providePostsCommunication(): PostsCommunication =
        PostsCommunication.Base()
}