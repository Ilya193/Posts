package com.example.posts.data.posts

interface ToPostMapper<T> {
    fun map(userId: Int, id: Int, title: String, body: String): T

    class Base : ToPostMapper<PostData> {
        override fun map(userId: Int, id: Int, title: String, body: String): PostData {
            return PostData(userId, id, title, body)
        }
    }
}