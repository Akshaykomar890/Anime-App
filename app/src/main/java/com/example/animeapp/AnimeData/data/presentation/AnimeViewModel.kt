package com.example.animeapp.AnimeData.data.presentation

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
class AnimeViewModel @Inject constructor(
   private val repository: AnimeRepository
):ViewModel() {

    private val _animeListState = MutableStateFlow(AnimeState())

    val animeListState = _animeListState.asStateFlow()


    init {
        viewModelScope.launch {
            _animeListState.update {
                it.copy(isLoading = true)
            }
                repository.getAnimeList().collectLatest {
                    result->
                    when(result){

                        is GetResult.Success -> {
                            result.data?.let {
                                animeList->
                                _animeListState.update {
                                  it.copy(_animeListState.value.animeList + animeList,isLoading = false )
                                }
                            }
                        }

                        is GetResult.Failure -> {
                            _animeListState.update {
                                it.copy(
                                    isLoading = false
                                )
                            }

                        }
                        is GetResult.Loading -> {
                            _animeListState.update {
                                it.copy(
                                    isLoading = result.isLoading
                                )
                            }

                        }
                    }
                }
        }
    }





}