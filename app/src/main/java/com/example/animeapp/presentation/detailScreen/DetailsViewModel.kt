package com.example.animeapp.presentation.detailScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeapp.AnimeData.domain.repository.AnimeRepository
import com.example.animeapp.AnimeData.util.GetResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: AnimeRepository,
    private val savedStateHandle: SavedStateHandle
) :ViewModel() {

    private val animeId = savedStateHandle.get<Int>("id")

    private val _animeState = MutableStateFlow(DetailsState())

    val animeState = _animeState.asStateFlow()



    init {
        getAnimeId(animeId?:-1)
    }


    private fun getAnimeId(id:Int){

        viewModelScope.launch {

            _animeState.update {
                it.copy(isLoading = true)
            }


            repository.getAnimeById(id).collectLatest {
                result->
                when(result){
                    is GetResult.Failure -> {
                        _animeState.update {
                            it.copy(isLoading = true)
                        }

                    }
                    is GetResult.Loading -> {
                        _animeState.update {
                            it.copy(result.isLoading)
                        }

                    }
                    is GetResult.Success -> {
                        result.data?.let {
                            anime->
                            _animeState.update {
                                it.copy(animeId = anime, isLoading = false)
                            }
                        }
                    }
                }

            }

        }

    }


}