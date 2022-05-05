package com.example.posts.di

import com.example.posts.data.posts.PostsDataToDomainMapper
import com.example.posts.data.posts.PostsRepository
import com.example.posts.domain.posts.PostsDomain
import com.example.posts.domain.posts.PostsInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class InteractorModule {

    @Provides
    fun providePostsInteractor(
        postsRepository: PostsRepository,
        postsDataToDomainMapper: PostsDataToDomainMapper<PostsDomain>
    ): PostsInteractor =
        PostsInteractor.Base(postsRepository, postsDataToDomainMapper)
}