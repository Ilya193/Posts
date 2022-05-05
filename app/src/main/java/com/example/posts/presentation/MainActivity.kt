package com.example.posts.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.core.Retry
import com.example.posts.databinding.ActivityMainBinding
import com.example.posts.presentation.posts.PostsAdapter
import com.example.posts.presentation.posts.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Retry {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val postsViewModel: PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val postsAdapter = PostsAdapter(this)

        binding.postsRecycler.adapter = postsAdapter
        binding.postsRecycler.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        postsViewModel.observe(this) {
            Log.d("attadag", "YES")
            postsAdapter.submitList(it)
        }

        //postsViewModel.fetchBooks()
    }

    override fun tryAgain() {
        postsViewModel.fetchBooks()
    }
}