package com.ttlabz.auth.presentation.login

import androidx.compose.foundation.text.input.TextFieldState
import com.ttlabz.core.presentation.util.UiText

data class LoginScreenState(
    val emailTextFieldState: TextFieldState = TextFieldState(),
    val passwordTextFieldState: TextFieldState = TextFieldState(),
    val isPasswordVisible: Boolean = false,
    val canLogin: Boolean = false,
    val isLoggingIn: Boolean = false,
    val error: UiText? = null
)