package com.example.posts.data.posts.cache

import io.realm.RealmObject

interface PostDataToDbMapper<T : RealmObject> {

    fun mapToDb(userId: Int, id: Int, title: String, body: String, dbWrapper: DbWrapper<T>): T

    class Base : PostDataToDbMapper<PostDb> {
        override fun mapToDb(
            userId: Int,
            id: Int,
            title: String,
            body: String,
            dbWrapper: DbWrapper<PostDb>
        ): PostDb {
            return dbWrapper.createObject(id).apply {
                this.userId = userId
                this.title = title
                this.body = body
            }
        }
    }

}