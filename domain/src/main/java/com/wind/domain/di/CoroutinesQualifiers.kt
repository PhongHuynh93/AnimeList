package com.wind.domain.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
internal annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
internal annotation class IoDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
internal annotation class MainDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
internal annotation class MainImmediateDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
internal annotation class ApplicationScope
