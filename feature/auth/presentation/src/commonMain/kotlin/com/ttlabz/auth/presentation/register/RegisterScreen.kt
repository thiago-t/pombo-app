package com.ttlabz.auth.presentation.register

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ttlabz.core.designsystem.components.brand.PomboBrandLogo
import com.ttlabz.core.designsystem.components.buttons.PomboButton
import com.ttlabz.core.designsystem.components.buttons.PomboButtonStyle
import com.ttlabz.core.designsystem.components.layouts.PomboAdaptiveFormLayout
import com.ttlabz.core.designsystem.components.layouts.PomboSnackbarScaffold
import com.ttlabz.core.designsystem.components.textfields.PomboPasswordTextField
import com.ttlabz.core.designsystem.components.textfields.PomboTextField
import com.ttlabz.core.designsystem.theme.PomboTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pombo.feature.auth.presentation.generated.resources.Res
import pombo.feature.auth.presentation.generated.resources.email
import pombo.feature.auth.presentation.generated.resources.email_placeholder
import pombo.feature.auth.presentation.generated.resources.login
import pombo.feature.auth.presentation.generated.resources.password
import pombo.feature.auth.presentation.generated.resources.password_hint
import pombo.feature.auth.presentation.generated.resources.register
import pombo.feature.auth.presentation.generated.resources.username
import pombo.feature.auth.presentation.generated.resources.username_hint
import pombo.feature.auth.presentation.generated.resources.username_placeholder
import pombo.feature.auth.presentation.generated.resources.welcome_to_pombo

@Composable
fun RegisterRoot(
    viewModel: RegisterViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    RegisterScreen(
        state = state,
        onAction = viewModel::onAction,
        snackbarHostState = snackbarHostState,
    )
}

@Composable
fun RegisterScreen(
    state: RegisterState,
    onAction: (RegisterAction) -> Unit,
    snackbarHostState: SnackbarHostState,
) {
    PomboSnackbarScaffold(
        snackbarHostState = snackbarHostState
    ) {
        PomboAdaptiveFormLayout(
            headerText = stringResource(Res.string.welcome_to_pombo),
            errorText = state.registrationError?.asString(),
            logo = { PomboBrandLogo() },
        ) {
            PomboTextField(
                state = state.usernameTextState,
                title = stringResource(Res.string.username),
                placeholder = stringResource(Res.string.username_placeholder),
                supportingText = state.usernameError?.asString()
                    ?: stringResource(Res.string.username_hint),
                isError = state.usernameError != null,
                onFocusChanged = {
                    onAction(RegisterAction.OnInputTextFocusGain)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            PomboTextField(
                state = state.emailTextState,
                title = stringResource(Res.string.email),
                placeholder = stringResource(Res.string.email_placeholder),
                supportingText = state.emailError?.asString(),
                isError = state.emailError != null,
                onFocusChanged = {
                    onAction(RegisterAction.OnInputTextFocusGain)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            PomboPasswordTextField(
                state = state.passwordTextState,
                title = stringResource(Res.string.password),
                placeholder = stringResource(Res.string.password),
                supportingText = state.passwordError?.asString()
                    ?: stringResource(Res.string.password_hint),
                isError = state.passwordError != null,
                onFocusChanged = {
                    onAction(RegisterAction.OnInputTextFocusGain)
                },
                onToggleVisibilityClick = {
                    onAction(RegisterAction.OnTogglePasswordVisibilityClick)
                },
                isPasswordVisible = state.isPasswordVisible
            )
            Spacer(modifier = Modifier.height(16.dp))

            PomboButton(
                text = stringResource(Res.string.register),
                onClick = {
                    onAction(RegisterAction.OnRegisterClick)
                },
                enabled = state.canRegister,
                isLoading = state.isRegistering,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            PomboButton(
                text = stringResource(Res.string.login),
                onClick = {
                    onAction(RegisterAction.OnLoginClick)
                },
                style = PomboButtonStyle.SECONDARY,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PomboTheme {
        RegisterScreen(
            state = RegisterState(),
            onAction = {},
            snackbarHostState = remember { SnackbarHostState() }
        )
    }
}