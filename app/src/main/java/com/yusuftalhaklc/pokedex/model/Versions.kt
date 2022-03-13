package com.yusuftalhaklc.pokedex.model

import com.google.gson.annotations.SerializedName

data class Versions(/*
    val generation-i: GenerationI,
    val generation-ii: GenerationIi,
    val generation-iii: GenerationIii,
    val generation-iv: GenerationIv,
    val generation-v: GenerationV,
    val generation-vi: GenerationVi,
    val generation-vii: GenerationVii,*/
    @SerializedName("generation-viii")
    val generation_viii: GenerationViii
)