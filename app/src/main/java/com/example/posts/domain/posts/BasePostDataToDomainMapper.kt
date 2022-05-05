package com.example.posts.domain.posts

import com.example.posts.data.posts.PostDataToDomainMapper

class BasePostDataToDomainMapper : PostDataToDomainMapper<PostDomain> {
    override fun map(userId: Int, id: Int, title: String, body: String): PostDomain {
        return PostDomain.Base(userId, id, title, body)
    }
}