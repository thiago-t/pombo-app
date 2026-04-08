package com.ttlabz.auth.presentation.email_verification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ttlabz.core.designsystem.components.brand.PomboFailureIcon
import com.ttlabz.core.designsystem.components.brand.PomboSuccessIcon
import com.ttlabz.core.designsystem.components.buttons.PomboButton
import com.ttlabz.core.designsystem.components.buttons.PomboButtonStyle
import com.ttlabz.core.designsystem.components.layouts.PomboAdaptiveResultLayout
import com.ttlabz.core.designsystem.components.layouts.PomboSimpleResultLayout
import com.ttlabz.core.designsystem.theme.PomboTheme
import com.ttlabz.core.designsystem.theme.extended
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pombo.feature.auth.presentation.generated.resources.Res
import pombo.feature.auth.presentation.generated.resources.close
import pombo.feature.auth.presentation.generated.resources.email_verification_failed
import pombo.feature.auth.presentation.generated.resources.email_verification_failed_description
import pombo.feature.auth.presentation.generated.resources.email_verified_successfully
import pombo.feature.auth.presentation.generated.resources.email_verified_successfully_description
import pombo.feature.auth.presentation.generated.resources.login
import pombo.feature.auth.presentation.generated.resources.verifying_account

@Composable
fun EmailVerificationRoot(
    viewModel: EmailVerificationViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    EmailVerificationScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun EmailVerificationScreen(
    state: EmailVerificationState,
    onAction: (EmailVerificationAction) -> Unit,
) {
    PomboAdaptiveResultLayout {
        when {
            state.isVerifying -> {
                VerifyingContent(
                    modifier = Modifier.fillMaxWidth()
                )
            }

            state.isVerified -> {
                PomboSimpleResultLayout(
                    title = stringResource(Res.string.email_verified_successfully),
                    description = stringResource(Res.string.email_verified_successfully_description),
                    icon = { PomboSuccessIcon() },
                    primaryButton = {
                        PomboButton(
                            text = stringResource(Res.string.login),
                            onClick = {
                                onAction(EmailVerificationAction.OnLoginClick)
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                )
            }

            else -> {
                PomboSimpleResultLayout(
                    title = stringResource(Res.string.email_verification_failed),
                    description = stringResource(Res.string.email_verification_failed_description),
                    icon = {
                        Spacer(modifier = Modifier.height(32.dp))
                        PomboFailureIcon(modifier = Modifier.size(80.dp))
                        Spacer(modifier = Modifier.height(32.dp))
                    },
                    primaryButton = {
                        PomboButton(
                            text = stringResource(Res.string.close),
                            onClick = {
                                onAction(EmailVerificationAction.OnCloseClick)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            style = PomboButtonStyle.SECONDARY
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun VerifyingContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .heightIn(min = 200.dp)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringResource(Res.string.verifying_account),
            color = MaterialTheme.colorScheme.extended.textSecondary,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
private fun EmailVerificationErrorPreview() {
    PomboTheme {
        EmailVerificationScreen(
            state = EmailVerificationState(),
            onAction = {}
        )
    }
}

@Preview
@Composable
private fun EmailVerificationVerifyingPreview() {
    PomboTheme {
        EmailVerificationScreen(
            state = EmailVerificationState(
                isVerifying = true
            ),
            onAction = {}
        )
    }
}

@Preview
@Composable
private fun EmailVerificationSuccessPreview() {
    PomboTheme {
        EmailVerificationScreen(
            state = EmailVerificationState(
                isVerified = true
            ),
            onAction = {}
        )
    }
}