package com.superheeyoung.movie.library.network.retrofit

import com.superheeyoung.movie.library.network.model.ApiResult
import com.superheeyoung.movie.library.network.model.NetworkRequestInfo
import java.lang.reflect.Type

interface NetworkRequestFactory {

    suspend fun <T> create(
        url: String,
        requestInfo: NetworkRequestInfo = NetworkRequestInfo.Builder().build(),
        type: Type
    ): ApiResult<T>
}
