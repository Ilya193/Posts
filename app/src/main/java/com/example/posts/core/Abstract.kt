package com.example.posts.core

import com.example.posts.R
import retrofit2.HttpException
import java.net.UnknownHostException

abstract class Abstract {

    interface Object<T, M : Mapper> {
        fun map(mapper: M): T
    }

    interface Mapper {
        interface Data<S, R> : Mapper {
            fun map(data: S): R
        }

        interface DataToDomain<S, R> : Data<S, R> {
            fun map(e: Exception): R

            abstract class Base<S, R> : DataToDomain<S, R> {
                protected fun errorType(e: Exception) = when (e) {
                    is UnknownHostException -> ErrorType.NO_CONNECTION
                    is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                    else -> ErrorType.GENERIC_ERROR
                }
            }
        }

        interface DomainToUi<S, T> : Data<S, T> {
            fun map(errorType: ErrorType): T

            abstract class Base<S, T>(
                private val resourceProvider: ResourceProvider
            ) : DomainToUi<S, T> {
                protected fun errorMessage(errorType: ErrorType): String {
                    return resourceProvider.getString(
                        when (errorType) {
                            ErrorType.NO_CONNECTION -> R.string.no_connection
                            ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable
                            ErrorType.GENERIC_ERROR -> R.string.something_went_wrong
                        }
                    )
                }
            }
        }
    }

    interface DataObject

    interface CloudObject
}