package com.ttlabz.pombo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ttlabz.auth.presentation.navigation.AuthGraphRoutes
import com.ttlabz.auth.presentation.navigation.authGraph
import com.ttlabz.chat.presentation.chat_list.ChatListScreenRoot
import com.ttlabz.chat.presentation.chat_list.ChatListScreenRoute

@Composable
fun NavigationRoot(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AuthGraphRoutes.Graph,
    ) {
        authGraph(
            navController = navController,
            onLoginSuccess = {
                navController.navigate(ChatListScreenRoute) {
                    popUpTo(AuthGraphRoutes.Graph) {
                        inclusive = true
                    }
                }
            }
        )
        composable<ChatListScreenRoute> {
            ChatListScreenRoot()
        }
    }
}