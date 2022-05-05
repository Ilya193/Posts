package com.example.posts.data.posts

import com.example.posts.core.Abstract
import com.example.posts.data.posts.cache.DbWrapper
import com.example.posts.data.posts.cache.PostDataToDbMapper
import io.realm.RealmObject

class PostData(
    private val userId: Int,
    private val id: Int,
    private val title: String,
    private val body: String
) : Abstract.DataObject {

    fun <T> map(mapper: PostDataToDomainMapper<T>): T {
        return mapper.map(userId, id, title, body)
    }

    fun <T : RealmObject> map(mapper: PostDataToDbMapper<T>, db: DbWrapper<T>): T {
        return mapper.mapToDb(userId, id, title, body, db)
    }

}