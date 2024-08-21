package com.example.animeapp.AnimeData.data.remote

import com.example.animeapp.AnimeData.data.remote.AnimeDto.AnimeListDto
import com.example.animeapp.AnimeData.data.remote.AnimeDto.AnimeResponseDto
import com.example.animeapp.AnimeData.data.remote.AnimeDto.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface AnimeApi {


    @GET("trending/anime")
    suspend fun getAnimeList():ApiResponse

    @GET("anime/{id}")
    suspend fun getAnimeById(
        @Path("id") id:Int
    ):AnimeResponseDto?

    companion object{
        val BASE_URL = "https://kitsu.io/api/edge/"
    }


}