package com.example.posts.presentation.posts

import com.example.posts.domain.posts.PostDomainToUiMapper

class BasePostDomainToUiMapper : PostDomainToUiMapper<PostUi> {
    override fun map(userId: Int, id: Int, title: String, body: String): PostUi {
        return PostUi.Base(userId, id, title, body)
    }
}