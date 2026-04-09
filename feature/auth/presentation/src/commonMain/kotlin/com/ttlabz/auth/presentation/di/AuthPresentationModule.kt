package com.ttlabz.auth.presentation.di

import com.ttlabz.auth.presentation.email_verification.EmailVerificationViewModel
import com.ttlabz.auth.presentation.forgot_password.ForgotPasswordViewModel
import com.ttlabz.auth.presentation.login.LoginScreenViewModel
import com.ttlabz.auth.presentation.register.RegisterViewModel
import com.ttlabz.auth.presentation.register_success.RegisterSuccessViewModel
import com.ttlabz.auth.presentation.reset_password.ResetPasswordViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authPresentationModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::RegisterSuccessViewModel)
    viewModelOf(::EmailVerificationViewModel)
    viewModelOf(::LoginScreenViewModel)
    viewModelOf(::ForgotPasswordViewModel)
    viewModelOf(::ResetPasswordViewModel)
}