package com.hayuwidyas.dns.data.model

data class NewsArticle(
    val id: String,
    val title: String,
    val excerpt: String,
    val content: String,
    val imageUrl: String,
    val publishDate: Long,
    val author: String,
    val tags: List<String> = emptyList()
)