package com.moizest89.ionix_test.framework

sealed class LiveDataResource< out T> {
    data class Success< out T >( val data: T ) : LiveDataResource<T>()
    data class Loading< out T >( val  partialData : T? = null) : LiveDataResource<T>()
    data class Failure< out T >( val error: Throwable ) : LiveDataResource<T>()

    val extractData: T? get() = when (this) {
        is Success -> data
        is Loading -> partialData
        is Failure -> null
    }

    fun onSuccess(onSuccess: (data: T) -> Unit) = apply{
        if (this is Success)
            onSuccess.invoke( data )

        return this
    }

    fun onLoading(onLoading: (partialData: T?) -> Unit) = apply{
        if (this is Loading)
            onLoading.invoke( partialData )

        return this
    }

    fun onFailure( onFailure: ( error: Throwable?) -> Unit) : LiveDataResource<T> {
        if (this is Failure)
            onFailure.invoke( error )

        return this
    }
}