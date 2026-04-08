package com.ttlabz.auth.presentation.di

import com.ttlabz.auth.presentation.email_verification.EmailVerificationViewModel
import com.ttlabz.auth.presentation.register.RegisterViewModel
import com.ttlabz.auth.presentation.register_success.RegisterSuccessViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authPresentationModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::RegisterSuccessViewModel)
    viewModelOf(::EmailVerificationViewModel)
}