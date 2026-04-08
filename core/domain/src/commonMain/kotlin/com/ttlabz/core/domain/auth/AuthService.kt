package com.ttlabz.core.domain.auth

import com.ttlabz.core.domain.util.DataError
import com.ttlabz.core.domain.util.EmptyResult

interface AuthService {

    suspend fun register(
        email: String,
        username: String,
        password: String,
    ): EmptyResult<DataError.Remote>

}