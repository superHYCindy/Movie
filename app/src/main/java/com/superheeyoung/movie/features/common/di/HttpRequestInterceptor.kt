package com.superheeyoung.movie.features.common.di

import okhttp3.Interceptor
import okhttp3.Response

internal class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .run {
                    this.addHeader("Authorization: Bearer", "yJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyZThmZmY5YzM0ZTE5MjgxYjViMTQ1ODQyNjY1MjE5YSIsIm5iZiI6MTcyNTQ5NzUyMS4zOTkxNTIsInN1YiI6IjY2ZDhmZjNlOGU5MzQxMGQ3ODE4MzUzOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.7WTvphlsYbhuNHKaOcBFIgPm27rOxpy1rkmt8H6SmdU")
                }
                .build()
        )
    }
}