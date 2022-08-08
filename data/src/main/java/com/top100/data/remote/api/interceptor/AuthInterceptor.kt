package com.top100.data.remote.api.interceptor

import javax.inject.Inject
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        chain.request().run {
            val urlWithApiKey = url.newBuilder()
                .build()
            val request = newBuilder()
                .url(urlWithApiKey)
                .build()

            return chain.proceed(request)
        }
    }

    companion object {
        private const val PARAM_API_KEY = "api_key"
    }
}
