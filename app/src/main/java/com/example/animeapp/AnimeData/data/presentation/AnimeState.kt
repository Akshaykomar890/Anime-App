package com.example.animeapp.AnimeData.data.presentation

import com.example.animeapp.AnimeData.domain.model.AnimeList

data class AnimeState(
    val animeList:List<AnimeList> = emptyList(),

    val isLoading:Boolean = false,
)