package com.example.posts.data.posts

interface PostDataToDomainMapper<T> {
    fun map(userId: Int, id: Int, title: String, body: String): T
}