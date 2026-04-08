package com.ttlabz.core.data.auth

import com.ttlabz.core.data.dto.requests.RegisterRequest
import com.ttlabz.core.data.networking.post
import com.ttlabz.core.domain.auth.AuthService
import com.ttlabz.core.domain.util.DataError
import com.ttlabz.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class KtorAuthService(
    private val httpClient: HttpClient
) : AuthService {

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

}