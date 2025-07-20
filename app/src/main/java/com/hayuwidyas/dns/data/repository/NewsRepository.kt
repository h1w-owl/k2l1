package com.hayuwidyas.dns.data.repository

import com.hayuwidyas.dns.data.dummy.DummyDataProvider
import com.hayuwidyas.dns.data.model.NewsArticle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val dummyDataProvider: DummyDataProvider
) {
    
    fun getNewsArticles(): Flow<List<NewsArticle>> = flow {
        delay(300)
        emit(dummyDataProvider.getNewsArticles())
    }
}