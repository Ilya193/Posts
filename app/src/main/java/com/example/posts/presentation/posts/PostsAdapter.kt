package com.example.posts.presentation.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.posts.R
import com.example.posts.core.BaseAdapter
import com.example.posts.core.BaseViewHolder
import com.example.posts.core.CustomTextView
import com.example.posts.core.Retry
import com.example.posts.databinding.FailBinding
import com.example.posts.databinding.LoadingBinding
import com.example.posts.databinding.TextItemBinding

class PostsAdapter(
    private val retry: Retry
) : BaseAdapter<PostUi, BaseViewHolder<PostUi>>() {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is PostUi.Base -> 0
            is PostUi.Progress -> 1
            else -> 2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PostUi> {
        return when (viewType) {
            0 -> PostsViewHolder.Base(
                TextItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            1 -> BaseViewHolder.Progress(
                LoadingBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> BaseViewHolder.Fail(
                FailBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                retry
            )
        }
    }

    abstract class PostsViewHolder(view: View) : BaseViewHolder<PostUi>(view) {
        abstract class Info(view: View) : PostsViewHolder(view) {
            private val post: CustomTextView = view.findViewById(R.id.textView)

            override fun bind(item: PostUi) {
                item.map(post)
            }
        }

        class Base(view: TextItemBinding) : Info(view.root)
    }

}