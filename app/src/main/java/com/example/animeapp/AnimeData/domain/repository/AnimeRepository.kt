package com.example.animeapp.AnimeData.domain.repository


import com.example.animeapp.AnimeData.domain.model.AnimeList
import com.example.animeapp.AnimeData.util.GetResult
import kotlinx.coroutines.flow.Flow


interface AnimeRepository {

    suspend fun getAnimeList(): Flow<GetResult<List<AnimeList>>>

    suspend fun getAnimeById(id:Int):Flow<GetResult<AnimeList?>>

}