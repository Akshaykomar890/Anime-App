package com.example.animeapp.AnimeData.domain.model

data class AnimeList(
    val attributes: Attributes,
    val id: String,
    val type: String
)

data class Attributes(
    val ageRating: String,
    val averageRating: String,
    val canonicalTitle: String,
    val coverImage: CoverImage,
    val coverImageTopOffset: Int,
    val createdAt: String,
    val description: String,
    val endDate: Any,
    val episodeCount: Any,
    val episodeLength: Int,
    val favoritesCount: Int,
    val nextRelease: String,
    val nsfw: Boolean,
    val popularityRank: Int,
    val posterImage: PosterImage,
    val ratingFrequencies: RatingFrequencies,
    val ratingRank: Int,
    val showType: String,
    val slug: String,
    val startDate: String,
    val status: String,
    val subtype: String,
    val synopsis: String,
    val tba: Any,
    val titles: Titles,
    val totalLength: Int,
    val updatedAt: String,
    val userCount: Int,
    val youtubeVideoId: String
)

data class CoverImage(
    val large: String,
    val original: String,
    val small: String,
    val tiny: String
)

data class PosterImage(
    val large: String,
    val medium: String,
    val original: String,
    val small: String,
    val tiny: String
)

data class RatingFrequencies(
    val `10`: String,
    val `11`: String,
    val `12`: String,
    val `13`: String,
    val `14`: String,
    val `15`: String,
    val `16`: String,
    val `17`: String,
    val `18`: String,
    val `19`: String,
    val `2`: String,
    val `20`: String,
    val `3`: String,
    val `4`: String,
    val `5`: String,
    val `6`: String,
    val `7`: String,
    val `8`: String,
    val `9`: String
)

data class Titles(
    val en: String,
    val en_jp: String,
    val ja_jp: String
)