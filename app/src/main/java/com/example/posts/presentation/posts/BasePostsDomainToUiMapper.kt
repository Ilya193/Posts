package com.example.posts.presentation.posts

import com.example.posts.core.ErrorType
import com.example.posts.core.ResourceProvider
import com.example.posts.domain.posts.PostDomain
import com.example.posts.domain.posts.PostDomainToUiMapper
import com.example.posts.domain.posts.PostsDomainToUiMapper
import javax.inject.Inject

class BasePostsDomainToUiMapper @Inject constructor(
    private val postMapper: PostDomainToUiMapper<PostUi>,
    resourceProvider: ResourceProvider
) : PostsDomainToUiMapper<PostsUi>(resourceProvider) {

    override fun map(data: List<PostDomain>): PostsUi {
        return PostsUi.Base(data.map { it.map(postMapper) })
    }

    override fun map(errorType: ErrorType): PostsUi {
        return PostsUi.Base(listOf(PostUi.Fail(errorMessage(errorType))))
    }

}