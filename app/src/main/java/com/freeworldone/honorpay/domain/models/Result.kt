@file:Suppress("UNCHECKED_CAST")

package com.freeworldone.honorpay.domain.models

import java.io.Serializable


sealed class Result<T : Any> : Serializable {

    data class Success<T : Any>(val value: T) : Result<T>()
    data class Failure<T : Any>(val exception: Exception) : Result<T>()

    val isSuccess: Boolean get() = this is Success
    val isFailure: Boolean get() = this is Failure

    fun getOrNull(): T? = when (this) {
        is Success -> value
        is Failure -> null
    }

    fun exceptionOrNull(): Throwable? = when (this) {
        is Failure -> exception
        is Success -> null
    }
}

inline fun <R : Any> runCatching(block: () -> R): Result<R> = try {
    Result.Success(block())
} catch (e: Exception) {
    Result.Failure(e)
}

inline fun <T, R : Any> T.runCatching(block: T.() -> R): Result<R> = try {
    Result.Success(block())
} catch (e: Exception) {
    Result.Failure(e)
}

inline fun <T : Any> Result<T>.onFailure(action: (exception: Throwable) -> Unit): Result<T> {
    exceptionOrNull()?.let { action(it) }
    return this
}

inline fun <T : Any> Result<T>.onSuccess(action: (value: T) -> Unit): Result<T> {
    if (this is Result.Success) action(value)
    return this
}
