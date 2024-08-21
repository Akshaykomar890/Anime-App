package com.example.animeapp.AnimeData.data.remote.AnimeDto


data class ApiResponse(
    val data: List<AnimeListDto>
)
data class AnimeResponseDto(
    val data: AnimeListDto
)


data class AnimeListDto(
    val id: String?,
    val type: String?,
    val links: LinksDto?,
    val attributes: AttributesDto?,
    val relationships: RelationshipsDto?
)

data class LinksDto(
    val self: String?
)
data class RelationshipsDto(
    val genres: LinksDto?,
    val categories: LinksDto?,
    val castings: LinksDto?,
    val installments: LinksDto?,
    val mappings: LinksDto?,
    val reviews: LinksDto?,
    val mediaRelationships: LinksDto?,
    val characters: LinksDto?,
    val staff: LinksDto?,
    val productions: LinksDto?,
    val quotes: LinksDto?,
    val episodes: LinksDto?,
    val streamingLinks: LinksDto?,
    val animeProductions: LinksDto?,
    val animeCharacters: LinksDto?,
    val animeStaff: LinksDto?
)