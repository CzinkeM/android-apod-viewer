package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import hu.mczinke.nasa_apod_viewer.R
import hu.mczinke.nasa_apod_viewer.ui.theme.DimmedWhite
import hu.mczinke.nasa_apod_viewer.ui.theme.SpaceBlackVariant
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) {
            1f
        } else {
            0f
        },
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay((4000))
        navController.popBackStack()
        navController.navigate(BottomBarScreen.Home.route)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .alpha(alpha)
            .background(SpaceBlackVariant)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_rocket),
            contentDescription = "vector image of rocket",
            tint = DimmedWhite,
        )
    }
}