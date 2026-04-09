package com.ttlabz.pombo

sealed interface MainEvent {
    data object OnSessionExpired: MainEvent
}