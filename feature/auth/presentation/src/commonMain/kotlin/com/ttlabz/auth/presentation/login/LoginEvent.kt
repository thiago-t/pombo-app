package com.ttlabz.auth.presentation.login

sealed interface LoginEvent {
    data object Success: LoginEvent
}