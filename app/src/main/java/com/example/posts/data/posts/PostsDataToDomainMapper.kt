package com.example.posts.data.posts

import com.example.posts.core.Abstract

abstract class PostsDataToDomainMapper<T> : Abstract.Mapper.DataToDomain.Base<List<PostData>, T>()