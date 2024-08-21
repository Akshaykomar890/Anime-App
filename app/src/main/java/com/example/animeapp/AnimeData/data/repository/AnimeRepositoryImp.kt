package com.example.animeapp.AnimeData.data.repository

import coil.network.HttpException
import com.example.animeapp.AnimeData.data.mapper.toAnimeList
import com.example.animeapp.AnimeData.data.remote.AnimeApi
import com.example.animeapp.AnimeData.domain.model.AnimeList
import com.example.animeapp.AnimeData.domain.repository.AnimeRepository
import com.example.animeapp.AnimeData.util.GetResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject


class AnimeRepositoryImp @Inject constructor  (
   private val getApiData:AnimeApi
):AnimeRepository {
    override suspend fun getAnimeList(): Flow<GetResult<List<AnimeList>>> {
        return flow {
            emit(GetResult.Loading(true))

            val getData = try {
                getApiData.getAnimeList()
            }catch (e: IOException){
                e.printStackTrace()
                emit(GetResult.Failure(message = "Error Loading Data"))
                return@flow
            }catch (e: HttpException){
                e.printStackTrace()
                emit(GetResult.Failure(message = "Error Loading Data"))
                return@flow
            }catch (e: Exception) {
                e.printStackTrace()
                emit(GetResult.Failure(message = "Error loading movies"))
                return@flow
            }

            emit(GetResult.Success(
                data = getData.data.map {
                    it.toAnimeList()
                }
            ))

            emit(GetResult.Loading(false))
            return@flow
        }

    }




    override suspend fun getAnimeById(id: Int): Flow<GetResult<AnimeList?>> {
        return  flow {

            emit(GetResult.Loading(true))

            val getDataById = try {
                getApiData.getAnimeById(id)
            }catch (e: IOException){
                e.printStackTrace()
                emit(GetResult.Failure(message = "Error Loading Data"))
                return@flow
            }catch (e: HttpException){
                e.printStackTrace()
                emit(GetResult.Failure(message = "Error Loading Data"))
                return@flow
            }catch (e: Exception) {
                e.printStackTrace()
                emit(GetResult.Failure(message = "Error loading movies"))
                return@flow
            }


            emit(GetResult.Success(
                data = getDataById?.data?.toAnimeList()
            ))

            emit(GetResult.Loading(false))

            return@flow
        }
    }

}