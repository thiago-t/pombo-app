package com.ttlabz.pombo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.ttlabz.auth.presentation.navigation.AuthGraphRoutes
import com.ttlabz.chat.presentation.chat_list.ChatListScreenRoute
import com.ttlabz.core.designsystem.theme.PomboTheme
import com.ttlabz.pombo.navigation.DeepLinkListener
import com.ttlabz.pombo.navigation.NavigationRoot
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(
    onAuthenticationChecked: () -> Unit = {},
    viewModel: MainViewModel = koinViewModel()
) {
    val navController = rememberNavController()
    DeepLinkListener(navController)

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(state.isCheckingAuth) {
        if (!state.isCheckingAuth) {
            onAuthenticationChecked()
        }
    }

    PomboTheme {
        if (!state.isCheckingAuth) {
            NavigationRoot(
                navController = navController,
                startDestination = if (state.isLoggedIn) {
                    ChatListScreenRoute
                } else {
                    AuthGraphRoutes.Graph
                }
            )
        }
    }
}