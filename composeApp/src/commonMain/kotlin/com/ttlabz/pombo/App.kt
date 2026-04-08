package com.ttlabz.pombo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.ttlabz.core.designsystem.theme.PomboTheme
import com.ttlabz.pombo.navigation.DeepLinkListener
import com.ttlabz.pombo.navigation.NavigationRoot
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    DeepLinkListener(navController)

    PomboTheme {
        NavigationRoot(navController)
    }
}