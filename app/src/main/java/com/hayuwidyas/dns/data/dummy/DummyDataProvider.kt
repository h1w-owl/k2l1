package com.hayuwidyas.dns.data.dummy

import com.hayuwidyas.dns.data.model.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DummyDataProvider @Inject constructor() {
    
    private val sampleImages = listOf(
        "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=400",
        "https://images.unsplash.com/photo-1584917865442-de89df76afd3?w=400",
        "https://images.unsplash.com/photo-1590874103328-eac38a683ce7?w=400",
        "https://images.unsplash.com/photo-1594736797933-d0c56a5b5bac?w=400",
        "https://images.unsplash.com/photo-1595950653106-6c9ebd614d3a?w=400",
        "https://images.unsplash.com/photo-1571781926291-c477ebfd024b?w=400"
    )
    
    private val leatherColors = listOf(
        ProductColor("Black", "#000000"),
        ProductColor("Brown", "#8B4513"),
        ProductColor("Tan", "#D2B48C"),
        ProductColor("Burgundy", "#800020"),
        ProductColor("Navy", "#191970"),
        ProductColor("Cognac", "#A0522D")
    )
    
    private val commonSizes = listOf("S", "M", "L", "XL")
    private val bagSizes = listOf("Small", "Medium", "Large")
    
    fun getProducts(): List<Product> = listOf(
        // Crocodile Collection
        Product(
            id = "croc_001",
            name = "Luxury Crocodile Handbag",
            description = "Exquisite handcrafted crocodile leather handbag with premium finishing. Made from genuine saltwater crocodile skin with impeccable attention to detail.",
            price = 2500.0,
            originalPrice = 2800.0,
            images = sampleImages.take(3),
            category = ProductCategory.CROCODILE,
            tags = listOf("luxury", "handmade", "crocodile"),
            colors = leatherColors.take(3),
            sizes = bagSizes,
            stockCount = 5,
            rating = 4.8f,
            reviewCount = 24,
            isOnSale = true,
            saleEndTime = System.currentTimeMillis() + 86400000 * 7, // 7 days
            attributes = mapOf(
                "Material" to "Genuine Crocodile Leather",
                "Origin" to "Indonesia",
                "Lining" to "Silk",
                "Hardware" to "Gold-plated"
            )
        ),
        Product(
            id = "croc_002",
            name = "Crocodile Wallet Premium",
            description = "Premium crocodile leather wallet with multiple card slots and spacious compartments.",
            price = 850.0,
            images = sampleImages.drop(1).take(3),
            category = ProductCategory.CROCODILE,
            tags = listOf("wallet", "premium", "crocodile"),
            colors = leatherColors.take(4),
            stockCount = 12,
            rating = 4.7f,
            reviewCount = 18,
            attributes = mapOf(
                "Material" to "Genuine Crocodile Leather",
                "Card Slots" to "8",
                "Dimensions" to "11.5 x 9.5 cm"
            )
        ),
        
        // Python Collection
        Product(
            id = "python_001",
            name = "Python Skin Clutch",
            description = "Elegant python skin clutch perfect for evening occasions. Features beautiful natural patterns.",
            price = 1200.0,
            originalPrice = 1400.0,
            images = sampleImages.drop(2).take(3),
            category = ProductCategory.PYTHON,
            tags = listOf("clutch", "evening", "python"),
            colors = leatherColors.drop(1).take(3),
            sizes = listOf("One Size"),
            stockCount = 8,
            rating = 4.6f,
            reviewCount = 15,
            isOnSale = true,
            attributes = mapOf(
                "Material" to "Genuine Python Leather",
                "Closure" to "Magnetic",
                "Interior" to "Suede Lining"
            )
        ),
        Product(
            id = "python_002",
            name = "Python Belt Executive",
            description = "Executive python leather belt with brushed steel buckle. Perfect for business attire.",
            price = 650.0,
            images = sampleImages.drop(3).take(2),
            category = ProductCategory.PYTHON,
            tags = listOf("belt", "executive", "python"),
            colors = leatherColors.take(2),
            sizes = listOf("32", "34", "36", "38", "40", "42"),
            stockCount = 15,
            rating = 4.5f,
            reviewCount = 22,
            attributes = mapOf(
                "Material" to "Python Leather",
                "Buckle" to "Brushed Steel",
                "Width" to "3.5 cm"
            )
        ),
        
        // Lizard Collection
        Product(
            id = "lizard_001",
            name = "Lizard Leather Tote",
            description = "Spacious lizard leather tote bag perfect for daily use. Features comfortable handles and modern design.",
            price = 950.0,
            images = sampleImages.drop(4).take(3),
            category = ProductCategory.LIZARD,
            tags = listOf("tote", "daily", "lizard"),
            colors = leatherColors.drop(2).take(3),
            sizes = bagSizes,
            stockCount = 10,
            rating = 4.4f,
            reviewCount = 12,
            attributes = mapOf(
                "Material" to "Lizard Leather",
                "Handle Drop" to "22 cm",
                "Interior Pockets" to "3"
            )
        ),
        Product(
            id = "lizard_002",
            name = "Lizard Card Holder",
            description = "Slim lizard leather card holder with minimalist design. Perfect for modern lifestyle.",
            price = 280.0,
            images = sampleImages.take(2),
            category = ProductCategory.LIZARD,
            tags = listOf("cardholder", "minimalist", "lizard"),
            colors = leatherColors,
            stockCount = 25,
            rating = 4.3f,
            reviewCount = 8,
            attributes = mapOf(
                "Material" to "Lizard Leather",
                "Card Capacity" to "6 cards",
                "Thickness" to "8 mm"
            )
        ),
        
        // Goathair Collection
        Product(
            id = "goat_001",
            name = "Goathair Shoulder Bag",
            description = "Unique goathair shoulder bag with distinctive texture and superior durability.",
            price = 720.0,
            images = sampleImages.drop(1).take(3),
            category = ProductCategory.GOATHAIR,
            tags = listOf("shoulder", "unique", "goathair"),
            colors = leatherColors.take(2),
            sizes = bagSizes.take(2),
            stockCount = 7,
            rating = 4.2f,
            reviewCount = 6,
            attributes = mapOf(
                "Material" to "Goathair Leather",
                "Strap" to "Adjustable",
                "Closure" to "Zipper"
            )
        ),
        Product(
            id = "goat_002",
            name = "Goathair Weekend Bag",
            description = "Spacious goathair weekend bag for travel and leisure. Combines style with functionality.",
            price = 1150.0,
            images = sampleImages.drop(3).take(3),
            category = ProductCategory.GOATHAIR,
            tags = listOf("weekend", "travel", "goathair"),
            colors = leatherColors.drop(3).take(2),
            sizes = listOf("Large"),
            stockCount = 4,
            rating = 4.7f,
            reviewCount = 10,
            attributes = mapOf(
                "Material" to "Goathair Leather",
                "Capacity" to "40L",
                "Compartments" to "Multiple"
            )
        )
    )
    
    fun getFlashSaleProducts(): List<Product> = getProducts().filter { it.isOnSale }
    
    fun getProductsByCategory(category: ProductCategory): List<Product> = 
        getProducts().filter { it.category == category }
    
    fun getNewsArticles(): List<NewsArticle> = listOf(
        NewsArticle(
            id = "news_001",
            title = "The Art of Leather Crafting in Indonesia",
            excerpt = "Discover the traditional techniques behind Indonesia's finest leather products",
            content = "Indonesian leather crafting represents centuries of tradition and skill passed down through generations...",
            imageUrl = "https://images.unsplash.com/photo-1590736797933-d0c56a5b5bac?w=600",
            publishDate = System.currentTimeMillis() - 86400000 * 2,
            author = "Hayu Widyas Editorial",
            tags = listOf("crafting", "tradition", "indonesia")
        ),
        NewsArticle(
            id = "news_002",
            title = "Sustainable Fashion: Our Commitment",
            excerpt = "Learn about our sustainable practices and commitment to ethical fashion",
            content = "At Hayu Widyas, sustainability isn't just a buzzword – it's at the core of everything we do...",
            imageUrl = "https://images.unsplash.com/photo-1571781926291-c477ebfd024b?w=600",
            publishDate = System.currentTimeMillis() - 86400000 * 5,
            author = "Sustainability Team",
            tags = listOf("sustainability", "fashion", "ethics")
        ),
        NewsArticle(
            id = "news_003",
            title = "New Collection Launch: Exotic Leather Series",
            excerpt = "Introducing our latest collection featuring rare and exotic leather varieties",
            content = "We're excited to announce the launch of our most ambitious collection yet...",
            imageUrl = "https://images.unsplash.com/photo-1594736797933-d0c56a5b5bac?w=600",
            publishDate = System.currentTimeMillis() - 86400000 * 7,
            author = "Design Team",
            tags = listOf("collection", "launch", "exotic")
        )
    )
    
    fun getProduct(id: String): Product? = getProducts().find { it.id == id }
    
    fun searchProducts(query: String): List<Product> = getProducts().filter { product ->
        product.name.contains(query, ignoreCase = true) ||
        product.description.contains(query, ignoreCase = true) ||
        product.tags.any { it.contains(query, ignoreCase = true) } ||
        product.category.displayName.contains(query, ignoreCase = true)
    }
}