package com.hayuwidyas.dns.data.repository

import com.hayuwidyas.dns.data.model.Cart
import com.hayuwidyas.dns.data.model.CartItem
import com.hayuwidyas.dns.data.model.Product
import com.hayuwidyas.dns.data.model.ProductColor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton
import java.util.UUID

@Singleton
class CartRepository @Inject constructor() {
    
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: Flow<List<CartItem>> = _cartItems.asStateFlow()
    
    val cart: Flow<Cart> = _cartItems.map { items ->
        Cart(
            items = items,
            totalPrice = items.sumOf { it.product.price * it.quantity },
            itemCount = items.sumOf { it.quantity }
        )
    }
    
    fun addToCart(
        product: Product,
        quantity: Int = 1,
        selectedColor: ProductColor? = null,
        selectedSize: String? = null
    ) {
        val currentItems = _cartItems.value.toMutableList()
        val existingItem = currentItems.find { 
            it.product.id == product.id && 
            it.selectedColor == selectedColor && 
            it.selectedSize == selectedSize 
        }
        
        if (existingItem != null) {
            val updatedItem = existingItem.copy(quantity = existingItem.quantity + quantity)
            currentItems[currentItems.indexOf(existingItem)] = updatedItem
        } else {
            currentItems.add(
                CartItem(
                    id = UUID.randomUUID().toString(),
                    product = product,
                    quantity = quantity,
                    selectedColor = selectedColor,
                    selectedSize = selectedSize
                )
            )
        }
        _cartItems.value = currentItems
    }
    
    fun updateQuantity(cartItemId: String, quantity: Int) {
        val currentItems = _cartItems.value.toMutableList()
        val itemIndex = currentItems.indexOfFirst { it.id == cartItemId }
        if (itemIndex != -1) {
            if (quantity > 0) {
                currentItems[itemIndex] = currentItems[itemIndex].copy(quantity = quantity)
            } else {
                currentItems.removeAt(itemIndex)
            }
            _cartItems.value = currentItems
        }
    }
    
    fun removeFromCart(cartItemId: String) {
        _cartItems.value = _cartItems.value.filter { it.id != cartItemId }
    }
    
    fun clearCart() {
        _cartItems.value = emptyList()
    }
}