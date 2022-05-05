package com.example.posts.data.posts.cloud

import javax.inject.Inject

interface PostsCloudDataSource {
    suspend fun fetchPosts(): List<PostCloud>

    class Base @Inject constructor(
        private val postsService: PostsService
    ) : PostsCloudDataSource {
        override suspend fun fetchPosts(): List<PostCloud> {
            return postsService.fetchPosts()
        }
    }
}