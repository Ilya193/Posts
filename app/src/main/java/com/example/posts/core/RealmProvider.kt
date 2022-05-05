package com.example.posts.core

import android.content.Context
import io.realm.Realm

interface RealmProvider {
    fun provide(): Realm

    class Base(
        context: Context
    ) : RealmProvider {

        init {
            Realm.init(context)
        }

        override fun provide(): Realm {
            return Realm.getDefaultInstance()
        }

    }
}