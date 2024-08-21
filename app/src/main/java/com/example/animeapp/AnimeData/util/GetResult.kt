package com.example.animeapp.AnimeData.util

sealed class GetResult<T>(
    val data:T? = null,
    val message:String? = null
) {

    class Success<T>(data: T?):GetResult<T>(data)

    class Failure<T>(data: T? = null, message: String):GetResult<T>(data,message)

    class Loading<T>(val isLoading:Boolean):GetResult<T>(null)



}