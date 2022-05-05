package com.example.posts.data.posts.cache

import com.example.posts.core.Abstract
import com.example.posts.core.Read
import com.example.posts.core.RealmProvider
import com.example.posts.core.Save
import com.example.posts.data.posts.PostData
import javax.inject.Inject

interface PostsCacheDataSource<D : Abstract.DataObject> : Read<List<PostDb>>, Save<List<D>> {

    class Base @Inject constructor(
        private val realmProvider: RealmProvider,
        private val mapper: PostDataToDbMapper<PostDb>
    ) : PostsCacheDataSource<PostData> {
        override fun read(): List<PostDb> {
            realmProvider.provide().use { realm ->
                val postsDb = realm.where(PostDb::class.java).findAll() ?: emptyList()
                return realm.copyFromRealm(postsDb)
            }
        }

        override fun save(data: List<PostData>) {
            realmProvider.provide().use { realm ->
                realm.executeTransaction {
                    data.forEach { post ->
                        post.map(mapper, DbWrapper.Base(it))
                    }
                }
            }
        }
    }

}