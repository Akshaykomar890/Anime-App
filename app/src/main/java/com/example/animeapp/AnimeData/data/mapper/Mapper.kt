package com.example.animeapp.AnimeData.data.mapper


import com.example.animeapp.AnimeData.data.remote.AnimeDto.AnimeListDto
import com.example.animeapp.AnimeData.domain.model.AnimeList
import com.example.animeapp.AnimeData.domain.model.Attributes
import com.example.animeapp.AnimeData.domain.model.CoverImage
import com.example.animeapp.AnimeData.domain.model.PosterImage
import com.example.animeapp.AnimeData.domain.model.RatingFrequencies
import com.example.animeapp.AnimeData.domain.model.Titles


fun AnimeListDto.toAnimeList(): AnimeList {
    return AnimeList(
        id = id ?: "",
        type = type ?: "",
        attributes = Attributes(
            ageRating = attributes?.ageRating ?: "",
            averageRating = attributes?.averageRating ?: "",
            canonicalTitle = attributes?.canonicalTitle ?: "",
            coverImage = CoverImage(
                large = attributes?.coverImage?.large ?: "",
                original = attributes?.coverImage?.original ?: "",
                small = attributes?.coverImage?.small ?: "",
                tiny = attributes?.coverImage?.tiny ?: ""
            ),
            coverImageTopOffset = attributes?.coverImageTopOffset ?: 0,
            createdAt = attributes?.createdAt ?: "",
            description = attributes?.description ?: "",
            endDate = attributes?.endDate?:"",
            episodeCount = attributes?.episodeCount?:"",
            episodeLength = attributes?.episodeLength ?: 0,
            favoritesCount = attributes?.favoritesCount ?: 0,
            nextRelease = attributes?.nextRelease ?: "",
            nsfw = attributes?.nsfw ?: false,
            popularityRank = attributes?.popularityRank ?: 0,
            posterImage = PosterImage(
                large = attributes?.posterImage?.large ?: "",
                medium = attributes?.posterImage?.medium ?: "",
                original = attributes?.posterImage?.original ?: "",
                small = attributes?.posterImage?.small ?: "",
                tiny = attributes?.posterImage?.tiny ?: ""
            ),
            ratingFrequencies = RatingFrequencies(
                `10` = attributes?.ratingFrequencies?.`10` ?: "",
                `11` = attributes?.ratingFrequencies?.`11` ?: "",
                `12` = attributes?.ratingFrequencies?.`12` ?: "",
                `13` = attributes?.ratingFrequencies?.`13` ?: "",
                `14` = attributes?.ratingFrequencies?.`14` ?: "",
                `15` = attributes?.ratingFrequencies?.`15` ?: "",
                `16` = attributes?.ratingFrequencies?.`16` ?: "",
                `17` = attributes?.ratingFrequencies?.`17` ?: "",
                `18` = attributes?.ratingFrequencies?.`18` ?: "",
                `19` = attributes?.ratingFrequencies?.`19` ?: "",
                `2` = attributes?.ratingFrequencies?.`2` ?: "",
                `20` = attributes?.ratingFrequencies?.`20` ?: "",
                `3` = attributes?.ratingFrequencies?.`3` ?: "",
                `4` = attributes?.ratingFrequencies?.`4` ?: "",
                `5` = attributes?.ratingFrequencies?.`5` ?: "",
                `6` = attributes?.ratingFrequencies?.`6` ?: "",
                `7` = attributes?.ratingFrequencies?.`7` ?: "",
                `8` = attributes?.ratingFrequencies?.`8` ?: "",
                `9` = attributes?.ratingFrequencies?.`9` ?: ""
            ),
            ratingRank = attributes?.ratingRank ?: 0,
            showType = attributes?.showType ?: "",
            slug = attributes?.slug ?: "",
            startDate = attributes?.startDate ?: "",
            status = attributes?.status ?: "",
            subtype = attributes?.subtype ?: "",
            synopsis = attributes?.synopsis ?: "",
            tba = attributes?.tba?:"",
            titles = Titles(
                en = attributes?.titles?.en ?: "",
                en_jp = attributes?.titles?.en_jp ?: "",
                ja_jp = attributes?.titles?.ja_jp ?: ""
            ),
            totalLength = attributes?.totalLength ?: 0,
            updatedAt = attributes?.updatedAt ?: "",
            userCount = attributes?.userCount ?: 0,
            youtubeVideoId = attributes?.youtubeVideoId ?: "",
        )
    )
}