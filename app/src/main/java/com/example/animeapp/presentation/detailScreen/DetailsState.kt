package com.example.animeapp.presentation.detailScreen

import com.example.animeapp.AnimeData.domain.model.AnimeList

data class DetailsState(
    val isLoading:Boolean = false,
    val animeId:AnimeList? = null
)
