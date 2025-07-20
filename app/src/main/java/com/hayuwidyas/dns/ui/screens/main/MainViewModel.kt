package com.hayuwidyas.dns.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hayuwidyas.dns.data.repository.CartRepository
import com.hayuwidyas.dns.navigation.HayuDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val cartRepository: CartRepository
) : ViewModel() {
    
    private val _shouldShowBottomBar = MutableStateFlow(false)
    val shouldShowBottomBar: StateFlow<Boolean> = _shouldShowBottomBar.asStateFlow()
    
    private val _cartItemCount = MutableStateFlow(0)
    val cartItemCount: StateFlow<Int> = _cartItemCount.asStateFlow()
    
    init {
        // Observe cart changes
        cartRepository.cart
            .onEach { cart ->
                _cartItemCount.value = cart.itemCount
            }
            .launchIn(viewModelScope)
    }
    
    fun updateBottomBarVisibility(route: String?) {
        _shouldShowBottomBar.value = when (route) {
            HayuDestinations.ONBOARDING,
            HayuDestinations.AUTH -> false
            else -> true
        }
    }
}