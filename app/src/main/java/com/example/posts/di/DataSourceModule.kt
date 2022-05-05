package com.example.posts.di

import com.example.posts.core.RealmProvider
import com.example.posts.data.posts.PostData
import com.example.posts.data.posts.cache.PostDataToDbMapper
import com.example.posts.data.posts.cache.PostDb
import com.example.posts.data.posts.cache.PostsCacheDataSource
import com.example.posts.data.posts.cloud.PostsCloudDataSource
import com.example.posts.data.posts.cloud.PostsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DataSourceModule {

    @Provides
    fun provideCloudDataSource(postsService: PostsService): PostsCloudDataSource =
        PostsCloudDataSource.Base(postsService)

    @Provides
    fun provideCacheDataSource(
        realmProvider: RealmProvider,
        postDataToDbMapper: PostDataToDbMapper<PostDb>
    ): PostsCacheDataSource<PostData> =
        PostsCacheDataSource.Base(realmProvider, postDataToDbMapper)


}