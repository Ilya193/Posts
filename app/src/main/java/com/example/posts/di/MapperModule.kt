package com.example.posts.di

import com.example.posts.core.ResourceProvider
import com.example.posts.data.posts.PostData
import com.example.posts.data.posts.PostDataToDomainMapper
import com.example.posts.data.posts.PostsDataToDomainMapper
import com.example.posts.data.posts.ToPostMapper
import com.example.posts.data.posts.cache.PostDataToDbMapper
import com.example.posts.data.posts.cache.PostDb
import com.example.posts.data.posts.cache.PostsCacheMapper
import com.example.posts.data.posts.cloud.PostsCloudMapper
import com.example.posts.domain.posts.*
import com.example.posts.presentation.posts.BasePostDomainToUiMapper
import com.example.posts.presentation.posts.BasePostsDomainToUiMapper
import com.example.posts.presentation.posts.PostUi
import com.example.posts.presentation.posts.PostsUi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MapperModule {

    @Provides
    fun providePostDataToDbMapper(): PostDataToDbMapper<PostDb> =
        PostDataToDbMapper.Base()

    @Provides
    fun provideToPostMapper(): ToPostMapper<PostData> =
        ToPostMapper.Base()

    @Provides
    fun providePostsCloudMapper(toPostMapper: ToPostMapper<PostData>): PostsCloudMapper =
        PostsCloudMapper.Base(toPostMapper)

    @Provides
    fun providePostsCacheMapper(toPostMapper: ToPostMapper<PostData>): PostsCacheMapper =
        PostsCacheMapper.Base(toPostMapper)

    @Provides
    fun providePostDataToDomainMapper(): PostDataToDomainMapper<PostDomain> =
        BasePostDataToDomainMapper()

    @Provides
    fun providePostsDataToDomainMapper(
        postDataToDomainMapper: PostDataToDomainMapper<PostDomain>
    ): PostsDataToDomainMapper<PostsDomain> =
        BasePostsDataToDomainMapper(postDataToDomainMapper)

    @Provides
    fun providePostDomainToUiMapper(): PostDomainToUiMapper<PostUi> =
        BasePostDomainToUiMapper()

    @Provides
    fun providePostsDomainToUiMapper(
        postDomainToUiMapper: PostDomainToUiMapper<PostUi>,
        resourceProvider: ResourceProvider
    ): PostsDomainToUiMapper<PostsUi> =
        BasePostsDomainToUiMapper(postDomainToUiMapper, resourceProvider)
}