package com.ttlabz.auth.presentation.login

sealed interface LoginScreenAction {
    data object OnTogglePasswordVisibility : LoginScreenAction
    data object OnForgotPasswordClick : LoginScreenAction
    data object OnLoginClick : LoginScreenAction
    data object OnSignUpClick : LoginScreenAction
}