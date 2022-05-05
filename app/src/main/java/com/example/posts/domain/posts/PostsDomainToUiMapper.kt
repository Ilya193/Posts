package com.example.posts.domain.posts

import com.example.posts.core.Abstract
import com.example.posts.core.ResourceProvider

abstract class PostsDomainToUiMapper<T>(
    resourceProvider: ResourceProvider
) : Abstract.Mapper.DomainToUi.Base<List<PostDomain>, T>(resourceProvider)