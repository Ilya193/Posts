package com.example.posts.presentation.posts

import com.example.posts.core.Abstract
import com.example.posts.core.Comparing
import com.example.posts.core.TextMapper

sealed class PostUi : Abstract.Object<Unit, TextMapper>, Comparing<PostUi> {

    override fun map(mapper: TextMapper) = Unit

    object Progress : PostUi()

    abstract class Info(
        protected open val userId: Int,
        protected open val id: Int,
        open val title: String,
        protected open val body: String,
    ) : PostUi() {
        override fun map(mapper: TextMapper) {
            mapper.map(title)
        }
    }

    data class Base(
        override val userId: Int,
        override val id: Int,
        override val title: String,
        override val body: String
    ) : Info(userId, id, title, body) {
        override fun sameContent(item: PostUi): Boolean {
            return if (item is Base) {
                title == item.title
            } else false
        }

        override fun same(item: PostUi): Boolean {
            return item is Base && id == item.id
        }
    }

    data class Fail(
        private val message: String
    ) : PostUi() {
        override fun map(mapper: TextMapper) {
            mapper.map(message)
        }
    }
}