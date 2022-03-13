package com.yusuftalhaklc.pokedex.model

import com.google.gson.annotations.SerializedName

data class OtherX(
    val dream_world: DreamWorldX,
    val home: Home,
    @SerializedName("official-artwork")
    val official_artwork: OfficialArtwork
)