package com.superheeyoung.movie.features.common.mapper

import com.superheeyoung.movie.features.common.entity.BaseEntity
import com.superheeyoung.movie.features.common.network.ApiResponse

abstract class BaseEntityMapper<M, E> {
    fun transform(response: ApiResponse<M>): BaseEntity<E> =
        when (response) {
            is ApiResponse.Fail -> getFailure(response.error)
            is ApiResponse.Success -> getSuccess(response.data)
        }

    abstract fun getSuccess(model: M?): BaseEntity.Success<E>

    abstract fun getFailure(error: Throwable): BaseEntity.Fail<E>
}
