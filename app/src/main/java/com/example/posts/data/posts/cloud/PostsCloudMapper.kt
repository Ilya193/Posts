package com.example.posts.data.posts.cloud

import com.example.posts.core.Abstract
import com.example.posts.data.posts.PostData
import com.example.posts.data.posts.ToPostMapper
import javax.inject.Inject

interface PostsCloudMapper : Abstract.Mapper.Data<List<PostCloud>, List<PostData>> {

    class Base @Inject constructor(
        private val postMapper: ToPostMapper<PostData>
    ) : PostsCloudMapper {
        override fun map(data: List<PostCloud>): List<PostData> {
            return data.map { postCloud ->
                postCloud.map(postMapper)
            }
        }
    }

}