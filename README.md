# Hayu Widyas - Fashion E-commerce Android App

A sophisticated, ultra-fast, and visually engaging Android fashion e-commerce app for **Hayu Widyas** (https://hayuwidyas.com), specializing in handmade Indonesian leather goods.

## 🎯 App Overview

This modern Android app delivers a premium shopping experience for luxury leather fashion products, featuring:
- **Handcrafted Indonesian leather goods** (Crocodile, Python, Lizard, Goathair)
- **Modern Material 3 UI** with custom Hayu Widyas branding
- **Smooth animations** and elegant user interactions
- **Comprehensive e-commerce features** including cart, wishlist, and product management
- **Dummy data integration** for seamless development and testing

## 🏗️ Architecture & Technology Stack

### Core Technologies
- **Kotlin** - Primary programming language
- **Jetpack Compose** - Modern declarative UI toolkit
- **Material 3** - Latest Material Design system
- **Hilt/Dagger** - Dependency injection
- **MVVM Architecture** - Clean separation of concerns
- **Coroutines & Flow** - Asynchronous programming
- **Navigation Compose** - Type-safe navigation

### Key Libraries
- **Compose BOM 2024.12.01** - UI framework
- **Coil** - Image loading
- **Lottie** - Animations
- **Retrofit** - Network layer (ready for API integration)
- **Firebase** - Authentication and analytics (configured)
- **DataStore** - Local data persistence

## 📱 App Features

### 🚀 Onboarding & Authentication
- **Animated splash screen** with Hayu Widyas branding
- **Beautiful onboarding flow** showcasing "Handmade in Indonesia" tagline
- **Google Sign-in integration** (Firebase Auth ready)
- **Guest mode** for immediate access

### 🏠 Homepage
- **Hero banner** with "Handmade in Indonesia" and animated CTA
- **Prestige Lines Unlocked** section featuring 4 categories:
  - Crocodile leather products
  - Python skin accessories
  - Lizard leather goods
  - Goathair items
- **Auto-sliding product carousels** (6 products per category, 4 visible)
- **Flash Sale section** with live countdown timer
- **Magazine/News slider** featuring brand stories and articles

### 🛍️ Shop Page
- **Advanced filtering and sorting** (price, category, rating)
- **Responsive grid layout** with lazy loading
- **Search functionality** with debounced input
- **Product quick preview** with image carousels
- **Infinite scroll** for seamless browsing

### 🔍 Product Details
- **Image gallery** with swipe, zoom, and video support
- **Comprehensive product information**:
  - Name, price, detailed descriptions
  - Customer reviews and ratings
  - Size guide and attributes
  - Stock status and availability
  - Color and size selection
- **Sticky "Add to Cart" bar**
- **Social sharing capabilities**
- **Related products suggestions**

### 🛒 Shopping Cart & Checkout
- **Dynamic cart management** (add, remove, update quantities)
- **Multi-step checkout process**:
  - Shipping address selection
  - Payment method choice (Midtrans ready)
  - Order summary and confirmation
- **Guest and registered user checkout**
- **Shipping cost calculation** (Biteship integration ready)

### 💝 Wishlist & Comparison
- **Personal wishlist** (local storage for guests, Firebase sync for users)
- **Product comparison** with side-by-side view
- **Easy wishlist to cart conversion**

### 📦 Order Tracking
- **Order history and status tracking**
- **Timeline view** for order progress
- **Push notifications** for order updates (Firebase ready)

### 👤 User Profile
- **Profile management** (editable information)
- **Address book** for shipping
- **Payment methods** storage
- **Notification preferences**
- **Order history** access

## 🎨 UI/UX Design

### Brand Identity
- **Primary Color**: Hayu Pink (#ED1B76)
- **Typography**: Clean, luxury-focused fonts
- **Style**: Minimalist, elegant, modern
- **Visual Elements**: High-quality product imagery, subtle animations

### Navigation
- **Bottom Navigation Bar** with 5 main sections:
  - Home
  - Shop  
  - Wishlist
  - Cart (with badge showing item count)
  - Account
- **No drawer navigation** - uses modals, bottom sheets, and overlays
- **Smooth transitions** between screens

### Animations
- **Jetpack Compose animations** for micro-interactions
- **Page transitions** with fade/slide effects
- **Loading states** with elegant placeholders
- **Parallax scrolling** effects
- **Flash sale countdown** with real-time updates

## 📊 Dummy Data

The app includes comprehensive dummy data for all features:

### Product Categories
1. **Crocodile Collection**
   - Luxury Crocodile Handbag ($2,500)
   - Crocodile Wallet Premium ($850)

2. **Python Collection**
   - Python Skin Clutch ($1,200)
   - Python Belt Executive ($650)

3. **Lizard Collection**
   - Lizard Leather Tote ($950)
   - Lizard Card Holder ($280)

4. **Goathair Collection**
   - Goathair Shoulder Bag ($720)
   - Goathair Weekend Bag ($1,150)

### News Articles
- "The Art of Leather Crafting in Indonesia"
- "Sustainable Fashion: Our Commitment"
- "New Collection Launch: Exotic Leather Series"

### Sample Features
- **Product reviews and ratings**
- **Flash sale items** with countdown timers
- **Stock levels and availability**
- **Color variants** (Black, Brown, Tan, Burgundy, Navy, Cognac)
- **Size options** for relevant products

## 🔄 Switching Between Dummy and Real Data

The app is designed for easy transition from dummy data to real API integration:

### Current Setup (Dummy Data)
```kotlin
// Located in: data/dummy/DummyDataProvider.kt
@Singleton
class DummyDataProvider @Inject constructor() {
    fun getProducts(): List<Product> = /* dummy products */
    fun getNewsArticles(): List<NewsArticle> = /* dummy articles */
}
```

### To Switch to Real API:
1. **Replace repositories** in `di/DatabaseModule.kt`
2. **Update data sources** to use Retrofit services
3. **Modify DummyDataProvider** or create new API services
4. **Update ViewModels** to handle loading states and errors

### Example API Integration:
```kotlin
// Create new file: data/api/HayuWidyasApiService.kt
interface HayuWidyasApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
    
    @GET("news")
    suspend fun getNews(): List<NewsArticle>
}

// Update: data/repository/ProductRepository.kt
class ProductRepository @Inject constructor(
    private val apiService: HayuWidyasApiService // Replace DummyDataProvider
) {
    fun getProducts(): Flow<List<Product>> = flow {
        emit(apiService.getProducts())
    }
}
```

## 🚀 Getting Started

### Prerequisites
- **Android Studio Narwhal | 2025.1.1 Patch 1** or later
- **Android SDK 24+** (minimum)
- **Target SDK 36**
- **Kotlin 2.0.21**

### Installation
1. **Clone the repository**
   ```bash
   git clone https://github.com/h1w-owl/k2l1.git
   cd k2l1
   ```

2. **Open in Android Studio**
   - Open the project in Android Studio
   - Sync Gradle files
   - Wait for indexing to complete

3. **Run the app**
   - Select a device/emulator
   - Click Run or press Ctrl+R (Cmd+R on Mac)

### Build Configuration
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 36 (Android 15)
- **Compile SDK**: 36
- **Java Version**: 11

## 📁 Project Structure

```
app/src/main/java/com/hayuwidyas/dns/
├── data/
│   ├── dummy/           # Dummy data providers
│   ├── model/           # Data models (Product, Cart, Order, etc.)
│   └── repository/      # Repository pattern implementations
├── di/                  # Hilt dependency injection modules
├── navigation/          # Navigation setup and destinations
├── ui/
│   ├── screens/         # All screen composables
│   │   ├── auth/        # Authentication screens
│   │   ├── cart/        # Shopping cart
│   │   ├── home/        # Homepage with hero banner
│   │   ├── main/        # Main app structure
│   │   ├── onboarding/  # App introduction
│   │   ├── product/     # Product details
│   │   ├── profile/     # User profile
│   │   ├── shop/        # Product catalog
│   │   └── wishlist/    # Saved products
│   └── theme/           # Material 3 theming (colors, typography)
├── HayuWidyasApplication.kt  # Application class with Hilt
└── MainActivity.kt      # Main activity with Compose setup
```

## 🔧 Configuration Preserved

**Important**: This enhancement maintains **100% compatibility** with existing configuration:

### Unchanged Elements
- ✅ **Gradle build scripts** (only added new dependencies)
- ✅ **Project structure** (extended, not modified)
- ✅ **AndroidManifest.xml** (only added permissions and Application class)
- ✅ **Existing dependencies** (all preserved)
- ✅ **Package structure** (maintained `com.hayuwidyas.dns`)
- ✅ **Build configuration** (SDK versions, etc.)

### Added Enhancements
- ➕ **Jetpack Compose** UI framework
- ➕ **Material 3** design system
- ➕ **Hilt** dependency injection
- ➕ **Navigation Compose** for routing
- ➕ **Modern architecture** patterns
- ➕ **Comprehensive dummy data**
- ➕ **Firebase integration** (ready for use)

## 🎯 Future Enhancements

### Ready for Implementation
1. **API Integration**
   - Replace dummy data with real Hayu Widyas API
   - Implement user authentication
   - Add real payment processing

2. **Advanced Features**
   - Push notifications for orders and promotions
   - Offline capability with Room database
   - Advanced search with filters
   - AR try-on features
   - Social sharing integration

3. **Performance Optimizations**
   - Image caching strategies
   - Lazy loading improvements
   - Background data sync

## 📝 License

This project is developed for Hayu Widyas. All rights reserved.

## 🤝 Contributing

This is a private project for Hayu Widyas. For any contributions or modifications, please contact the development team.

---

**Created with ❤️ for Hayu Widyas - Handmade in Indonesia**