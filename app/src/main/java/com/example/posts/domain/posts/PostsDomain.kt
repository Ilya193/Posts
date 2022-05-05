package com.example.posts.domain.posts

import com.example.posts.core.ErrorType

sealed class PostsDomain {
    abstract fun <T> map(mapper: PostsDomainToUiMapper<T>): T

    data class Success(private val posts: List<PostDomain>) : PostsDomain() {
        override fun <T> map(mapper: PostsDomainToUiMapper<T>): T {
            return mapper.map(posts)
        }
    }

    data class Fail(private val errorType: ErrorType) : PostsDomain() {
        override fun <T> map(mapper: PostsDomainToUiMapper<T>): T {
            return mapper.map(errorType)
        }
    }
}