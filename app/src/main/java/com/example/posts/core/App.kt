package com.example.posts.core

import android.app.Application
import com.example.posts.data.posts.ToPostMapper
import com.example.posts.data.posts.cloud.PostsCloudDataSource
import com.example.posts.data.posts.cloud.PostsCloudMapper
import com.example.posts.data.posts.PostsRepository
import com.example.posts.data.posts.cache.PostDataToDbMapper
import com.example.posts.data.posts.cache.PostsCacheDataSource
import com.example.posts.data.posts.cache.PostsCacheMapper
import com.example.posts.data.posts.cloud.PostsService
import com.example.posts.domain.posts.BasePostDataToDomainMapper
import com.example.posts.domain.posts.BasePostsDataToDomainMapper
import com.example.posts.domain.posts.PostsInteractor
import com.example.posts.presentation.posts.BasePostDomainToUiMapper
import com.example.posts.presentation.posts.BasePostsDomainToUiMapper
import com.example.posts.presentation.posts.PostsCommunication
import com.example.posts.presentation.posts.PostsViewModel
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class App : Application()/* {
    lateinit var postsViewModel: PostsViewModel

    override fun onCreate() {
        super.onCreate()

        *//*val postsService = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostsService::class.java)

        val cloudDataSource = PostsCloudDataSource.Base(postsService)
        val realmProvider = RealmProvider.Base(this)
        val postDataToDbMapper = PostDataToDbMapper.Base()
        val cacheDataSource = PostsCacheDataSource.Base(realmProvider, postDataToDbMapper)
        val postMapper = ToPostMapper.Base()
        val postsCloudMapper = PostsCloudMapper.Base(postMapper)
        val postsCacheMapper = PostsCacheMapper.Base(postMapper)
        val postsRepository = PostsRepository.Base(cloudDataSource, cacheDataSource, postsCloudMapper, postsCacheMapper)
        val postsInteractor = PostsInteractor.Base(postsRepository, BasePostsDataToDomainMapper(BasePostDataToDomainMapper()))
        val mapper = BasePostsDomainToUiMapper(BasePostDomainToUiMapper(), ResourceProvider.Base(this))
        postsViewModel = PostsViewModel(postsInteractor, mapper, PostsCommunication.Base())*//*
    }
}*/