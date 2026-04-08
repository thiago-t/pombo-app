package com.ttlabz.core.domain.auth

import com.ttlabz.core.domain.util.DataError
import com.ttlabz.core.domain.util.EmptyResult

interface AuthService {

    suspend fun register(
        email: String,
        username: String,
        password: String,
    ): EmptyResult<DataError.Remote>

    suspend fun resendVerificationEmail(
        email: String
    ): EmptyResult<DataError.Remote>

    suspend fun verifyEmail(token: String): EmptyResult<DataError.Remote>

}