package com.example.posts.presentation.posts

sealed class PostsUi {
    abstract fun map(mapper: PostsCommunication)

    data class Base(private val posts: List<PostUi>) : PostsUi() {
        override fun map(mapper: PostsCommunication) {
            mapper.map(posts)
        }
    }
}