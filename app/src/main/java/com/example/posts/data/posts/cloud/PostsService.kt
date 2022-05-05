package com.example.posts.data.posts.cloud

import retrofit2.http.GET

interface PostsService {
    @GET("posts")
    suspend fun fetchPosts(): List<PostCloud>
}