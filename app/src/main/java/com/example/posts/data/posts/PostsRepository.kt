package com.example.posts.data.posts

import com.example.posts.core.Repository
import com.example.posts.data.posts.cache.PostDb
import com.example.posts.data.posts.cache.PostsCacheDataSource
import com.example.posts.data.posts.cache.PostsCacheMapper
import com.example.posts.data.posts.cloud.PostCloud
import com.example.posts.data.posts.cloud.PostsCloudDataSource
import com.example.posts.data.posts.cloud.PostsCloudMapper
import javax.inject.Inject

interface PostsRepository : Repository<PostsData> {

    class Base @Inject constructor(
        private val cloudDataSource: PostsCloudDataSource,
        private val cacheDataSource: PostsCacheDataSource<PostData>,
        postsCloudMapper: PostsCloudMapper,
        postsCacheMapper: PostsCacheMapper
    ) : Repository.Base<PostDb, PostCloud, PostData, PostsData>(
        cacheDataSource,
        postsCloudMapper,
        postsCacheMapper
    ), PostsRepository {
        override suspend fun fetchCloudData(): List<PostCloud> {
            return cloudDataSource.fetchPosts()
        }

        override fun getCachedDataList(): List<PostDb> {
            return cacheDataSource.read()
        }

        override fun returnSuccess(list: List<PostData>): PostsData {
            return PostsData.Success(list)
        }

        override fun returnFail(e: Exception): PostsData {
            return PostsData.Fail(e)
        }
    }

}