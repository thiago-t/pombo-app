package com.ttlabz.auth.presentation.forgot_password

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ttlabz.core.designsystem.components.brand.PomboBrandLogo
import com.ttlabz.core.designsystem.components.buttons.PomboButton
import com.ttlabz.core.designsystem.components.layouts.PomboAdaptiveFormLayout
import com.ttlabz.core.designsystem.components.textfields.PomboTextField
import com.ttlabz.core.designsystem.theme.PomboTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pombo.feature.auth.presentation.generated.resources.Res
import pombo.feature.auth.presentation.generated.resources.email
import pombo.feature.auth.presentation.generated.resources.email_placeholder
import pombo.feature.auth.presentation.generated.resources.submit
import pombo.feature.auth.presentation.generated.resources.title_forgot_password

@Composable
fun ForgotPasswordRoot(
    viewModel: ForgotPasswordViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ForgotPasswordScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun ForgotPasswordScreen(
    state: ForgotPasswordState,
    onAction: (ForgotPasswordAction) -> Unit,
) {
    PomboAdaptiveFormLayout(
        headerText = stringResource(Res.string.title_forgot_password),
        errorText = state.errorText?.asString(),
        logo = { PomboBrandLogo() }
    ) {
        PomboTextField(
            state = state.emailTextFieldState,
            modifier = Modifier.fillMaxWidth(),
            placeholder = stringResource(Res.string.email_placeholder),
            title = stringResource(Res.string.email),
            isError = state.emailError != null,
            supportingText = state.errorText?.asString(),
            keyboardType = KeyboardType.Email,
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        PomboButton(
            text = stringResource(Res.string.submit),
            onClick = {
                onAction(ForgotPasswordAction.OnSubmitClick)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !state.isLoading && state.canSubmit,
            isLoading = state.isLoading
        )
    }
}

@Preview
@Composable
private fun Preview() {
    PomboTheme {
        ForgotPasswordScreen(
            state = ForgotPasswordState(),
            onAction = {}
        )
    }
}