package com.example.posts.domain.posts

import com.example.posts.core.Abstract

interface PostDomainToUiMapper<T> : Abstract.Mapper {
    fun map(userId: Int, id: Int, title: String, body: String): T
}