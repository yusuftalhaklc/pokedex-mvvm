package com.yusuftalhaklc.pokedex.model

data class PokedexFeedList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)