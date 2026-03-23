package com.ttlabz.pombo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform