package com.example.posts.presentation.posts

import com.example.posts.core.Communication

interface PostsCommunication : Communication<List<PostUi>> {
    class Base : Communication.Base<List<PostUi>>(), PostsCommunication
}