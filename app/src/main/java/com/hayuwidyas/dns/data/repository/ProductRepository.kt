package com.hayuwidyas.dns.data.repository

import com.hayuwidyas.dns.data.dummy.DummyDataProvider
import com.hayuwidyas.dns.data.model.Product
import com.hayuwidyas.dns.data.model.ProductCategory
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val dummyDataProvider: DummyDataProvider
) {
    
    fun getProducts(): Flow<List<Product>> = flow {
        delay(500) // Simulate network delay
        emit(dummyDataProvider.getProducts())
    }
    
    fun getFlashSaleProducts(): Flow<List<Product>> = flow {
        delay(300)
        emit(dummyDataProvider.getFlashSaleProducts())
    }
    
    fun getProductsByCategory(category: ProductCategory): Flow<List<Product>> = flow {
        delay(300)
        emit(dummyDataProvider.getProductsByCategory(category))
    }
    
    fun getProduct(id: String): Flow<Product?> = flow {
        delay(200)
        emit(dummyDataProvider.getProduct(id))
    }
    
    fun searchProducts(query: String): Flow<List<Product>> = flow {
        delay(400)
        emit(dummyDataProvider.searchProducts(query))
    }
}