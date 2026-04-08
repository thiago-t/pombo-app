package com.ttlabz.pombo

import androidx.compose.runtime.Composable
import com.ttlabz.core.designsystem.theme.PomboTheme
import com.ttlabz.pombo.navigation.NavigationRoot
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    PomboTheme {
        NavigationRoot()
    }
}