package com.example.posts.di

import com.example.posts.data.posts.PostData
import com.example.posts.data.posts.PostsRepository
import com.example.posts.data.posts.cache.PostsCacheDataSource
import com.example.posts.data.posts.cache.PostsCacheMapper
import com.example.posts.data.posts.cloud.PostsCloudDataSource
import com.example.posts.data.posts.cloud.PostsCloudMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun providePostsRepository(
        postsCloudDataSource: PostsCloudDataSource,
        postsCacheDataSource: PostsCacheDataSource<PostData>,
        postsCloudMapper: PostsCloudMapper,
        postsCacheMapper: PostsCacheMapper
    ): PostsRepository =
        PostsRepository.Base(
            postsCloudDataSource,
            postsCacheDataSource,
            postsCloudMapper,
            postsCacheMapper
        )
}