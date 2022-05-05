package com.example.posts.presentation.posts

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.domain.posts.PostsDomainToUiMapper
import com.example.posts.domain.posts.PostsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postsInteractor: PostsInteractor,
    private val mapper: PostsDomainToUiMapper<PostsUi>,
    private val communication: PostsCommunication,
) : ViewModel() {

    init {
        fetchBooks()
    }

    fun fetchBooks() {
        communication.map(listOf(PostUi.Progress))
        viewModelScope.launch(Dispatchers.IO) {
            val resultUi = postsInteractor.fetchPosts().map(mapper)
            withContext(Dispatchers.Main) {
                resultUi.map(communication)
            }
        }
    }

    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<List<PostUi>>) {
        communication.observe(lifecycleOwner, observer)
    }

}