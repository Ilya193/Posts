package com.example.posts.domain.posts

import com.example.posts.data.posts.PostsDataToDomainMapper
import com.example.posts.data.posts.PostsRepository
import javax.inject.Inject

interface PostsInteractor {

    suspend fun fetchPosts(): PostsDomain

    class Base @Inject constructor(
        private val postsRepository: PostsRepository,
        private val mapper: PostsDataToDomainMapper<PostsDomain>
    ) : PostsInteractor {
        override suspend fun fetchPosts(): PostsDomain {
            return postsRepository.fetchData().map(mapper)
        }
    }
}