package com.ttlabz.auth.presentation.email_verification

import com.ttlabz.core.presentation.util.UiText

data class EmailVerificationState(
    val isVerifying: Boolean = false,
    val isVerified: Boolean = false,
    val verificationError: UiText? = null
)