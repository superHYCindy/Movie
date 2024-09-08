package com.superheeyoung.movie.features.common.entity

sealed class BaseEntity<T> {
    data class Success<T>(val entity : T) : BaseEntity<T>()
    data class Fail<T>(val error : Throwable) : BaseEntity<T>()
}