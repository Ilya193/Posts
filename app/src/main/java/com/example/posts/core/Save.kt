package com.example.posts.core

interface Save<T> {
    fun save(data: T)
}