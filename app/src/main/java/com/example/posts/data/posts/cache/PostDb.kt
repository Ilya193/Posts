package com.example.posts.data.posts.cache

import com.example.posts.data.posts.ToPostMapper
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class PostDb : RealmObject(), PostRealm {
    @PrimaryKey
    var id: Int = -1
    var userId: Int = -1
    var title: String = ""
    var body: String = ""

    override fun <T> map(mapper: ToPostMapper<T>): T {
        return mapper.map(userId, id, title, body)
    }
}

interface PostRealm {
    fun <T> map(mapper: ToPostMapper<T>): T
}