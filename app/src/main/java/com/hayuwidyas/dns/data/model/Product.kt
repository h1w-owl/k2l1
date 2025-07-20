package com.hayuwidyas.dns.data.model

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val originalPrice: Double? = null,
    val images: List<String>,
    val category: ProductCategory,
    val tags: List<String> = emptyList(),
    val colors: List<ProductColor> = emptyList(),
    val sizes: List<String> = emptyList(),
    val stockCount: Int = 0,
    val rating: Float = 0f,
    val reviewCount: Int = 0,
    val isOnSale: Boolean = false,
    val saleEndTime: Long? = null,
    val attributes: Map<String, String> = emptyMap()
)

data class ProductColor(
    val name: String,
    val hexCode: String
)

enum class ProductCategory(val displayName: String) {
    CROCODILE("Crocodile"),
    PYTHON("Python"),
    LIZARD("Lizard"),
    GOATHAIR("Goathair"),
    BAGS("Bags"),
    WALLETS("Wallets"),
    BELTS("Belts"),
    ACCESSORIES("Accessories")
}