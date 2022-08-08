package com.top100.common

import com.top100.common.api.ApiCallHandler
import com.top100.common.api.ApiCallHandlerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class CommonModule {
    @Provides
    @Singleton
    fun provideApiCallHandler(): ApiCallHandler {
        return ApiCallHandlerImpl(
            dispatcher = Dispatchers.IO,
            numRetries = 3
        )
    }
}
