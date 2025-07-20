package com.hayuwidyas.dns.di

import com.hayuwidyas.dns.data.dummy.DummyDataProvider
import com.hayuwidyas.dns.data.repository.CartRepository
import com.hayuwidyas.dns.data.repository.NewsRepository
import com.hayuwidyas.dns.data.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideDummyDataProvider(): DummyDataProvider {
        return DummyDataProvider()
    }
    
    @Provides
    @Singleton
    fun provideProductRepository(
        dummyDataProvider: DummyDataProvider
    ): ProductRepository {
        return ProductRepository(dummyDataProvider)
    }
    
    @Provides
    @Singleton
    fun provideNewsRepository(
        dummyDataProvider: DummyDataProvider
    ): NewsRepository {
        return NewsRepository(dummyDataProvider)
    }
    
    @Provides
    @Singleton
    fun provideCartRepository(): CartRepository {
        return CartRepository()
    }
}