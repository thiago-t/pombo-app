package com.ttlabz.auth.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.ttlabz.auth.presentation.email_verification.EmailVerificationRoot
import com.ttlabz.auth.presentation.forgot_password.ForgotPasswordRoot
import com.ttlabz.auth.presentation.login.LoginScreenRoot
import com.ttlabz.auth.presentation.register.RegisterRoot
import com.ttlabz.auth.presentation.register_success.RegisterSuccessRoot
import com.ttlabz.auth.presentation.reset_password.ResetPasswordRoot

fun NavGraphBuilder.authGraph(
    navController: NavController,
    onLoginSuccess: () -> Unit,
) {
    navigation<AuthGraphRoutes.Graph>(
        startDestination = AuthGraphRoutes.Login,
    ) {
        composable<AuthGraphRoutes.Login> {
            LoginScreenRoot(
                onLoginSuccess = onLoginSuccess,
                onForgotPasswordClick = {
                    navController.navigate(AuthGraphRoutes.ForgotPassword)
                },
                onCreateAccountClick = {
                    navController.navigate(AuthGraphRoutes.Register) {
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
        composable<AuthGraphRoutes.Register> {
            RegisterRoot(
                onRegisterSuccess = {
                    navController.navigate(AuthGraphRoutes.RegisterSuccess(it))
                },
                onLoginClick = {
                    navController.navigate(AuthGraphRoutes.Login) {
                        popUpTo(AuthGraphRoutes.Register) {
                            inclusive = true
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
        composable<AuthGraphRoutes.RegisterSuccess> {
            RegisterSuccessRoot(
                onLoginClick = {
                    navController.navigate(AuthGraphRoutes.Login) {
                        popUpTo<AuthGraphRoutes.RegisterSuccess> {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<AuthGraphRoutes.EmailVerification>(
            deepLinks = listOf(
                navDeepLink {
                    this.uriPattern =
                        "https://pombo-d341e.rj.r.appspot.com/api/v1/auth/verify?token={token}"
                },
                navDeepLink {
                    this.uriPattern =
                        "pombo://pombo-d341e.rj.r.appspot.com/api/v1/auth/verify?token={token}"
                }
            )
        ) {
            EmailVerificationRoot(
                onLoginClick = {
                    navController.navigate(AuthGraphRoutes.Login) {
                        popUpTo<AuthGraphRoutes.EmailVerification> {
                            inclusive = true
                        }
                    }
                },
                onCloseClick = {
                    navController.navigate(AuthGraphRoutes.Login) {
                        popUpTo<AuthGraphRoutes.EmailVerification> {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
    composable<AuthGraphRoutes.ForgotPassword> {
        ForgotPasswordRoot()
    }
    composable<AuthGraphRoutes.ResetPassword>(
        deepLinks = listOf(
            navDeepLink {
                this.uriPattern =
                    "https://pombo-d341e.rj.r.appspot.com/api/v1/auth/reset-password?token={token}"
            },
            navDeepLink {
                this.uriPattern =
                    "pombo://pombo-d341e.rj.r.appspot.com/api/v1/auth/reset-password?token={token}"
            }
        )
    ) {
        ResetPasswordRoot()
    }
}