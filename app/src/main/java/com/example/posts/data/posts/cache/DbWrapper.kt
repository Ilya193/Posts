package com.example.posts.data.posts.cache

import io.realm.Realm
import io.realm.RealmObject

interface DbWrapper<T : RealmObject> {
    fun createObject(id: Int): T

    class Base(
        private val realm: Realm
    ) : DbWrapper<PostDb> {
        override fun createObject(id: Int): PostDb {
            return realm.createObject(PostDb::class.java, id)
        }
    }
}