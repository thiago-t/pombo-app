package com.ttlabz.auth.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ttlabz.core.designsystem.components.brand.PomboBrandLogo
import com.ttlabz.core.designsystem.components.buttons.PomboButton
import com.ttlabz.core.designsystem.components.buttons.PomboButtonStyle
import com.ttlabz.core.designsystem.components.layouts.PomboAdaptiveFormLayout
import com.ttlabz.core.designsystem.components.layouts.PomboSnackbarScaffold
import com.ttlabz.core.designsystem.components.textfields.PomboPasswordTextField
import com.ttlabz.core.designsystem.components.textfields.PomboTextField
import com.ttlabz.core.designsystem.theme.PomboTheme
import com.ttlabz.core.presentation.util.ObserveAsEvents
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import pombo.feature.auth.presentation.generated.resources.Res
import pombo.feature.auth.presentation.generated.resources.create_account
import pombo.feature.auth.presentation.generated.resources.email
import pombo.feature.auth.presentation.generated.resources.email_placeholder
import pombo.feature.auth.presentation.generated.resources.forgot_password
import pombo.feature.auth.presentation.generated.resources.login
import pombo.feature.auth.presentation.generated.resources.password
import pombo.feature.auth.presentation.generated.resources.welcome_back

@Composable
fun LoginScreenRoot(
    viewModel: LoginScreenViewModel = koinViewModel(),
    onLoginSuccess: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onCreateAccountClick: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ObserveAsEvents(viewModel.events) { event ->
        when (event) {
            LoginEvent.Success -> onLoginSuccess()
        }
    }

    LoginScreen(
        state = state,
        onAction = { action ->
            when (action) {
                LoginScreenAction.OnForgotPasswordClick -> onForgotPasswordClick()
                LoginScreenAction.OnSignUpClick -> onCreateAccountClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
fun LoginScreen(
    state: LoginScreenState,
    onAction: (LoginScreenAction) -> Unit,
) {
    PomboSnackbarScaffold {
        PomboAdaptiveFormLayout(
            headerText = stringResource(Res.string.welcome_back),
            errorText = state.error?.asString(),
            logo = { PomboBrandLogo() },
            modifier = Modifier.fillMaxSize()
        ) {
            PomboTextField(
                state = state.emailTextFieldState,
                placeholder = stringResource(Res.string.email_placeholder),
                singleLine = true,
                keyboardType = KeyboardType.Email,
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(Res.string.email),
            )
            Spacer(modifier = Modifier.height(8.dp))
            PomboPasswordTextField(
                state = state.passwordTextFieldState,
                placeholder = stringResource(Res.string.password),
                modifier = Modifier.fillMaxWidth(),
                isPasswordVisible = state.isPasswordVisible,
                onToggleVisibilityClick = {
                    onAction(LoginScreenAction.OnTogglePasswordVisibility)
                },
                title = stringResource(Res.string.password),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(Res.string.forgot_password),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        onAction(LoginScreenAction.OnForgotPasswordClick)
                    }
            )
            Spacer(modifier = Modifier.height(24.dp))
            PomboButton(
                text = stringResource(Res.string.login),
                onClick = {
                    onAction(LoginScreenAction.OnLoginClick)
                },
                enabled = state.canLogin,
                isLoading = state.isLoggingIn,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            PomboButton(
                text = stringResource(Res.string.create_account),
                onClick = {
                    onAction(LoginScreenAction.OnSignUpClick)
                },
                style = PomboButtonStyle.SECONDARY,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun LightThemePreview() {
    PomboTheme {
        LoginScreen(
            state = LoginScreenState(),
            onAction = {}
        )
    }
}

@Preview
@Composable
private fun DarkThemePreview() {
    PomboTheme(darkTheme = true) {
        LoginScreen(
            state = LoginScreenState(),
            onAction = {}
        )
    }
}