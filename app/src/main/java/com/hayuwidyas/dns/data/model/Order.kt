package com.hayuwidyas.dns.data.model

data class Order(
    val id: String,
    val items: List<CartItem>,
    val status: OrderStatus,
    val orderDate: Long,
    val totalAmount: Double,
    val shippingAddress: Address,
    val trackingNumber: String? = null,
    val estimatedDelivery: Long? = null
)

enum class OrderStatus(val displayName: String) {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    PROCESSING("Processing"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled")
}

data class Address(
    val name: String,
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val phone: String
)