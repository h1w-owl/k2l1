package com.hayuwidyas.dns.data.model

data class CartItem(
    val id: String,
    val product: Product,
    val quantity: Int,
    val selectedColor: ProductColor? = null,
    val selectedSize: String? = null
)

data class Cart(
    val items: List<CartItem> = emptyList(),
    val totalPrice: Double = 0.0,
    val itemCount: Int = 0
)