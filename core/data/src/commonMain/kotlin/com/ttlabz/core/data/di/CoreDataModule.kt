package com.ttlabz.core.data.di

import com.ttlabz.core.data.auth.DataStoreSessionStorage
import com.ttlabz.core.data.auth.KtorAuthService
import com.ttlabz.core.data.logging.KermitLogger
import com.ttlabz.core.data.networking.HttpClientFactory
import com.ttlabz.core.domain.auth.AuthService
import com.ttlabz.core.domain.auth.SessionStorage
import com.ttlabz.core.domain.logging.PomboLogger
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformCoreDataModule: Module

val coreDataModule = module {
    includes(platformCoreDataModule)
    single<PomboLogger> { KermitLogger }
    single {
        HttpClientFactory(
            pomboLogger = get(),
            sessionStorage = get()
        ).create(engine = get())
    }
    singleOf(::KtorAuthService) bind AuthService::class
    singleOf(::DataStoreSessionStorage) bind SessionStorage::class
}