package com.superheeyoung.movie.features.common.di

import okhttp3.Interceptor
import okhttp3.Response

internal class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .run {
                    addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyZThmZmY5YzM0ZTE5MjgxYjViMTQ1ODQyNjY1MjE5YSIsIm5iZiI6MTcyNTYzMDE2NS45MzI0NjUsInN1YiI6IjY2ZDhmZjNlOGU5MzQxMGQ3ODE4MzUzOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.O97_EsdYFK4RTMg9T5C0M7nQOsNjHenGvWrP2BUkEbE")
                }
                .build()
        )
    }
}