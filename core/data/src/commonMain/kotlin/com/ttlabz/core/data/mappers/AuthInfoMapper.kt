package com.ttlabz.core.data.mappers

import com.ttlabz.core.data.dto.AuthInfoSerializable
import com.ttlabz.core.data.dto.UserSerializable
import com.ttlabz.core.domain.auth.AuthInfo
import com.ttlabz.core.domain.auth.User

fun AuthInfoSerializable.toDomain(): AuthInfo {
    return AuthInfo(
        accessToken = accessToken,
        refreshToken = refreshToken,
        user = user.toDomain()
    )
}

fun UserSerializable.toDomain(): User {
    return User(
        id = id,
        email = email,
        username = username,
        hasVerifiedEmail = hasVerifiedEmail,
        profilePictureUrl = profilePictureUrl
    )
}