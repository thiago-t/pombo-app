package com.ttlabz.auth.presentation.register_success

sealed interface RegisterSuccessAction {
    object OnLoginClick : RegisterSuccessAction
    object OnResendVerificationEmailClick : RegisterSuccessAction
}