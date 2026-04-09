package com.ttlabz.core.data.auth

import com.ttlabz.core.data.dto.AuthInfoSerializable
import com.ttlabz.core.data.dto.requests.EmailRequest
import com.ttlabz.core.data.dto.requests.LoginRequest
import com.ttlabz.core.data.dto.requests.RegisterRequest
import com.ttlabz.core.data.mappers.toDomain
import com.ttlabz.core.data.networking.get
import com.ttlabz.core.data.networking.post
import com.ttlabz.core.domain.auth.AuthInfo
import com.ttlabz.core.domain.auth.AuthService
import com.ttlabz.core.domain.util.DataError
import com.ttlabz.core.domain.util.EmptyResult
import com.ttlabz.core.domain.util.Result
import com.ttlabz.core.domain.util.map
import io.ktor.client.HttpClient

class KtorAuthService(
    private val httpClient: HttpClient
) : AuthService {

    override suspend fun login(
        email: String,
        password: String
    ): Result<AuthInfo, DataError.Remote> {
        return httpClient.post<LoginRequest, AuthInfoSerializable>(
            route = "api/v1/auth/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        ).map { authInfoSerializable ->
            authInfoSerializable.toDomain()
        }
    }

    override suspend fun register(
        email: String,
        username: String,
        password: String
    ): EmptyResult<DataError.Remote> {
        return httpClient.post(
            route = "/api/v1/auth/register",
            body = RegisterRequest(
                email = email,
                username = username,
                password = password
            )
        )
    }

    override suspend fun resendVerificationEmail(email: String): EmptyResult<DataError.Remote> {
        return httpClient.post(
            route = "/api/v1/auth/resend-verification",
            body = EmailRequest(email)
        )
    }

    override suspend fun verifyEmail(token: String): EmptyResult<DataError.Remote> {
        return httpClient.get(
            route = "/api/v1/auth/verify",
            queryParams = mapOf("token" to token)
        )
    }

}