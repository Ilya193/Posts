package com.example.posts.data.posts

import com.example.posts.core.Abstract

sealed class PostsData : Abstract.DataObject {
    abstract fun <T> map(mapper: PostsDataToDomainMapper<T>): T

    data class Success(
        private val posts: List<PostData>
    ) : PostsData() {
        override fun <T> map(mapper: PostsDataToDomainMapper<T>): T {
            return mapper.map(posts)
        }
    }

    data class Fail(
        private val e: Exception
    ) : PostsData() {
        override fun <T> map(mapper: PostsDataToDomainMapper<T>): T {
            return mapper.map(e)
        }
    }
}
