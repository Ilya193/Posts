package com.example.posts.core

interface Comparing<T> {
    fun same(item: T) = false
    fun sameContent(item: T) = false
}