package com.example.posts.core

import android.view.View
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.databinding.FailBinding
import com.example.posts.databinding.LoadingBinding
import com.example.posts.presentation.posts.PostUi

abstract class BaseAdapter<E : Comparing<E>, T : BaseViewHolder<E>> :
    ListAdapter<E, T>(DiffUtilCallback<E>()) {

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bind(getItem(position))
    }
}

abstract class BaseViewHolder<E>(view: View) : RecyclerView.ViewHolder(view) {
    open fun bind(item: E) {}

    class Progress<E : PostUi>(
        view: LoadingBinding
    ) : BaseViewHolder<E>(view.root) {
        private val loading = view.loading

        override fun bind(item: E) {
            loading.visibility = View.VISIBLE
        }
    }

    class Fail<E : PostUi>(
        view: FailBinding,
        private val retry: Retry
    ) : BaseViewHolder<E>(view.root) {
        private val message = view.message
        private val tryAgain = view.tryAgain

        override fun bind(item: E) {
            item.map(message)
            tryAgain.setOnClickListener {
                retry.tryAgain()
            }
        }
    }
}