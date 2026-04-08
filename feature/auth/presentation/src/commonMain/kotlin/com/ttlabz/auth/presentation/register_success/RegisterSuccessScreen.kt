package com.ttlabz.auth.presentation.register_success

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ttlabz.core.designsystem.components.brand.PomboSuccessIcon
import com.ttlabz.core.designsystem.components.buttons.PomboButton
import com.ttlabz.core.designsystem.components.buttons.PomboButtonStyle
import com.ttlabz.core.designsystem.components.layouts.PomboAdaptiveResultLayout
import com.ttlabz.core.designsystem.components.layouts.PomboSimpleSuccessLayout
import com.ttlabz.core.designsystem.theme.PomboTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import pombo.feature.auth.presentation.generated.resources.Res
import pombo.feature.auth.presentation.generated.resources.account_successfully_created
import pombo.feature.auth.presentation.generated.resources.login
import pombo.feature.auth.presentation.generated.resources.resend_verification_email
import pombo.feature.auth.presentation.generated.resources.verification_email_sent_to_x

@Composable
fun RegisterSuccessRoot(
    viewModel: RegisterSuccessViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    RegisterSuccessScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun RegisterSuccessScreen(
    state: RegisterSuccessState,
    onAction: (RegisterSuccessAction) -> Unit,
) {
    PomboAdaptiveResultLayout {
        PomboSimpleSuccessLayout(
            title = stringResource(Res.string.account_successfully_created),
            description = stringResource(
                Res.string.verification_email_sent_to_x,
                state.registeredEmail
            ),
            icon = { PomboSuccessIcon() },
            primaryButton = {
                PomboButton(
                    text = stringResource(Res.string.login),
                    onClick = {
                        onAction(RegisterSuccessAction.OnLoginClick)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            },
            secondaryButton = {
                PomboButton(
                    text = stringResource(Res.string.resend_verification_email),
                    onClick = {
                        onAction(RegisterSuccessAction.OnResendVerificationEmailClick)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !state.isResendingVerificationEmail,
                    isLoading = state.isResendingVerificationEmail,
                    style = PomboButtonStyle.SECONDARY
                )
            }
        )
    }
}

@Preview
@Composable
private fun Preview() {
    PomboTheme {
        RegisterSuccessScreen(
            state = RegisterSuccessState(
                registeredEmail = "th@ttlabz.com"
            ),
            onAction = {}
        )
    }
}