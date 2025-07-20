package com.hayuwidyas.dns.ui.screens.onboarding

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hayuwidyas.dns.ui.theme.HayuPink
import com.hayuwidyas.dns.ui.theme.HayuPinkLight
import kotlinx.coroutines.delay

@Composable
fun OnboardingScreen(
    onNavigateToAuth: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    var visible by remember { mutableStateOf(false) }
    
    LaunchedEffect(Unit) {
        delay(500)
        visible = true
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.8f),
                        HayuPink.copy(alpha = 0.3f),
                        Color.Black.copy(alpha = 0.9f)
                    )
                )
            )
    ) {
        // Background Image
        AsyncImage(
            model = "https://images.unsplash.com/photo-1590736797933-d0c56a5b5bac?w=800",
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.4f
        )
        
        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            
            // Logo and Brand Name
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(
                    animationSpec = tween(1000)
                ) + slideInVertically(
                    animationSpec = tween(1000),
                    initialOffsetY = { -100 }
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "HAYU WIDYAS",
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 4.sp
                        ),
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "HANDMADE IN INDONESIA",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            letterSpacing = 2.sp
                        ),
                        color = HayuPinkLight,
                        textAlign = TextAlign.Center
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(60.dp))
            
            // Description
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(
                    animationSpec = tween(1000, delayMillis = 500)
                ) + slideInVertically(
                    animationSpec = tween(1000, delayMillis = 500),
                    initialOffsetY = { 100 }
                )
            ) {
                Text(
                    text = "Discover the finest collection of handcrafted leather goods. From luxury crocodile handbags to elegant python accessories.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White.copy(alpha = 0.9f),
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp
                )
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Action Buttons
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(
                    animationSpec = tween(1000, delayMillis = 1000)
                ) + slideInVertically(
                    animationSpec = tween(1000, delayMillis = 1000),
                    initialOffsetY = { 100 }
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = onNavigateToAuth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = HayuPink
                        ),
                        shape = RoundedCornerShape(28.dp)
                    ) {
                        Text(
                            text = "GET STARTED",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            ),
                            color = Color.White
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    TextButton(
                        onClick = onNavigateToHome,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Continue as Guest",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}