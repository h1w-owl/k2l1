package com.hayuwidyas.dns.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hayuwidyas.dns.data.model.NewsArticle
import com.hayuwidyas.dns.data.model.Product
import com.hayuwidyas.dns.data.model.ProductCategory
import com.hayuwidyas.dns.data.repository.NewsRepository
import com.hayuwidyas.dns.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val isLoading: Boolean = true,
    val categories: Map<ProductCategory, List<Product>> = emptyMap(),
    val flashSaleProducts: List<Product> = emptyList(),
    val newsArticles: List<NewsArticle> = emptyList(),
    val errorMessage: String? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val newsRepository: NewsRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    
    init {
        loadHomeData()
    }
    
    private fun loadHomeData() {
        viewModelScope.launch {
            try {
                // Load products and organize by categories
                productRepository.getProducts()
                    .combine(productRepository.getFlashSaleProducts()) { products, flashSaleProducts ->
                        val categorizedProducts = products.groupBy { it.category }
                            .mapValues { (_, products) -> products.take(6) } // Limit to 6 per category
                        
                        _uiState.value = _uiState.value.copy(
                            categories = categorizedProducts,
                            flashSaleProducts = flashSaleProducts
                        )
                    }
                    .launchIn(this)
                
                // Load news articles
                newsRepository.getNewsArticles()
                    .onEach { articles ->
                        _uiState.value = _uiState.value.copy(
                            newsArticles = articles,
                            isLoading = false
                        )
                    }
                    .launchIn(this)
                    
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    errorMessage = e.message,
                    isLoading = false
                )
            }
        }
    }
}