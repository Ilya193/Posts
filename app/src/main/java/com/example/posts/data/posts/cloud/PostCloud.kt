package com.example.posts.data.posts.cloud

import com.example.posts.core.Abstract
import com.example.posts.data.posts.ToPostMapper
import com.google.gson.annotations.SerializedName

/*
*
{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequunturexpedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
* */

data class PostCloud(
    @SerializedName("userId")
    private val userId: Int,
    @SerializedName("id")
    private val id: Int,
    @SerializedName("title")
    private val title: String,
    @SerializedName("body")
    private val body: String
) : Abstract.CloudObject {

    fun <T> map(mapper: ToPostMapper<T>): T {
        return mapper.map(userId, id, title, body)
    }

}