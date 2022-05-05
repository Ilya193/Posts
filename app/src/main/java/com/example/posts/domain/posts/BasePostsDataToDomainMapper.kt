package com.example.posts.domain.posts

import com.example.posts.data.posts.PostData
import com.example.posts.data.posts.PostDataToDomainMapper
import com.example.posts.data.posts.PostsDataToDomainMapper
import javax.inject.Inject

class BasePostsDataToDomainMapper @Inject constructor(
    private val postMapper: PostDataToDomainMapper<PostDomain>
) : PostsDataToDomainMapper<PostsDomain>() {

    override fun map(data: List<PostData>): PostsDomain {
        val domainList = mutableListOf<PostDomain>()
        data.forEach {
            domainList.add(it.map(postMapper))
        }
        return PostsDomain.Success(domainList)
    }

    override fun map(e: Exception): PostsDomain {
        return PostsDomain.Fail(errorType(e))
    }

}