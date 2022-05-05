package com.example.posts.data.posts.cache

import com.example.posts.core.Abstract
import com.example.posts.data.posts.PostData
import com.example.posts.data.posts.ToPostMapper
import javax.inject.Inject

interface PostsCacheMapper : Abstract.Mapper.Data<List<PostDb>, List<PostData>> {

    class Base @Inject constructor(
        private val mapper: ToPostMapper<PostData>
    ) : PostsCacheMapper {
        override fun map(data: List<PostDb>): List<PostData> {
            return data.map { postDb ->
                postDb.map(mapper)
            }
        }
    }

}