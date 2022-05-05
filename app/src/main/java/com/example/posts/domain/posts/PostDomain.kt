package com.example.posts.domain.posts

sealed class PostDomain {

    abstract fun <T> map(mapper: PostDomainToUiMapper<T>): T

    data class Base(
        private val userId: Int,
        private val id: Int,
        private val title: String,
        private val body: String
    ) : PostDomain() {
        override fun <T> map(mapper: PostDomainToUiMapper<T>): T {
            return mapper.map(userId, id, title, body)
        }
    }

}